package com.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.util.Constantes;

public class Prueba extends AbstractBaseUnitTest {
	
	@Autowired
	Constantes constantes;

	@Test
	public void test(){
		System.out.println(constantes.TEXTO);
		System.out.println(Constantes.CONTENT_TYPE_REST_JSON);
	}
	
}
