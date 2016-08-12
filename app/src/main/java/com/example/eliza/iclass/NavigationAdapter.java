package com.example.eliza.iclass;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by pi on 09/08/2016.
 */
public class NavigationAdapter extends ArrayAdapter {
    private Activity activity;
    public NavigationAdapter(Context context, List objects){
        super(context, 0, objects);
    }
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.itm, null);

        }
        TextView name = (TextView) convertView.findViewById(R.id.title_item);
        item_objct item = (item_objct) getItem(position);
        name.setText(item.getTitulo());
        return convertView;
    }
}
