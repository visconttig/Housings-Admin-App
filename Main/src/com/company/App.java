package com.company;

import controladora.Housing;

import java.util.ArrayList;

public class App {


    public static void main(String[] args) {

        Housing housing = new Housing(new ArrayList<>());


        int selectedOption = -1;
        int documentId = 0;
        int index = -1;
        String answer = "";
        Accommodation alj = null;
	do {
        selectedOption = imprimeOpciones();
        switch (selectedOption){
            case 1:
                /*
                Utilizamos el RUT del cliente para individualizar la
                búsqueda, ya que es posible que existan -en la realidad-
                dos personas con el mismo nombre.
                 */
                System.out.println("Introduce el RUT del cliente: ");
                documentId = new ReadData().leerInt();
                if (housing.searchClient(documentId) == -1){ // El cliente no existe.
                    housing.addHousing(documentId);
                } else {
                    System.out.println("El cliente ya se encuentra registrado.");
                }
                break;
            case 2:
                housing.ShowHousing();
                break;
            case 3:
                documentId = 0;
                do {
                    System.out.println("Ingresa el documentId del cliente a buscar: ");
                    documentId = new ReadData().leerInt();
                } while (documentId == 0);
                housing.showClient(documentId);
                break;
            case 4:
                System.out.println("El total adicional es de: " + housing.calculaTotalAdicional());
                break;
            case 5:
                System.out.println("El total del Bono Descuento es " + housing.calculaTotalBonoDescuento());
                break;
            case  6:
                selectedOption = -1;
                do {
                    System.out.println("Introduce el tipo de alojamiento a buscar (1: Tent, 2: Hotel, 3: Cabaña):");
                    selectedOption = new ReadData().leerInt();
                    if ((selectedOption < 1) || (selectedOption > 3)){
                        selectedOption = -1;
                    }
                } while (selectedOption == -1);
                switch (selectedOption){
                    case 1:
                        answer = "Tent";
                        alj = new Tent();
                        break;
                    case 2:
                        answer = "Hotel";
                        alj = new Hotel();
                        break;
                    case 3:
                        answer = "Cottage";
                        alj = new Cottage();
                        break;
                }

                if ((housing.housingCounter(alj) == 0)){
                    System.out.println("No existen alojamientos registrados de tipo " + answer + ".");
                } else {
                    System.out.println("Cantidad de alojamientos de tipo " + answer +
                            ": " + housing.housingCounter(alj));
                }
                break;
            case 7:
                System.out.println("Introduce el documentId del cliente: ");
                documentId = new ReadData().leerInt();
                index = housing.searchClient(documentId);
                if (index != -1){
                    System.out.println("El valor a cancelar por el cliente es de " +
                            housing.valorAcancelarCliente(documentId));
                } else {
                    System.out.println("El documentId proporcionado no se encuentra registrado.");
                }
                break;
            case 8:
                double incremento = housing.applyIncrement(documentId);
                if (incremento != 0){
                    System.out.println("Al cliente le corresponde un incremento de $ " + incremento + ".");
                } else {
                    System.out.println("Al ciente no le corresponde ningún incremento.");
                }
                break;
            case 9:
                System.out.println("SALIENDO...");
                System.exit(0);
                break;
        }
    } while (selectedOption != 9);

    }

    public static int imprimeOpciones(){
        int opcionSeleccionada = -1;
        System.out.println("***** OPCIONES *****\n1: Ingresar medio de alojamiento.\n" +
                "2: Mostrar medios de alojamiento.\n" +
                "3: Datos de un cliente 'X'.\n" +
                "4: Total adicional.\n" +
                "5: Total 'Bono Descuento'.\n" +
                "6: Cantidad medios de alojamiento 'X'.\n" +
                "7: Valor a cancelar.\n" +
                "8: Aplicar incremento del valor base.\n" +
                "9: SALIR.");

        try {
            opcionSeleccionada = new ReadData().leerInt();
        } catch (NumberFormatException e){
            System.err.println("Error: " +  e.getMessage());
            System.out.println("La respuesta ingresada debe ser un número entre 1 y 9 -inclusive-.");
        }

        return opcionSeleccionada;
    }

    public int pideRut(){
        System.out.println("Ingresa el RUT del cliente: ");
        int rut = new ReadData().leerInt();
        return rut;
    }

}
