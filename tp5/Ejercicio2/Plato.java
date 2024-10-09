/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.Ejercicio2;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanc
 */
public class Plato {

    String comedoresNoDisponibles, comerdoresDisponibles, animalesSinComer;
    Plato[] comedores;

    int cantPlatos, noHayNadie, cantPerros, cantGatos, tipoAnimalActual;
    Semaphore permisos;
    boolean primerosEnEntrar;

    public Plato(int cantPlatos, int rotar) {

        noHayNadie = 0;
        this.cantPlatos = cantPlatos;
        permisos = new Semaphore(cantPlatos);
        cantPerros = 0;
        cantGatos = 0;
        primerosEnEntrar = true;
        tipoAnimalActual = -1;

    }

    public boolean verificarComida() {
        return this.cantPlatos > 0;
    }

    public int ingresoPerros(int nombreAnimal, int tipoAnimal) {
        System.out.println("debe ser 2 " + this.noHayNadie);

        try {
            this.permisos.acquire();
            this.cantPerros++;
            this.cantPlatos--;

        } catch (InterruptedException ex) {
            Logger.getLogger(Plato.class.getName()).log(Level.SEVERE, null, ex);
        }

        return noHayNadie;

    }

    public int ingresar(int tipoAnimal) {
        if (primerosEnEntrar) {
            primerosEnEntrar = false;
            noHayNadie = tipoAnimal;

        } else {
            if (noHayNadie == tipoAnimal) {
                noHayNadie = tipoAnimal;

            } else {
                noHayNadie = tipoAnimal;
            }
        }

        return noHayNadie;
    }

    public int ingresoGatos(int nombreAnimal, int tipoAnimal) {
        System.out.println("debe ser 1 " + this.noHayNadie);

        try {
            this.permisos.acquire();
              this.cantGatos++;
            this.cantPlatos--;

        } catch (InterruptedException ex) {
            Logger.getLogger(Plato.class.getName()).log(Level.SEVERE, null, ex);
        }

        return noHayNadie;

    }

    public void comiendo() {

        try {
            System.out.println("animal " + " comiendo ");
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(Plato.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saliendo(int tipoAnimal) {

        this.cantAnimales--;
        System.out.println("animal " + " comiendo " + tipoAnimal);
        if (this.cantAnimales == 0) {
            System.out.println(" ultimo animal saliendo " + tipoAnimal);
            System.out.println("ROTAR " + this.noHayNadie);
            this.noHayNadie = 0;

            // this.permisos.release();
        }
        //this.permisos.release();

    }

}
