package com.company;

public class Lodging extends Accommodation {
    protected boolean esFumador;
    protected int capacidad;

    public Lodging(){ // Hospedería

    }

    public Lodging(ClientInfo clientInfo,
                   String tipoTemporada,
                   double valorBaseNoche,
                   int cantidadDeNoches,
                   boolean esFumador,
                   int capacidad){
        super(clientInfo, tipoTemporada, valorBaseNoche, cantidadDeNoches);
        this.esFumador = esFumador;
        this.capacidad = capacidad;
    }


    public boolean esFumador() {
        return esFumador;
    }

    public void setEsFumador(boolean esFumador) {
        this.esFumador = esFumador;
    }
}
