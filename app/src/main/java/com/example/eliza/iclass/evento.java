package com.example.eliza.iclass;

/**
 * Created by pi on 10/08/2016.
 */
public class evento {
    public int idEvento, tipo;
    public String fecha, titulo, contenido;
    public evento (int idEvento, int tipo, String fecha, String titulo, String contenido){
        this.idEvento = idEvento;
        this.tipo = tipo;
        this.fecha = fecha;
        this.titulo =  titulo;
        this.contenido = contenido;
    }
}
