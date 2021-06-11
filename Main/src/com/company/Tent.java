package com.company;

public class Tent extends Accommodation {
    protected int cantidadPersonas;

    public Tent(){
        //
    }

    public Tent(ClientInfo clientInfo,
                String tipoTemporada,
                double valorBaseNoche,
                int cantidadDeNoches,
                int cantidadPersonas){
        super(clientInfo, tipoTemporada, valorBaseNoche, cantidadDeNoches);
        this.cantidadPersonas = cantidadPersonas;
    }

    public void setCantidadPersonas(int personas){
        this.cantidadPersonas = personas;
    }

    public int getCantidadPersonas(){
        return  cantidadPersonas;
    }

}
