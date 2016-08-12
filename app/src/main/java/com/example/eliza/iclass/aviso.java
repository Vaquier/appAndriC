package com.example.eliza.iclass;

/**
 * Created by pi on 10/08/2016.
 */
public class aviso {
    public int idAviso, tipo;
    public String fecha, titulo, contenido;
    public aviso (int idAviso, int tipo, String fecha, String titulo, String contenido){
        this.idAviso = idAviso;
        this.tipo = tipo;
        this.fecha = fecha;
        this.titulo =  titulo;
        this.contenido = contenido;
    }
}
