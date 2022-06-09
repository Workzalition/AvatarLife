
varying vec4 v_fragmentColor;
varying vec2 v_texCoord;

void main()
{
    vec4 v_orColor = v_fragmentColor * texture2D(CC_Texture0, v_texCoord);
    gl_FragColor = v_orColor * vec4(1.22, 1.22, 1.22, v_orColor.a);
}
