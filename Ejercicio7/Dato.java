/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.Ejercicio7;

/**
 *
 * @author juanc
 */
public class Dato {

    int siguiente;
    int totalImpresora;
    String impresion = "";

    public Dato(int totalImpresora) {
        siguiente = 1;
        this.totalImpresora = totalImpresora;

    }

    public synchronized boolean finalizarImpresion(int turno, String informacion) {
        //System.out.println("informacion "+informacion +" turno "+turno);
        if (turno == this.siguiente) {
            this.impresion = impresion + informacion;
            this.siguiente++;
            return true;
        }
        return false;
    }

    public String imprimir(int cant, char datoImprimir) {
        String informacion = " ";
        for (int i = 0; i < cant; i++) {
            informacion = informacion + " " + datoImprimir;
        }
        return informacion;

    }

    public String datoFinalizado() {
        return this.impresion;
    }

}
