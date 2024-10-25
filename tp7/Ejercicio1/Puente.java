/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp7.Ejercicio1;

/**
 *
 * @author juanc
 */
public class Puente {

    boolean puenteDisponible;
    Semaphore pasar, esperando, norte, sur;
    char ultimos;
    int cochesEsperandoLadoContrario, enCirculacion, cantSur, cantNorte;

    public Puente() {
        puenteDisponible = true;
        pasar = new Semaphore(1);
        esperando = new Semaphore(0);
        ultimos = '@';
        cochesEsperandoLadoContrario = 0;
        norte = new Semaphore(0);
        sur = new Semaphore(0);
        enCirculacion = 0;
        cantSur = 0;
        cantNorte = 0;

    }

    public void puenteDisponible(char dirrecion) {
        try {
            this.pasar.acquire();
            if (puenteDisponible) {
                puenteDisponible = false;
                this.ultimos = dirrecion;
                if (this.ultimos == 'S') {
                    sur.release();
                } else {
                    norte.release();
                }
            }
            if (dirrecion == 'S') {

                cantSur++;
            }
            if (dirrecion == 'N') {
                cantNorte++;

            }

            this.pasar.release();

        } catch (InterruptedException ex) {
            Logger.getLogger(Puente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void entrarCocheNorte() {
        try {
            this.norte.acquire();
            System.out.println("Norte cruzando");
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(Puente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void salirCocheNorte() {
        System.out.println("Norte saliendo");

        cantNorte--;
        if (cantNorte == 0) {
            if (cantSur > 0) {
                sur.release();
            }
        } else {
            norte.release();
        }

    }

    public void entrarCocheSur() {
        try {
            sur.acquire();
            System.out.println("sur cruzando");
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(Puente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void salirCocheSur() {
        System.out.println("sur saliendo");

        cantSur--;
        if (cantSur == 0) {
            if (cantNorte > 0) {
                this.norte.release();
            }
        } else {
            sur.release();
        }

    }

}
