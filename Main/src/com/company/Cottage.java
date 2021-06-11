package com.company;

public class Cottage extends Lodging {
    protected boolean chimenea;

    public Cottage(){
        //
    }

    public Cottage(ClientInfo clientInfo,
                   String tipoTemporada,
                   double valorBaseNoche,
                   int cantidadDeNoches,
                   boolean esFumador,
                   int capacidad,
                   boolean chimenea){
        super(clientInfo, tipoTemporada, valorBaseNoche, cantidadDeNoches, esFumador, capacidad);
        this.chimenea = chimenea;

    }

    public double incrementaValorBase(){
        if (capacidad > 5){
            valorBaseNoche = valorBaseNoche + (valorBaseNoche * 0.18);
        }

        return valorBaseNoche;
    }

    public void setChimenea(boolean chimenea){
        this.chimenea = chimenea;
    }

    public boolean getChimenea(){
        return  chimenea;
    }
}
