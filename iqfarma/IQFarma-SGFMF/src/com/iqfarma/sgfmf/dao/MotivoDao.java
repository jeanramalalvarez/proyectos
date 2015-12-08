package com.iqfarma.sgfmf.dao;

import java.util.ArrayList;
import java.util.List;

import com.iqfarma.sgfmf.bean.Motivo;

public class MotivoDao {
	
	public List<Motivo> listar(){
		List<Motivo> productos = new ArrayList<Motivo>();
		Motivo motivo = new Motivo();
		motivo.setId(1l);
		motivo.setMotivo("Motivo 1");
		productos.add(motivo);
		motivo = new Motivo();
		motivo.setId(2l);
		motivo.setMotivo("Motivo 2");
		productos.add(motivo);
		motivo = new Motivo();
		motivo.setId(3l);
		motivo.setMotivo("Motivo 3");
		productos.add(motivo);
		motivo = new Motivo();
		motivo.setId(4l);
		motivo.setMotivo("Motivo 4");
		productos.add(motivo);
		return productos;
	}

}
