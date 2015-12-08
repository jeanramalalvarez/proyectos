package com.iqfarma.sgfmf.util;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.iqfarma.sgfmf.R;
import com.iqfarma.sgfmf.bean.Producto;

/**
 * @author Jean Ramal Alvarez
 * @since 19/09/2014
 * */
public class ProductoPedidoAdapter extends ArrayAdapter<Producto> {

	private Context context;
	private int layoutResourceId;

	public ProductoPedidoAdapter(Context context, int layoutResourceId, List<Producto> productos) {
		super(context, layoutResourceId, productos);
		this.layoutResourceId = layoutResourceId;
		this.context = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View item = convertView;
		ProductoWrapper productoWrapper = null;

		if (item == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			item = inflater.inflate(layoutResourceId, parent, false);
			productoWrapper = new ProductoWrapper();
			productoWrapper.txtNumero = (TextView) item.findViewById(R.id.lbl_numero);
			productoWrapper.txtNombre = (TextView) item.findViewById(R.id.lbl_producto);
			productoWrapper.txtCantidad = (TextView) item.findViewById(R.id.cantidad);
			productoWrapper.txtPosicion = (TextView) item.findViewById(R.id.posicion);
			productoWrapper.btnMas = (Button) item.findViewById(R.id.btn_mas);
			productoWrapper.btnMenos = (Button) item.findViewById(R.id.btn_menos);
			item.setTag(productoWrapper);
		} else {
			productoWrapper = (ProductoWrapper) item.getTag();
		}

		Producto producto = getItem(position);
		productoWrapper.txtNumero.setText((position+1) + ".");
		productoWrapper.txtNombre.setText(producto.getNombre());
		productoWrapper.txtCantidad.setText("" + producto.getCantidad());
		productoWrapper.txtPosicion.setText("" + position);
		
		productoWrapper.btnMas.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				
				TextView textView = Util.getTextViewCantidadToListViewProductoMalla(view);
				int cantidad = Util.parseIntFromTextView(textView);
				cantidad++;
				textView.setText("" + cantidad);
				TextView textView2 = Util.getTextViewPositionToListViewProductoMalla(view);
				int posicion = Util.parseIntFromTextView(textView2);
				
				getItem(posicion).setCantidad(cantidad);
			}
		});
		
		productoWrapper.btnMenos.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				TextView textView = Util.getTextViewCantidadToListViewProductoMalla(view);
				int cantidad = Util.parseIntFromTextView(textView);
				
				if(cantidad>0){
					cantidad--;
					textView.setText("" + cantidad);
				}
				
				TextView textView2 = Util.getTextViewPositionToListViewProductoMalla(view);
				int posicion = Util.parseIntFromTextView(textView2);
				getItem(posicion).setCantidad(cantidad);
			}
		});

		return item;

	}

	static class ProductoWrapper {
		TextView txtNumero;
		TextView txtNombre;
		TextView txtCantidad;
		TextView txtPosicion;
		Button btnMas;
		Button btnMenos;
	}

}
