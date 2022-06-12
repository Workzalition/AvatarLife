package com.platform101xp.sdk.internal;

import android.util.Log;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.platform101xp.sdk.Platform101XP;
import com.platform101xp.sdk.api.parser.Platform101XPParser;
import java.io.IOException;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPParserTypeAdapter extends TypeAdapter<Platform101XPParser> {
    private static final String JSON_MODEL_NAME = "model_class";

    public void write(JsonWriter jsonWriter, Platform101XPParser platform101XPParser) throws IOException {
        jsonWriter.beginObject();
        jsonWriter.name(JSON_MODEL_NAME).value(platform101XPParser.getModelClass().getName());
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    public Platform101XPParser read(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        Platform101XPParser platform101XPParser = null;
        while (jsonReader.hasNext()) {
            if (jsonReader.nextName().equals(JSON_MODEL_NAME)) {
                String nextString = jsonReader.nextString();
                Log.d("101XP SDK", "JsonParser read class: " + nextString);
                try {
                    platform101XPParser = new Platform101XPParser(Class.forName(nextString));
                } catch (ClassNotFoundException e) {
                    Platform101XP.sendCrashReport(e);
                }
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return platform101XPParser;
    }
}
