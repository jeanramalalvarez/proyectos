package com.notariaberrospi.sgn.util;

public enum EnumUtil {
	
	APLICACION("SGN");
	
	private final String valor;
	
	EnumUtil(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}

}
