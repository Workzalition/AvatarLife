package com.platform101xp.sdk.internal;

import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.platform101xp.sdk.Platform101XPError;
import com.platform101xp.sdk.api.http.Platform101XPHttpRequest;
import com.platform101xp.sdk.api.model.Platform101XPModel;
import com.platform101xp.sdk.api.parser.Platform101XPParser;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPRequestsKeeper {
    private static final int DEFAULT_RETRY_COUNT = 12;
    private static final String REQUEST_POOL_KEY = "p101xp_request_pool_key";
    private static Platform101XPRequestsKeeper instance;
    private Gson gson;
    private Type requestsType;
    private Set<Platform101XPHttpRequest> requestsPool = new HashSet();
    private RequestThreadWorker threadWorker = new RequestThreadWorker();
    private List<String> storedRequests = new ArrayList();

    private Platform101XPRequestsKeeper() {
        onRestoreRequestPool();
    }

    public static Platform101XPRequestsKeeper getInstance() {
        if (instance == null) {
            instance = new Platform101XPRequestsKeeper();
        }
        return instance;
    }

    public void addRequestToPool(Platform101XPHttpRequest platform101XPHttpRequest) {
        Set<Platform101XPHttpRequest> set = this.requestsPool;
        if (set == null) {
            return;
        }
        if (set.add(platform101XPHttpRequest)) {
            Log.d("101XP SDK", "RequestsKeeper addRequestToPool");
        }
        executeRequests();
    }

    public void removeRequestFromPool(Platform101XPHttpRequest platform101XPHttpRequest) {
        Set<Platform101XPHttpRequest> set = this.requestsPool;
        if (set != null && set.remove(platform101XPHttpRequest)) {
            Log.d("101XP SDK", "RequestsKeeper removeRequestFromPool");
        }
    }

    private void executeRequests() {
        Set<Platform101XPHttpRequest> set = this.requestsPool;
        if (set == null) {
            return;
        }
        for (Platform101XPHttpRequest platform101XPHttpRequest : set) {
            Log.d("101XP SDK", "RequestsKeeper executeRequests");
            this.threadWorker.executeCurrentRequest(platform101XPHttpRequest);
        }
    }

    public void executeKeptRequests() {
        this.threadWorker.stopWork();
        if (this.requestsPool.isEmpty()) {
            return;
        }
        Log.d("101XP SDK", "RequestsKeeper executeKeptRequests");
        for (final Platform101XPHttpRequest platform101XPHttpRequest : this.requestsPool) {
            platform101XPHttpRequest.execute(new Platform101XPHttpRequest.HttpRequestListener() { // from class: com.platform101xp.sdk.internal.Platform101XPRequestsKeeper.1
                @Override // com.platform101xp.sdk.api.http.Platform101XPHttpRequest.HttpRequestListener
                public void onResult(Platform101XPModel platform101XPModel, Platform101XPError platform101XPError) {
                    if (platform101XPError == null) {
                        Platform101XPRequestsKeeper.this.removeRequestFromPool(platform101XPHttpRequest);
                        return;
                    }
                    Log.d("101XP SDK", "Error sending analytics: " + platform101XPError.toString());
                }
            });
        }
    }

    public void onStopThreadWorker() {
        RequestThreadWorker requestThreadWorker = this.threadWorker;
        if (requestThreadWorker == null) {
            return;
        }
        requestThreadWorker.stopWork();
        onSaveRequestPool();
        this.requestsPool.clear();
        instance = null;
    }

    public void onSaveRequestPool() {
        Set<Platform101XPHttpRequest> set = this.requestsPool;
        if (set == null || set.isEmpty()) {
            return;
        }
        String json = this.gson.toJson(this.requestsPool, this.requestsType);
        Platform101XPSettings.saveString(REQUEST_POOL_KEY, json);
        Log.d("101XP SDK", "Saved RequestPool:" + json);
    }

    private void onRestoreRequestPool() {
        this.gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().registerTypeAdapter(Platform101XPParser.class, new Platform101XPParserTypeAdapter()).create();
        this.requestsType = new TypeToken<Set<Platform101XPHttpRequest>>() { // from class: com.platform101xp.sdk.internal.Platform101XPRequestsKeeper.2
        }.getType();
        String loadString = Platform101XPSettings.loadString(REQUEST_POOL_KEY);
        if (loadString != null) {
            this.requestsPool = (Set) this.gson.fromJson(loadString, this.requestsType);
        }
        Log.d("101XP SDK", "Keeper Restored pool:" + this.requestsPool);
        executeRequests();
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public class RequestThreadWorker {
        private final long retryTime = 60000;
        private List<RetryTimerTask> timersList = new ArrayList();
        private Set<Platform101XPHttpRequest> requests = new HashSet();

        public RequestThreadWorker() {
            Platform101XPRequestsKeeper.this = r3;
        }

        public void executeCurrentRequest(Platform101XPHttpRequest platform101XPHttpRequest) {
            if (this.requests.add(platform101XPHttpRequest)) {
                Timer timer = new Timer();
                RetryTimerTask retryTimerTask = new RetryTimerTask(platform101XPHttpRequest, timer);
                this.timersList.add(retryTimerTask);
                timer.schedule(retryTimerTask, 0L, 60000L);
            }
        }

        public void stopWork() {
            if (this.timersList.isEmpty()) {
                return;
            }
            for (RetryTimerTask retryTimerTask : this.timersList) {
                retryTimerTask.stopTask();
            }
        }
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public class RetryTimerTask extends TimerTask {
        private Timer currentTimer;
        private Platform101XPHttpRequest request;
        private AtomicInteger requestRetryCount = new AtomicInteger(12);

        public RetryTimerTask(Platform101XPHttpRequest platform101XPHttpRequest, Timer timer) {
            Platform101XPRequestsKeeper.this = r2;
            this.request = platform101XPHttpRequest;
            this.currentTimer = timer;
        }

        public synchronized void stopTask() {
            this.requestRetryCount.set(0);
            this.currentTimer.cancel();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (this.requestRetryCount.intValue() == 0) {
                stopTask();
                Log.d("101XP SDK", "RequestsKeeper request count is over");
                return;
            }
            this.request.execute(new Platform101XPHttpRequest.HttpRequestListener() { // from class: com.platform101xp.sdk.internal.Platform101XPRequestsKeeper.RetryTimerTask.1
                @Override // com.platform101xp.sdk.api.http.Platform101XPHttpRequest.HttpRequestListener
                public void onResult(Platform101XPModel platform101XPModel, Platform101XPError platform101XPError) {
                    if (platform101XPError == null) {
                        RetryTimerTask.this.requestRetryCount.set(0);
                        Platform101XPRequestsKeeper.this.removeRequestFromPool(RetryTimerTask.this.request);
                        RetryTimerTask.this.stopTask();
                        Log.d("101XP SDK", "RequestsKeeper request completed");
                        return;
                    }
                    Log.d("101XP SDK", "RequestsKeeper requestRetryCount:" + RetryTimerTask.this.requestRetryCount.getAndDecrement());
                }
            });
        }
    }
}
