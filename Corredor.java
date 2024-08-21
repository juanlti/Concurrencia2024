/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrente2024.tp1.Ejercicio6;

import static java.lang.Thread.sleep;

/**
 *
 * @author juanc
 */
public class Corredor implements Runnable {

    private String nombre = "";
    private int distanciaRecorrida;
    private int distanciaTotal;
    private int cantPasos;

    public Corredor(String unNombre) {
        this.nombre = unNombre;
        this.distanciaRecorrida = 0;
        this.cantPasos = 0;
    }

    public String datos() {
        return "Nombre: " + this.nombre + "\n"
                + "Distancia recorrida: " + this.distanciaRecorrida + "\n"
                + "Distancia total: " + this.distanciaTotal + "\n"
                + "Cantidad de pasos: " + this.cantPasos;
    }

    @Override
    public void run() {
        while (this.cantPasos < 25) {

            //System.out.println("distancia recorrida 0 al inicio " + this.distanciaRecorrida);
            this.distanciaRecorrida = NumeroAleatorio.distanciaRecorrida();
            // System.out.println("distancia recorrida 0 al despues  " + this.distanciaRecorrida);
            this.distanciaTotal = distanciaTotal + distanciaRecorrida;
            // System.out.println("total " + this.distanciaTotal);
            try {
                //descansa
                sleep(NumeroAleatorio.descansa());
                //continua
                this.cantPasos = cantPasos + 1;
            } catch (InterruptedException ex) {
                System.out.println("Una interrupcion del hilo " + ex.getMessage());
            }
        }

    }
    // si sale del run() muere el hilo

}
