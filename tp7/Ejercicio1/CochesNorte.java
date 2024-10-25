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
public class CocheNorte extends Thread {

    Puente puente;

    public CocheNorte(Puente puente) {
        this.puente = puente;
    }

    public void run() {

        this.puente.puenteDisponible('N');
        this.puente.entrarCocheNorte();
        this.puente.salirCocheNorte();
    }

}
