package com.iqfarma.sgfmf.util;

import com.iqfarma.sgfmf.R;

/**
 * @author Jean Ramal Alvarez
 * @since 04/09/2014
 * */
public class Constantes {
	
	public class Soap{
		public static final String NAMESPACE = "http://tempuri.org";
		public static final String SOAP_ACTION = NAMESPACE + "/";
		public static final String URL = "http://10.200.69.51/iqfarmaservice/Service1.asmx";
	}
	
	public static class Mensaje{
		
		public static final String ERROR_SERVIDOR_CONEXION = "Problemas al conectar con el servidor"; 		//Exception
		public static final String ERROR_SERVIDOR_PARSE = "Problemas parseando la respuesta del servidor"; 	//XmlPullParserException
		public static final String ERROR_SERVIDOR_TIMEOUT = "Problemas de conexion por tiempo de espera agotado"; 		//SocketTimeoutException
		public static final String ERROR_SERVIDOR_RESPONSE = "Problemas obteniendo respuesta del servidor"; //HttpResponseException
		public static final String ERROR_SERVIDOR_IO = "Problemas al conectar con el servidor(IO)"; 		//IOException
		
		public static final String TOAST_LOGIN_USUARIO_CONTRASENA_REQUERIDOS = "Ingrese usuario y/o contraseña";
		public static final String TOAST_LOGIN_USUARIO_CONTRASENA_INCORRECTOS = "Usuario y/o Contraseña Incorrectos";
		
		public static final String TOAST_MENU_SALIR = "Desea salir de la aplicacion?";
		public static final String TOAST_MENU_BIENVENIDO = "Bienvenido(a)";
		
		public static final String TOAST_MEDICO_NO_EXISTEN_MEDICOS = "No existen médicos";
		public static final String TOAST_MEDICO_ACTUALIZACION_CORRECTA = "Se actualizó el médico correctamente";
		public static final String TOAST_MEDICO_ACTUALIZACION_INCORRECTA = "No se pudo actualizar el médico";
		
		public static final String TOAST_MALLA_AGREGAR_PRODUCTO = "Debe agregar algun producto";
		public static final String TOAST_MALLA_NO_EXISTE_MALLA = "No existe malla promocional para el médico";
		
		public static final String TOAST_VISITA_REGISTRO_CORRECTO = "Se registró la visita correctamente";
		
		public static final String TOAST_NO_VISITA_SELECIONAR_MOTIVO = "Debe seleccionar un motivo";
		public static final String TOAST_NO_VISITA_REGISTRO_CORRECTO = "Se registró la no visita correctamente";
		
		public static final String TOAST_MEDICO_NO_EXISTEN_FARMACIAS = "No existen farmacias";
		
		public static final String TOAST_NO_EXISTEN_PRODUCTOS = "No existen productos";
		public static final String TOAST_NO_PEDIDO_REGISTRO_CORRECTO = "Se registró el no pedido correctamente";
		
		public static final String DIALOG_MEDICO_ACTUALIZAR_MEDICO = "Está seguro que desea actualizar los datos del médico?";
		public static final String DIALOG_OBSERVACION_REQUERIDA = "No ha ingresado una observacion, está seguro que ";
		public static final String DIALOG_OBSERVACION_REGISTRAR_VISITA = "desea terminar la visita?";
		public static final String DIALOG_OBSERVACION_REGISTRAR_NO_VISITA = "desea terminar la no visita?";
		public static final String DIALOG_OBSERVACION_REGISTRAR_NO_PEDIDO = "desea terminar la no pedido?";
		
	}
	
	public static class Menu{
		
		public static final int PRINCIPAL = 1;
		public static final int SINCRONIZACION = 2;
		
		public static final String PRINCIPAL_MEDICOS = "Medicos";
		public static final String PRINCIPAL_FARMACIAS = "Farmacias";
		public static final String PRINCIPAL_AVANCE = "Avance";
		public static final String PRINCIPAL_SINCRONIZACION = "Sincronizacion";
		
		public static final int PRINCIPAL_MEDICOS_ID = 1;
		public static final int PRINCIPAL_FARMACIAS_ID = 2;
		public static final int PRINCIPAL_AVANCE_ID = 3;
		public static final int PRINCIPAL_SINCRONIZACION_ID = 4;
		
		public static final String[] PRINCIPAL_MENU_TEXTO = new String[] {PRINCIPAL_MEDICOS,
			                                                              PRINCIPAL_FARMACIAS,
			                                                              PRINCIPAL_AVANCE,
			                                                              PRINCIPAL_SINCRONIZACION};

		public static final int[] PRINCIPAL_MENU_IMAGEN = new int[]{R.drawable.menu_medico,
			                                                        R.drawable.menu_farmacia,
			                                                        R.drawable.menu_avances,
			                                                        R.drawable.menu_sincronizacion};
		
		
		public static final String SINCRONIZACION_MAESTRO = "Maestro Mensual";
		public static final String SINCRONIZACIN_VISITA = "Visitas Pendientes";
		public static final String SINCRONIZACIN_PEDIDO = "Pedidos Pendientes";
		
		public static final int SINCRONIZACION_MAESTRO_ID = 1;
		public static final int SINCRONIZACION_PEDIDO_ID = 2;
		
		public static final String[] SINCRONIZACION_MENU_TEXTO = new String[] {SINCRONIZACION_MAESTRO,
			                                                                   SINCRONIZACIN_VISITA, 
			                                                                   SINCRONIZACIN_PEDIDO};

		public static final int[] SINCRONIZACION_MENU_IMAGEN = new int[]{R.drawable.menu_sincronizacion, 
			                                                             R.drawable.menu_sincronizacion, 
			                                                             R.drawable.menu_sincronizacion};
		
	}
	
	public class MyAsyncTask{
	    
    	public static final String CARGANDO = "Cargando...";
    	public static final int LOGIN = 0;
    	public static final int MENU_MEDICOS = 1;
    	public static final int MENU_MEDICOS_MALLA_PROMOCIONAL = 11;
    	public static final int MENU_MEDICOS_REGISTRAR_VISITA = 12;
    	public static final int MENU_MEDICOS_NO_VISITA = 13;
    	public static final int MENU_MEDICOS_REGISTRAR_NO_VISITA = 14;
    	public static final int MENU_MEDICOS_PRESCRIPCION = 15;
    	public static final int MENU_MEDICOS_ACTUALIZAR = 16;
    	public static final int MENU_FARMACIAS = 2;
    	public static final int MENU_FARMACIAS_PRODUCTOS = 21;
    	public static final int MENU_FARMACIAS_NO_PEDIDO = 22;
    	public static final int MENU_FARMACIAS_REGISTRAR_NO_PEDIDO = 23;
    	public static final int MENU_AVANCES = 3;
    	public static final int MENU_SINCRONIZACION_MAESTRO = 4;
    	public static final int MENU_SINCRONIZACION_VISITA = 5;
    	public static final int MENU_SINCRONIZACION_PEDIDO = 6;
    	
	}
	
	public class Extra{
		
		public static final String ACTIVIDAD_PREVIA = "actividadPrevia";
		
		public static final int MAYA_PROMOCIONAL = 1;
		public static final int NO_VISITA = 2;
		public static final int NO_PEDIDO = 3;
		public static final int MEDICO_DETALLE = 4;
		public static final int FARMACIA_DETALLE = 5;
		
	}
	
	public class Varios{
		
		public static final int TAMANO_MAXIMO_CANTIDAD_PRODUCTO = 3;
		
	}

}
