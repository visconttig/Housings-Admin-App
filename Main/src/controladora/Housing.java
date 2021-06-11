package controladora;

import com.company.*;

import java.util.ArrayList;
import java.util.Iterator;

public class Housing {
    private ArrayList<Accommodation> housings;

    public Housing(ArrayList<Accommodation> housings) {
        this.housings = housings;
    }

    public void setHousings(ArrayList<Accommodation> housings) {
        this.housings = housings;
    }

    public ArrayList<Accommodation> getHousings() {
        return housings;
    }

    public int searchHousing(Accommodation kindOfHousing) {
        Iterator iterator = housings.iterator();
        int index = -1;
        while (iterator.hasNext()) {
            Accommodation m = (Accommodation) iterator.next();
            if (m.getClass() == kindOfHousing.getClass()) { //Chequeamos la clase ya que sólo puede haber un objeto de ese tipo
                index = housings.indexOf(m);
                // TEST
                System.out.println("CLASS: " + m.getClass());
            }
        }

        return index;
    }

    public int searchClient(int rutCliente) {
        int index = -1;
        for (int i = 0; i <= housings.size() - 1; i++) {
            if (housings.get(i).getDatosCliente().getRutCliente() == rutCliente) {
                return index = i;
            }
        }
        // El cliente no está registrado.
        return index;
    }

    // ************************** PENDIENTE RETURN***********
    public boolean addHousing(int rut) {
        String resp = "";
        int tipoDeAlojamiento = -1;
        int n;
        do {
            System.out.println("Ingresa el tipo de alojamiento a agregar (1 - 2 - 3):\n" +
                    "1: Tent.\n" +
                    "2: Cottage.\n" +
                    "3: Hotel.\n");
            n = new ReadData().leerInt();
            if ((n > 0) && (n <= 3)) {
                tipoDeAlojamiento = n;
            } else {
                System.out.println("La opción ingresada debe ser 1, 2 o 3.");
            }
        } while ((n < 1) || (n > 3));
        System.out.println("Introduce el nombre del cliente: ");
        String nombre = new ReadData().leerTexto();
        ClientInfo cliente = new ClientInfo(nombre, rut);
        String tipoTemporada = "";
        do {
            System.out.println("Introduce el tipo de temporada ('ALTA' , 'MEDIA' , 'BAJA':  ");
            resp = new ReadData().leerTexto();
            if ((resp.equalsIgnoreCase("alta") ||
                    resp.equalsIgnoreCase("baja") ||
                    (resp.equalsIgnoreCase("media")))) {
                tipoTemporada = resp;
            }
        } while (!(resp.equalsIgnoreCase("alta")) &&
                !(resp.equalsIgnoreCase("baja")) &&
                !(resp.equalsIgnoreCase("media")));

        double valorBaseNoche;
        do {
            System.out.println("Introduce el valor base x noche: ");
            valorBaseNoche = new ReadData().leerDouble();
        } while (valorBaseNoche <= 0);
        int cantidadDeNoches;
        do {
            System.out.println("Introduce la cantidad de noches: ");
            cantidadDeNoches = new ReadData().leerInt();
        } while (cantidadDeNoches <= 0);
        switch (tipoDeAlojamiento) {
            case 1: // ES de tipo tent
                int cantidadPersonas;
                do {
                    System.out.println("Ingresa la cantidad de personas: ");
                    cantidadPersonas = new ReadData().leerInt();
                } while (cantidadPersonas <= 0);

                Tent tent = new Tent(cliente, tipoTemporada,
                        valorBaseNoche, cantidadDeNoches,
                        cantidadPersonas);
                housings.add(tent);
                break;

            case 2: // Tipo Cottage
                boolean chimenea = false;
                int capacidad;
                boolean esFumador = false;
                boolean conDesayuno;
                resp = "";
                do {
                    System.out.println("Ingresa la capacidad: ");
                    capacidad = new ReadData().leerInt();
                } while (capacidad <= 0);

                do {
                    System.out.println("Es fumador? (SI - NO): ");
                    resp = new ReadData().leerTexto();
                    if (resp.equalsIgnoreCase("si")) {
                        esFumador = true;
                    } else if (resp.equalsIgnoreCase("no")) {
                        esFumador = false;
                    } else {
                        System.out.println("La respuesta ingresada debe ser 'SI' o 'NO'.");
                    }
                } while (!(resp.equalsIgnoreCase("si")) && !(resp.equalsIgnoreCase("no")));

                resp = "";
                do {
                    System.out.println("Con chimenea? (SI - NO): ");
                    resp = new ReadData().leerTexto();
                    if (resp.equalsIgnoreCase("si")) {
                        chimenea = true;
                    } else if (resp.equalsIgnoreCase("no")) {
                        chimenea = false;
                    }
                } while (!(resp.equalsIgnoreCase("si")) && !(resp.equalsIgnoreCase("no")));

                Cottage cottage = new Cottage(cliente, tipoTemporada, valorBaseNoche,
                        cantidadDeNoches, esFumador, capacidad, chimenea);
                housings.add(cottage);
                break;
            case 3: // Es de tipo Hotel
                capacidad = -1;
                esFumador = false;
                conDesayuno = false;
                resp = "";
                do {
                    System.out.println("Ingresa la capacidad: ");
                    capacidad = new ReadData().leerInt();
                } while (capacidad <= 0);

                do {
                    System.out.println("Es fumador? (SI - NO): ");
                    resp = new ReadData().leerTexto();
                    if (resp.equalsIgnoreCase("si")) {
                        esFumador = true;
                    } else if (resp.equalsIgnoreCase("no")) {
                        esFumador = false;
                    } else {
                        System.out.println("La respuesta ingresada debe ser 'SI' o 'NO'.");
                    }
                } while (!(resp.equalsIgnoreCase("si")) && !(resp.equalsIgnoreCase("no")));

                resp = "";
                do {
                    System.out.println("Es con desayuno? ('SI' - 'NO'): ");
                    resp = new ReadData().leerTexto();
                    if (resp.equalsIgnoreCase("si")) {
                        conDesayuno = true;
                    } else if (resp.equalsIgnoreCase("no")) {
                        conDesayuno = false;
                    } else {
                        System.out.println("La respuesta ingresada debe ser 'SI' o 'NO'.");
                    }
                } while (!(resp.equalsIgnoreCase("si") && !(resp.equalsIgnoreCase("no"))));

                Hotel hotel = new Hotel(cliente, tipoTemporada, valorBaseNoche,
                        cantidadDeNoches, esFumador, capacidad, conDesayuno);
                housings.add(hotel);
                break;
        }
        return true;

    }

    public void ShowHousing() {
        // Chequeamos que existan registros
        if (!(housings.isEmpty())) {
            String tipo = "";
            for (int i = 0; i <= housings.size() - 1; i++) {
                tipo = housings.get(i).getClass().toString().substring(getClass().toString().lastIndexOf('.'));
                System.out.println("* * *" +
                        "\nTipo: " + tipo +
                        "\nCliente: " + housings.get(i).getDatosCliente().getNombreCliente() +
                        "\nRut: " + housings.get(i).getDatosCliente().getRutCliente() +
                        "\nTipo de temporada: " + housings.get(i).getTipoTemporada() +
                        "\nValor base noche: " + housings.get(i).getValorBaseNoche() +
                        "\nCantidad de noches: " + housings.get(i).getCantidadDeNoches() +
                        "\n* * *");
            }

            // IMPLEMENTAR OTROS CASOS (EJ; SI ES UN HOTEL HAY MAS INFO QUE MOSTRAR !
        } else {
            System.out.println("* * *" +
                    "\nNo existen alojamientos registrados." +
                    "\n* * *");
        }


    }

    public void showClient(int rut) {
        int indice = searchClient(rut);
        if (indice != -1){
            System.out.println("* * * Info cliente * * *");
            System.out.println("Nombre: " + housings.get(indice).getDatosCliente().getNombreCliente() +
                    "\nRut: " + housings.get(indice).getDatosCliente().getRutCliente() +
                    "\nAlojamiento: " + getTipoAlojamiento(housings.get(indice)) +
                    "\nTemporada: " + housings.get(indice).getTipoTemporada() +
                    "\nValor base noche: " + housings.get(indice).getValorBaseNoche() );
            // *********** AGREGAR OTROS VALORES A MOSTRAR****************
        }

    }


    public String getTipoAlojamiento(Accommodation alojamiento){
        String tipo = housings.get(housings.indexOf(alojamiento)).getClass().toString();
        tipo = tipo.substring(tipo.lastIndexOf('.') + 1);

        return tipo;
    }

    public double calculaTotalAdicional(){
        double adicional = 0;
        Accommodation m;
        for (int i = 0; i <= housings.size()-1; i++){
            m = housings.get(i);
            if (m instanceof Hotel){
                adicional += ((Hotel) m).adicional();
            }
        }

        return adicional;
    }

    public double calculaTotalBonoDescuento(){
        double totalBono = 0;
        for (int i = 0; i <= housings.size()-1; i++){
            totalBono += housings.get(i).bonoDescuento();
        }

        return totalBono;
    }

    public int housingCounter(Accommodation aloj){
        int cantidadAlojamientosX = 0;
        Accommodation alojamientoX = aloj;
        for (int i = 0; i <= housings.size()-1; i++){
           if (housings.get(i).getClass().equals(alojamientoX.getClass())){
               cantidadAlojamientosX ++;
           }
        }
        return cantidadAlojamientosX;
    }

    public double valorAcancelarCliente(int rut){
        int index = searchClient(rut);
        double valorAcancelarCliente = valorAcancelarClienteX(index);

        return valorAcancelarCliente;
    }

    private double valorAcancelarClienteX(int index){
        double valorAcancelarCliente = 0;
        ClientInfo cliente = housings.get(index).getDatosCliente();
        for (int i = 0; i <= housings.size()-1; i++){
           if (housings.get(i).getDatosCliente().equals(cliente)){
               valorAcancelarCliente = housings.get(i).valorACancelar();
           }
        }
        return valorAcancelarCliente;
    }


    public double applyIncrement(int rut){
        int k = searchClient(rut);
        double increment = 0;
        Accommodation ma = housings.get(k);
        if (ma instanceof Cottage){
            increment = ((Cottage) ma).incrementaValorBase();
        }

        return increment;
    }
}

