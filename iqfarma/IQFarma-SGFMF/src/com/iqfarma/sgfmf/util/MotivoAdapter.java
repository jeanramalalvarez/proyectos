package com.iqfarma.sgfmf.util;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import com.iqfarma.sgfmf.R;
import com.iqfarma.sgfmf.bean.Motivo;

/**
 * @author Jean Ramal Alvarez
 * @since 16/09/2014
 * */
public class MotivoAdapter extends ArrayAdapter<Motivo> {
	
	private Context context;
	private int layoutResourceId;
	private RadioButton rbMotivo;
	private Long idMotivo;
	
	public MotivoAdapter(Context context, int layoutResourceId, List<Motivo> motivos) {
		super(context, layoutResourceId, motivos);
		this.layoutResourceId = layoutResourceId;
		this.context = context;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View item = convertView;
		MotivoWrapper motivoWrapper = null;

		if (item == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			item = inflater.inflate(layoutResourceId, parent, false);
			motivoWrapper = new MotivoWrapper();
			motivoWrapper.rbMotivo = (RadioButton) item.findViewById(R.id.rb_motivo);
			motivoWrapper.lblIdMotivo = (TextView) item.findViewById(R.id.lbl_id_motivo);
			item.setTag(motivoWrapper);
		} else {
			motivoWrapper = (MotivoWrapper) item.getTag();
		}
		
		Motivo motivo = getItem(position);
		motivoWrapper.rbMotivo.setText(motivo.getMotivo());
		motivoWrapper.lblIdMotivo.setText("" + motivo.getId());

		motivoWrapper.rbMotivo.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
    
            	TextView textView = Util.getTextViewIdMotivoOfListViewMotivoNoVisita(view);
            	
            	idMotivo = Util.parseLongFromTextView(textView);
            	
            	if (rbMotivo == null)
            		rbMotivo = (RadioButton) view;
    
            	rbMotivo.setChecked(true);                

                if (rbMotivo == view)
                    return;

                rbMotivo.setChecked(false);
                ((RadioButton) view).setChecked(true);
                rbMotivo = (RadioButton) view;
            }
        });
		
		return item;
		
	}
	
	static class MotivoWrapper {
		RadioButton rbMotivo;
		TextView lblIdMotivo;
	}
	
	public Long getIdMotivo() {
		return idMotivo;
	}

}
