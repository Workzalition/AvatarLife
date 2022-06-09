varying vec4 v_fragmentColor;
varying vec2 v_texCoord;

uniform vec2 input_blur;
uniform float h_step;
uniform float v_step;
uniform int szIndexArr;
uniform mat4 indexArr;

void main() {
    float bh = input_blur.x*h_step;
    float bv = input_blur.y*v_step;

      gl_FragColor = texture2D(CC_Texture0, v_texCoord)*indexArr[0][0];
      for (int i = 1; i < szIndexArr; i++) {
          vec2 offset = vec2(float(i)*bh, float(i)*bv);
          float ia = indexArr[int(i/4)][int(mod(float(i),4.0))];
          gl_FragColor += texture2D(CC_Texture0, v_texCoord + offset)*ia;
          gl_FragColor += texture2D(CC_Texture0, v_texCoord - offset)*ia;
      }
}