package com.example.eliza.iclass;

import android.content.Intent;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.sql.Statement;
import java.util.ArrayList;

public class Avisos extends AppCompatActivity {
    private Statement statement = null;
    private ArrayList<aviso> listAvisos;
    private int idUsuario, idAviso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avisos);
      /*  Bundle b = getIntent().getExtras();
        idUsuario = b.getInt("id");*/
        for(int h = 0; h< 10; h++){
            listAvisos.add(new aviso(h+1,1,"02 Julio 2016","Prueba", "Prueba Texto"));
        }
        setTab();
    }
    public aviso[] getArr(){
        aviso[] tmp = new aviso[listAvisos.size()];
        for(int f=0;f<listAvisos.size();f++){
            tmp[f] = listAvisos.get(f);
        }
        return tmp;
    }
    public void setTab(){

        aviso[] arrAviso = getArr();
        final LinearLayout grid = (LinearLayout) findViewById(R.id.gridview);
        final aviso_adapter adapter = new aviso_adapter(this, arrAviso);
        new Thread(new Runnable() {
            @Override
            public void run() {
                grid.post(new Runnable() {
                    @Override
                    public void run() {
                        grid.removeAllViews();
                        for(int m=0; m<listAvisos.size(); m++ ){
                            View tmp = adapter.getView(m,null,grid);
                           /* tmp.setOnClickListener(new View.OnClickListener(){
                                @Override
                                public void onClick( View v){
                                    idAviso = v.getId();
                                    newActivity();
                                }
                            });
*/
                            grid.addView(tmp);


                        }
                    }
                });
            }
        }).start();
    }
}
