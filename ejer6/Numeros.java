/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.ejer6;

/**
 *
 * @author juan.barrera
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

    }

    // arreglo de 50 mil y 10 hilos, cada hilo suma 5 mil posiciones
    public int resultadoTotal() {

        return this.sumaTotal;
    }

    public int sumaLocal(int indiceDeHilo, int nombreHilo, int ultimaPosicion) {
        //devuelve el indice del hilo ejecutor
        int posAux = 0;
        int sumaAux = 0;

        int total = 0;
        while (posAux <= indiceDeHilo) {
          
            total = total + numeros[posAux];
            posAux++;
        }
        System.out.println(nombreHilo + " sumo =>  " +    this.sumaTotal +" en posicion "+indiceDeHilo);
        return total;
    }
    
    public synchronized void sumar(int valor) { 
        this.sumaTotal = this.sumaTotal + valor;
    }
}
