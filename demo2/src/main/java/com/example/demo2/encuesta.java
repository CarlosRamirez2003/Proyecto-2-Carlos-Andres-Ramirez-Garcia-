package com.example.demo2;

import javafx.scene.control.Alert;

/**
 * <h3></h3>
 *
 * @descripción
 * @autor carlos ramirez
 **/
public class encuesta {
private static int correlativo =1;
private int pin;
private int pinpreguntas;
private String Titulo;
private String descripcion;

private String estado;


    public encuesta(String titulo, String descripcion) {
        this.pinpreguntas=this.correlativo;
        Titulo = titulo;
        this.descripcion = descripcion;
         estado="REGISTRADO";
         this.pin= pin;

         correlativo ++;

    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getPinpreguntas() {
        return pinpreguntas;
    }

    public void setPinpreguntas(int pinpreguntas) {
        this.pinpreguntas = pinpreguntas;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


}
