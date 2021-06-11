package com.company;

public abstract class Accommodation {
    protected ClientInfo clientInfo;
    protected String tipoTemporada;
    protected double valorBaseNoche;
    protected int cantidadDeNoches;


    public Accommodation(){

    }

    // Constructor -para ser usado por sus clases descendientes
    public Accommodation(ClientInfo clientInfo,
                         String tipoTemporada,
                         double valorBaseNoche,
                         int cantidadDeNoches){
        this.clientInfo = clientInfo;
        this.tipoTemporada = tipoTemporada;
        this.valorBaseNoche = valorBaseNoche;
        this.cantidadDeNoches = cantidadDeNoches;
    }




    public double subTotal(){
        double subtotal = (valorBaseNoche * cantidadDeNoches);
        return subtotal;
    }

    public double bonoDescuento(){
        double bonoDescuento = 0;
        if (tipoTemporada.equalsIgnoreCase("baja")){
            bonoDescuento = (subTotal() * 0.25);
        } else if (tipoTemporada.equalsIgnoreCase("media")){
            bonoDescuento = (subTotal() * 0.125);
        }
        return bonoDescuento;
    }

    public double valorACancelar(){
        double valorACancelar = (subTotal() - bonoDescuento());

        return valorACancelar;
    }

    public ClientInfo getDatosCliente(){
        return clientInfo;
    }

    public String getTipoTemporada(){
        return tipoTemporada;
    }

    public double getValorBaseNoche(){
        return valorBaseNoche;
    }

    public void setValorBaseNoche(double valorBaseNoche){
        this.valorBaseNoche = valorBaseNoche;
    }

    public void setCantidadDeNoches(int cantidadDeNoches){
        this.cantidadDeNoches = cantidadDeNoches;
    }

    public int getCantidadDeNoches(){
        return cantidadDeNoches;
    }

}
