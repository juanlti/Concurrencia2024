/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2024;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanc
 */
public class Fabrica {

    Semaphore semRueda, semPuerta, semCarroceria, semEnsamblador, puertas, ruedas, carroceria;
    int cantRuedas, cantPuerta, cantCarroceria, capacidadRuedas, capacidadPuertas, capacidadCarroceria;
    int puertasAux, ruedasAux, carroceriaAux, ensambladorAux;
    private final Semaphore puertasEspera;
    private final Semaphore ruedasEspera;
    private final Semaphore carroceriaEspera;

    public Fabrica(int capacidadRuedas, int capacidadPuertas, int capacidadCarroceria) {
        // valores pasados por parametros segun enunciado
        this.capacidadCarroceria = capacidadCarroceria;
        this.capacidadPuertas = capacidadPuertas;
        this.capacidadRuedas = capacidadRuedas;
        // fin  de parametros segun enunciado
        // inicio de permisos para los procesos
        this.semCarroceria = new Semaphore(1);
        this.semRueda = new Semaphore(1);
        this.semPuerta = new Semaphore(1);
        this.semEnsamblador = new Semaphore(1);
        // fin de permisos para los procesos
        //inicio de semaforos genericos para contabilizar la cantidad de productos producidos respectivamente
        this.puertas = new Semaphore(0);
        this.ruedas = new Semaphore(0);
        this.carroceria = new Semaphore(0);
        puertasAux = 0;
        ruedasAux = 0;
        carroceriaAux = 0;
        ensambladorAux = 0;
        this.puertasEspera = new Semaphore(0);
        this.ruedasEspera = new Semaphore(0);
        this.carroceriaEspera = new Semaphore(0);

    }

    public void puerta() {
        try {
            this.semPuerta.acquire();
            while (puertasAux > capacidadPuertas) {

                System.out.println("vaciando stock");
                // puertasAux = 0;
                puertasEspera.acquire();

            }

            puertasAux++;
            this.puertas.release();
            this.semPuerta.release();

        } catch (InterruptedException ex) {
            Logger.getLogger(Fabrica.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void rueda() {
        try {
            this.semRueda.acquire();
            while (ruedasAux > capacidadRuedas) {

                System.out.println("vaciando stock");
                // ruedasAux = 0;
                ruedasEspera.acquire();

            }

            ruedasAux++;
            System.out.println("cantidad de ruedas en metodoRuedas " + ruedasAux);
            this.ruedas.release();
            this.semRueda.release();

        } catch (InterruptedException ex) {
            Logger.getLogger(Fabrica.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void carroceria() {
        try {
            this.semCarroceria.acquire();
            while (carroceriaAux > capacidadCarroceria) {
                System.out.println("vaciando stock");
                // carroceriaAux = 0;
                carroceriaEspera.acquire();

            }

            carroceriaAux++;
            this.carroceria.release();
            this.semCarroceria.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Fabrica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ensamblador() {
        try {
            this.semEnsamblador.acquire();
            while (ensambladorAux > 5) {

                System.out.println("liberando vehiculos producidos, esperar");
                Thread.sleep(200);
                ensambladorAux = 0;

            }

            //avanza con ruedas
            this.ruedas.acquire(4);
            ruedasAux = ruedasAux - 4;
            System.out.println("cantidad de ruedas despues de restar -4 => " + ruedasAux);

            if (ruedasAux < capacidadRuedas) {
                ruedasEspera.release();
            }
            //avanza con puertas 
            //      this.puertas.release();    puertasAux = 0;
            this.puertas.acquire(2);
            puertasAux = puertasAux - 2;
            if (puertasAux < this.capacidadPuertas) {
                puertasEspera.release();
            }

            this.carroceria.acquire(1);
            carroceriaAux--;
            if (carroceriaAux < capacidadCarroceria) {
                carroceriaEspera.release();
            }
            System.out.println("Un vehiculo producido ");

            ensambladorAux++;
            this.semEnsamblador.release();

        } catch (InterruptedException ex) {
            Logger.getLogger(Fabrica.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
