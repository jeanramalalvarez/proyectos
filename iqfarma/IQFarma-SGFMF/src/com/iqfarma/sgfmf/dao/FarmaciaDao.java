package com.iqfarma.sgfmf.dao;

import java.util.ArrayList;
import java.util.List;

import com.iqfarma.sgfmf.bean.Farmacia;

/**
 * @author Jean Ramal Alvarez
 * @since 04/09/2014
 * */
public class FarmaciaDao {
	
	public List<Farmacia> listar(){
		
		List<Farmacia> farmacias = new ArrayList<Farmacia>();
		
		String [] datos = {"BIOFARMA PLUS","BOTICA 2 DE MAYOR", "BOTICA 28 DE JULIO",
				           "BOTICA 90 GRADOS II", "BOTICA ALAMEDA", "BOTICA AVILA", 
				           "BOTICA BALTA", "BOTICA 1", "BOTICA 2", 
				           "BOTICA 3", "BOTICA 4", "BOTICA 5" };
		  
		for (int i = 0; i < datos.length; i++) {
			long id = (long) (i+1);
			farmacias.add(new Farmacia(id, "0"+id, datos[i], "0000026065", "Jr. Las violetas CDR", "5455689"));
		}
		  
		  return farmacias;
		
	}
	
	public String avances(){
		StringBuffer avancesFarmacias = new StringBuffer();
		avancesFarmacias.append("TOTAL: \t\t\t 93");
		avancesFarmacias.append("\n");
		avancesFarmacias.append("VISITAS: \t\t\t 4");
		avancesFarmacias.append("\n");
		avancesFarmacias.append("NO VISITAS: \t 3");
		avancesFarmacias.append("\n");
		avancesFarmacias.append("PENDIENTES: \t 86");
		avancesFarmacias.append("\n");
		avancesFarmacias.append("[%] AVANCE: \t 7.53");
		return avancesFarmacias.toString();
	}

}
