package com.pomajulca.labcalificado.models;

import java.text.SimpleDateFormat;

public class Nota {
    private  String titulo;
    private String comentario;
    private Long date;

    public Nota() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Nota{" +
                "titulo='" + titulo + '\'' +
                ", comentario='" + comentario + '\'' +
                ", date=" + date +
                '}';
    }
}

