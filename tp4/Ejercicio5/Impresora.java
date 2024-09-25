/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.Ejer5;

/**
 *
 * @author juan.barrera
 */
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanc
 */
public class Impresora {

    Semaphore mutex;
    String tipoImpresora;
    int cantLimites;

    public Impresora(String tipoImpresora, int cantLimite) {
        this.tipoImpresora = tipoImpresora;
        this.cantLimites = cantLimite;
        mutex = new Semaphore(1);

    }

    public boolean impresoraDisponible(int cantImprimir, char tipoDocumento) {
        try {
            // tomo el unico permiso disponible
            this.mutex.acquire();
            //verifico si hay cupo disponible
            if (this.cantLimites >= cantImprimir) {
                //sale cantImprimir

                //tiene cupo y imprime
                this.cantLimites = cantLimites - cantImprimir;

                System.out.println("Impresora " + tipoImpresora + " tipoDocumento  " + tipoImpresora + " cantidad a imprimir  " + cantImprimir + " cant disponible proxima  " + this.cantLimites);
                //Thread.sleep(util.numrosAleatorios());
                this.mutex.release();
                return true;

            } else {

            }

        } catch (InterruptedException ex) {
            Logger.getLogger(Impresora.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("No debe estrar con " + this.cantLimites);
        this.mutex.release();
        return false;

    }

    public void cupoDisponible() {

        System.out.println("Cupo disponible debe ser 0 == " + this.cantLimites);
    }

}
