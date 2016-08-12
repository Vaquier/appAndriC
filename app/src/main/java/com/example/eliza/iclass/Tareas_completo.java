package com.example.eliza.iclass;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.sql.Statement;
import java.util.ArrayList;

public class Tareas_completo extends Fragment {
    View rootView;
    private Statement statement = null;
    private java.sql.ResultSet resultSet = null;
    private ArrayList<tarea> listTareas;
    public Intent i;
    private int idTarea = 0;

    public Tareas_completo() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_tareas_completo, container, false);
        new getDataTareas().execute();
        return rootView;
    }
    private class getDataTareas extends AsyncTask<Void, Void, Void> {


        protected Void doInBackground(Void... arg0){

            try{
            /*     Connection conn = null;
                String query = "SELECT * FROM bitacoras ORDER BY fecha DESC";
                Class.forName(driver);
                Boolean aux = true;
                conn = DriverManager.getConnection("jdbc:mysql://app.armedigital.com:3306/admin_tajsa_main_dev", user, pass);
                statement = conn.createStatement();
                resultSet = statement.executeQuery(query);
                listBitacoras = new ArrayList<bitacora>();
                while(resultSet.next()) {
                    int idProspecto = resultSet.getInt("idProspecto");
                    int idBitacora = resultSet.getInt("idBitacora");
                    int status = resultSet.getInt("status");
                    int importante = resultSet.getInt("importante");
                    String comentario = resultSet.getString("comentario");
                    String fecha = resultSet.getString("fecha");
                    listBitacoras.add(new bitacora(idBitacora,status,importante,idProspecto,comentario,fecha));
                }
                setTab();*/
                listTareas = new ArrayList<tarea>();
                for(int g=0; g< 2; g++){
                    listTareas.add(new tarea(g+1,1,"11/08/2016-"+g,"materia","contenido"));
                }
                setTab();
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }
    }
    public void setTab(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                final LinearLayout grid = (LinearLayout) rootView.findViewById(R.id.gridview);

                grid.post(new Runnable() {
                    @Override
                    public void run() {

                        tarea_adapter adapter = new tarea_adapter(getActivity(), getArr());

                        for(int m=0; m<listTareas.size(); m++ ){
                            View tmp = adapter.getView(m,null,grid);
                            grid.addView(tmp);
                        }
                    }
                });

            }
        }).start();
    }
    public tarea[] getArr(){
        tarea[] tmp = new tarea[listTareas.size()];
        for(int f=0;f<listTareas.size();f++){
            tmp[f] = listTareas.get(f);
        }
        return tmp;
    }
    public void onResume(){
        super.onResume();
        // new getDataAvisos().execute();
    }
}
