package tp4.Ejercicio5;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author juan.barrera
 */
/**
 *
 * @author juanc
 */
public class Impresion {

    String tipoImpresora;
    int cantLimites;
    boolean ingresarA = true;
    boolean ingresarB = true;

    public Impresion(String tipoImpresora, int cantLimite) {
        this.tipoImpresora = tipoImpresora;
        this.cantLimites = cantLimite;

    }

    public int cupoDisponible() {
        return this.cantLimites;
    }

    public void impresora(int cantImprimir, String docu, int id) {

        try {
            //tiene cupo y imprime
            this.cantLimites = cantLimites - cantImprimir;

            System.out.println("id " + id + " Impresora " + tipoImpresora + " IMPRIMIENDO tipoDocumento  " + docu + " cantidad a imprimir  " + cantImprimir + " cant disponible proxima  " + this.cantLimites);
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(Impresion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
