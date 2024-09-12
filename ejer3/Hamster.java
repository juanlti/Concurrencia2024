/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.ejer3;

/**
 *
 * @author juanc
 */
public class Hamster extends Thread {

    private Comer comer;
    private Domir dormir;
    private Correr correr;
    private String nombre;

    public Hamster(Comer unC, Domir unD, Correr unCo, String unNombre) {
        this.comer = unC;
        this.dormir = unD;
        this.correr = unCo;
        this.nombre = unNombre;

    }

    public void run() {

        while (true) {

            if (this.comer.getEntrar(this.nombre)) {
                //come

                //System.out.println("Cuantos entraron ? " + this.nombre);
                this.comer.comer(nombre);

            }
            if (this.dormir.getEntrar(this.nombre)) {
                //duerme
                this.dormir.dormir(nombre);
            }

            if (this.correr.getEntrar(this.nombre)) {
                //corre
                this.correr.correr(nombre);
            }

        }
    }

}
