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

public class Contingencias_completo extends Fragment {

    View rootView;
    private Statement statement = null;
    private java.sql.ResultSet resultSet = null;
    private ArrayList<contingencia> listContingencias;
    public Intent i;
    private int idContingencia = 0;

    public Contingencias_completo() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView =  inflater.inflate(R.layout.fragment_contingencias_completo, container, false);
        new getDataContingencias().execute();
        return rootView;
    }

    private class getDataContingencias extends AsyncTask<Void, Void, Void> {


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
                */
                listContingencias = new ArrayList<contingencia>();
                for(int g=0; g< 3; g++){
                    listContingencias.add(new contingencia(g+1,"Su niño se murio :D"));
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

                       contingencia_adapter adapter = new contingencia_adapter(getActivity(), getArr());

                        for(int m=0; m<listContingencias.size(); m++ ){
                            View tmp = adapter.getView(m,null,grid);
                            grid.addView(tmp);
                        }
                    }
                });

            }
        }).start();
    }
    public contingencia[] getArr(){
        contingencia[] tmp = new contingencia[listContingencias.size()];
        for(int f=0;f<listContingencias.size();f++){
            tmp[f] = listContingencias.get(f);
        }
        return tmp;
    }
    public void onResume(){
        super.onResume();

    }
}
