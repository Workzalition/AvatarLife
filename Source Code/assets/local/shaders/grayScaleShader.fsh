varying vec4 v_fragmentColor;
varying vec2 v_texCoord;

void main()
{
	vec4 color = texture2D( CC_Texture0, v_texCoord );
	float grey = color.r * 0.212 + color.g * 0.715 + color.b * 0.072;
	gl_FragColor = vec4( grey, grey, grey, color.a );
}
