package com.example.eliza.iclass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class contingencia_adapter extends ArrayAdapter<contingencia> {
    private final Context mContext;
    contingencia[] datos;
    public contingencia_adapter(Context mContext, contingencia[] datos){
        super(mContext, R.layout.contingencia_item, datos);
        this.datos = datos;
        this.mContext = mContext;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.contingencia_item, parent, false);
        }

        TextView lbltexto = (TextView) convertView.findViewById(R.id.texto);
        lbltexto.setText(datos[position].texto);


        convertView.setId(datos[position].idContingencia);
        return convertView;
    }
}
