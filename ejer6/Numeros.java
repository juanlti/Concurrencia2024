/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.Ejercicio6;

/**
 *
 * @author juanc
 */
public class Numeros {

    private int[] numeros;
    private int ultimaPosicion;
    private int longitudTotal;
    private int sumaTotal;

    public Numeros(int[] n) {
        numeros = n;
        this.ultimaPosicion = 0;
        this.longitudTotal = n.length;
        this.sumaTotal = 0;

        //this.longitudTotal / por la cant. de hilos
        this.longitudTotal = longitudTotal / 10;

    }

    // arreglo de 50 mil y 10 hilos, cada hilo suma 5 mil posiciones
    public int resultadoTotal() {

        return this.sumaTotal;
    }

    public synchronized int asignacionPorHilo() {
        ultimaPosicion = ultimaPosicion + longitudTotal;
        return ultimaPosicion;
    }

    public int sumaLocal(int indiceDeHilo, int nombreHilo, int indiceFinal) {
        //devuelve el indice del hilo ejecutor

        int total = 0;
        indiceDeHilo = indiceFinal - longitudTotal;
        for (int i = indiceDeHilo; i < indiceFinal; i++) {

            total = total + numeros[i];
            //System.out.println("mis valores " + this.numeros[i]);
        }
        System.out.println("Soy hilo " + nombreHilo + " indice " + indiceDeHilo + " mi total " + total);
        return total;
    }

    public synchronized void sumar(int valor) {
        this.sumaTotal = this.sumaTotal + valor;
    }
}
