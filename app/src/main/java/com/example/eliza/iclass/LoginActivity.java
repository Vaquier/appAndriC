package com.example.eliza.iclass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.Looper;

public class LoginActivity extends AppCompatActivity {
    Button btnIniciarSesion;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnIniciarSesion = (Button) findViewById(R.id.Btn_iniciarSesion);
        btnIniciarSesion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick( View v){
                newActivity();
            }
        });
    }
    public void newActivity(){
        System.out.print("Entrando al sistema....");
        i = new Intent(getApplicationContext(), PrincipalActivity.class);
        Thread th = new Thread(){
            public void run(){

                    Looper.prepare();
                    startActivity(i);
                    Looper.loop();

            }
        };
        th.start();

    }
}
/*

  */