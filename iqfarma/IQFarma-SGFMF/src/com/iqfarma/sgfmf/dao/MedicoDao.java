package com.iqfarma.sgfmf.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.iqfarma.sgfmf.bean.Medico;

/**
 * @author Jean Ramal Alvarez
 * @since 04/09/2014
 * */
public class MedicoDao {
	
	public List<Medico> listar(){
		
		List<Medico> medicos = new ArrayList<Medico>();
		
		String [][] datos = {{"Ada","Peralta", "C."},{"Adela", "Yopla", "M."},{"Alejandro", "Asato", "K."},
				             {"Alfredo", "Aybar", "S."},{"Alfredo", "Cano", "C."},{"Alfredo", "Lee", "W."},
				             {"Alina", "Solis", "A."},{"Alvaro", "Zavala", "P."},{"Adela", "Yopla", "M"},
				             {"Adela", "Yopla", "M"},{"Adela", "Yopla", "M"},{"Adela", "Yopla", "M"}};
		
		for (int i = 0; i < 12; i++) {
			long id = (long) (i+1);
			medicos.add(new Medico(id, "0"+id, datos[i][0], datos[i][1], datos[i][2], "0000026065", "Jr. Las violetas CDR", Calendar.getInstance().getTime(), datos[i][0] + "@correo.com", "5455689", "998777899"));
		}

	  
		return medicos;
		
	}
	
	public String avances(){
		StringBuffer avancesMedicos = new StringBuffer();
		avancesMedicos.append("TOTAL: \t\t\t 555");
		avancesMedicos.append("\n");
		avancesMedicos.append("VISITAS: \t\t\t 3");
		avancesMedicos.append("\n");
		avancesMedicos.append("NO VISITAS: \t 4");
		avancesMedicos.append("\n");
		avancesMedicos.append("PENDIENTES: \t 548");
		avancesMedicos.append("\n");
		avancesMedicos.append("[%] AVANCE: \t 1.26");
		return avancesMedicos.toString();
	}
	
	public boolean registrarVisita(){
		return true;
	}
	
	public Medico actualizar(Medico medico){
		return medico;
	}

}
