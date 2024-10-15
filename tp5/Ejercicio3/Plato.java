/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.Ejercicio3;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanc
 */
public class Plato {

    Plato[] comedores;

    int cantPlatos, noHayNadie, cantiadTotalPerros, cantiadTotalGatos;
    Semaphore mutexPerroUltimo, mutexGatoUltimo, mutex, mutexGato, mutexPerro, mutexPerroSaliendo, mutexGatoSaliendo;
    int perrosRotar, gatosRotar, auxPerros, auxGatos;

    public Plato(int cantPlatos, int perrosRotar, int gatosRotar) {
        mutex = new Semaphore(0);
        mutexGato = new Semaphore(1);
        mutexPerro = new Semaphore(1);
        this.cantPlatos = cantPlatos;
        cantiadTotalPerros = 0;
        cantiadTotalGatos = 0;
        this.perrosRotar = perrosRotar;
        this.gatosRotar = gatosRotar;
        mutexPerroSaliendo = new Semaphore(0);
        mutexGatoSaliendo = new Semaphore(0);
        mutexPerroUltimo = new Semaphore(0);
        mutexGatoUltimo = new Semaphore(0);

        auxPerros = 0;
        auxGatos = 0;

    }

    public boolean puedoComenzar() {
        System.out.println("puedo seguir " + cantiadTotalPerros + cantiadTotalGatos);

        return cantiadTotalPerros + cantiadTotalGatos == this.cantPlatos;

    }

    public boolean getCantidadPerros() {
        return cantiadTotalPerros > 0;

    }

    public boolean getCantidadGatos() {
        return cantiadTotalGatos > 0;
    }

    public void despiertaPerros() {
        if (cantiadTotalPerros - perrosRotar >= 0) {
            // tengo al menos 5 perros
            this.cantiadTotalPerros = this.cantiadTotalPerros - perrosRotar;
            mutexPerroSaliendo.release(perrosRotar);
            mutexPerroUltimo.release();

        } else {
            mutexPerroSaliendo.release(cantiadTotalPerros);
            mutexPerroUltimo.release();
            // cantiadTotalPerros = 0;

        }
    }

    public void esperar(String tipo) {
        try {
            this.mutex.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Plato.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //gatosRotar
    public void despiertaGatos() {
        if (cantiadTotalGatos - gatosRotar >= 0) {
            // tengo al menos 3 gatos
            this.cantiadTotalGatos = this.cantiadTotalGatos - gatosRotar;
            mutexGatoSaliendo.release(gatosRotar);
            mutexGatoSaliendo.release();

        } else {
            mutexGatoSaliendo.release(cantiadTotalGatos);
            mutexGatoSaliendo.release();
            // cantiadTotalGatos = 0;

        }
    }

    public void ingresanPerros() {
        try {
            mutexPerro.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Plato.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            cantiadTotalPerros++;
            mutexPerro.release();
            mutexPerroSaliendo.acquire();

        } catch (InterruptedException ex) {
            Logger.getLogger(Plato.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ingresanGatos() {
        try {
            this.mutexGato.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Plato.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            this.cantiadTotalGatos++;
            mutexGato.release();
            this.mutexGatoSaliendo.acquire();

        } catch (InterruptedException ex) {
            Logger.getLogger(Plato.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void comiendo(int nombre, String tipoAnimal) {

        try {
            System.out.println("animal " + nombre + " tipo animal comiendo " + tipoAnimal);
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(Plato.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saliendoPerros(int nombre) {

        try {
            mutexPerroUltimo.acquire();
            auxPerros++;
        } catch (InterruptedException ex) {
            Logger.getLogger(Plato.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (auxPerros == this.perrosRotar) {
            auxPerros = 0;
            this.mutex.release();

        }
        mutexPerroUltimo.release();

    }

    public void saliendoGatos(int nombre) {
        try {
            this.mutexGatoSaliendo.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Plato.class.getName()).log(Level.SEVERE, null, ex);
        }
        auxGatos++;
        if (auxGatos == gatosRotar) {

            gatosRotar = 0;
            this.mutex.release();

        }
        this.mutexGatoSaliendo.release();

    }

}