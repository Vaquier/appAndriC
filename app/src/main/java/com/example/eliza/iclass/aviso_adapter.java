package com.example.eliza.iclass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by pi on 10/08/2016.
 */
public class aviso_adapter extends ArrayAdapter<aviso> {
    private final Context mContext;
    aviso[] datos;
    public aviso_adapter(Context mContext, aviso[] datos){
        super(mContext, R.layout.aviso_item, datos);
        this.datos = datos;
        this.mContext = mContext;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            try{
            convertView = inflater.inflate(R.layout.aviso_item, parent, false);
            }
            catch (Exception e){
                System.out.print(e);
            }
        }

        TextView lblTitulo = (TextView) convertView.findViewById(R.id.titulo);
        lblTitulo.setText(datos[position].titulo);

        TextView lblFecha = (TextView) convertView.findViewById(R.id.fecha);
        lblFecha.setText(datos[position].fecha);

        TextView lblContenido = (TextView) convertView.findViewById(R.id.contenido);
        lblContenido.setText(datos[position].contenido);

        ImageView imgPalomita = (ImageView) convertView.findViewById(R.id.palomita);
        if(datos[position].tipo == 1)
            imgPalomita.setImageResource(R.drawable.palomita);
        else
            imgPalomita.setImageResource(R.drawable.palomita);

        convertView.setId(datos[position].idAviso);
        return convertView;
    }
}
