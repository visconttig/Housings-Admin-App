package com.company;


public class Hotel extends Lodging {
    protected boolean conDesayuno;

    public Hotel(){
        //
    }

    public Hotel (ClientInfo clientInfo,
                  String tipoTemporada,
                  double valorBaseNoche,
                  int cantidadDeNoches,
                  boolean esFumador,
                  int capacidad,
                  boolean conDesayuno){
        super(clientInfo, tipoTemporada, valorBaseNoche, cantidadDeNoches, esFumador, capacidad);
        this.conDesayuno = conDesayuno;
    }


    public double adicional() {
        double adicional = 0;
        if (esFumador && conDesayuno){
            adicional = (subTotal() * 0.30);
            return adicional;
        } else {
            // adicional ya es '0'.
        }

        return adicional;
    }

    @Override
    public double valorACancelar() {
        double valorACancelar = super.valorACancelar();
        if (adicional() != 0){
            valorACancelar = valorACancelar + adicional();
        }

        return valorACancelar;
    }

    public void  setConDesayuno(boolean conDesayuno){
        this.conDesayuno = conDesayuno;
    }

    public boolean getConDesayuno(){
        return conDesayuno;
    }
}
