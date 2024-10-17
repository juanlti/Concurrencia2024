/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.Ejercicio7;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanc
 */
public class Mirador {

    Semaphore mutexTobogan1, mutexTobogan2, todasLasPersonas, mutexEncargado;
    int visitantes, lugarDisponible;
    boolean tobogan1Libre, tobogan2Libre;

    public Mirador() {
        todasLasPersonas = new Semaphore(0);
        mutexEncargado = new Semaphore(0);
        mutexTobogan1 = new Semaphore(0);
        mutexTobogan2 = new Semaphore(0);
        visitantes = 0;
        tobogan1Libre = true;
        tobogan2Libre = true;
        lugarDisponible = -1;
    }

    public int ingresar(int nombre) {
        try {
            //todos las personas
            visitantes++;
            System.out.println("Ingreso el cliente  " + nombre);
            todasLasPersonas.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Mirador.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lugarDisponible;
    }

    public void verificarDisponibilidadT1() {

        if (this.tobogan1Libre) {
            this.tobogan1Libre = false;
            this.visitantes--;
            this.lugarDisponible = 1;
            todasLasPersonas.release();

        }
    }

    public void verificarDisponibilidadT2() {

        if (this.tobogan2Libre) {
            this.visitantes--;
            this.tobogan2Libre = false;
            this.lugarDisponible = 2;
           todasLasPersonas.release();

        }
    }

    public boolean hayGente() {
        return this.visitantes > 0;
    }
    public void tobogan1() {
        try {

            Thread.sleep(200);

        } catch (InterruptedException ex) {
            Logger.getLogger(Mirador.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.tobogan1Libre = true;
    }

    public void tobogan2() {
        try {

            Thread.sleep(350);
        } catch (InterruptedException ex) {
            Logger.getLogger(Mirador.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.tobogan2Libre = true;
    }
}
