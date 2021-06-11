package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadData {

    public String leerTexto() {
        String textoIngresado = "";
        try {
            InputStreamReader input = new InputStreamReader(System.in);
            BufferedReader buffer = new BufferedReader(input);
            textoIngresado = buffer.readLine();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return textoIngresado;
    }

    public double leerDouble() {
        double datoDouble = 0;
        try {
            datoDouble = Double.valueOf(leerTexto());
        } catch (NumberFormatException e) {
            System.err.println("Error: " + e.getMessage());
            System.out.println("The input should be text.");
        }

        return datoDouble;
    }

    public int leerInt() {
        int datoInt = -1;
        try {
            datoInt = Integer.parseInt(leerTexto());
        } catch (NumberFormatException e) {
            System.err.println("Error: " + e.getMessage());
            System.out.println("The input should be a number.");
        }

        return datoInt;
    }

}
