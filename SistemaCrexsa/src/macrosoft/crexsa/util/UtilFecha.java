package macrosoft.crexsa.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class UtilFecha {
	
	
	public static String dateToStringFormat(Date date, String pattern){
		SimpleDateFormat formateador = new SimpleDateFormat(pattern);		
		return formateador.format(date);
	}
	
	public static String dateFormatLong(Date date){
		SimpleDateFormat formateador = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("es_ES"));
		return formateador.format(date);
	}
	
	public static String dateFormatShort(Date date){
		SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");		
		return formateador.format(date);
	}
	
	public static String dateFormatShort2(Date date){
		SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");		
		return formateador.format(date);
	}
	
	public static String dateFormatHalf(Date date){
		SimpleDateFormat formateador = new SimpleDateFormat("EE dd MMM", new Locale("es_ES"));	
		return formateador.format(date);
	}
	
	public static String dateFormatFull(Date date){
		SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", new Locale("es_ES"));
		return formateador.format(date);
	}

}
