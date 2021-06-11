package com.company;

public class ClientInfo {
    private String nombreCliente = "";
    private int rutCliente = -1;


    public ClientInfo(String nombre, int rut){
        this.nombreCliente = nombre;
        this.rutCliente = rut;
    }

    public String getNombreCliente(){
        return nombreCliente;
    }

    public int getRutCliente(){
        return rutCliente;
    }

    public void setNombreCliente(String nombre){
        this.nombreCliente = nombre;
    }

    public void setRutCliente(int rut){
        this.rutCliente = rut;
    }
}
