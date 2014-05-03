package com.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Constantes{

	public static String CHARSET_UTF8 = "charset=utf-8";
	public static String CONTENT_TYPE_REST_JSON = "application/json";
	public static String CONTENT_TYPE_REST_XML = "application/xml";
	
	public static String TOKEN = "token";
	
	@Value( "${mensaje.seguridad.auntenticacion}" )
	public String MENSAJE_SEGURIDAD_AUTENTICACION;
	
	@Value( "${mensaje.seguridad.validacion}" )
	public String MENSAJE_SEGURIDAD_VALIDACION;

	@Value( "${test.texto}" )
	public String TEXTO;
	
	@Value( "${file.maxUploadSize}" )
	public String FILE_MAX_UPLOAD_SIZE;

}
