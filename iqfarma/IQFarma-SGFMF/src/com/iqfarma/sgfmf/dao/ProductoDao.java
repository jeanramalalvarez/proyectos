package com.iqfarma.sgfmf.dao;

import java.util.ArrayList;
import java.util.List;

import com.iqfarma.sgfmf.bean.Medico;
import com.iqfarma.sgfmf.bean.Producto;

public class ProductoDao {

	public List<Producto> listar() {

		List<Producto> productos = new ArrayList<Producto>();

		String[] datos = { "AMBROXIL TABLETAS X", "BIOBRONCOL CAPSULAS", "DIAGRIN FLEX MSM SOB",
				           "DIAGRIN FLEX MSM SOB", "DIAGRIN FLEX MSM SOB 2", "DIAGRIN FLEX MSM SOB 3"};

		for (int i = 0; i < datos.length; i++) {
			long id = (long) (i + 1);
			productos.add(new Producto(id, datos[i]));
		}

		return productos;

	}

	public List<Producto> obtenerProductosPorMedico(Medico medico) {
		List<Producto> productos = new ArrayList<Producto>();
		Producto producto = new Producto();
		producto.setNombre("AMBROXIL TABLETAS X");
		productos.add(producto);
		producto = new Producto();
		producto.setNombre("BIOBRONCOL CAPSULAS");
		productos.add(producto);
		producto = new Producto();
		producto.setNombre("DIAGRIN FLEX MSM SOB");
		productos.add(producto);
		producto = new Producto();
		producto.setNombre("DIAGRIN FLEX MSM SOB 2");
		productos.add(producto);
		producto = new Producto();
		producto.setNombre("DIAGRIN FLEX MSM SOB 3");
		productos.add(producto);
		return productos;
	}

}
