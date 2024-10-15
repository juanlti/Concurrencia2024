/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.Ejercicio3;

/**
 *
 * @author juanc
 */
public class Gato extends Thread {

    Plato plato;
    int nombreGato;
    int tipoAnimal;

    public Gato(int nombreGato, Plato plato) {
        this.nombreGato = nombreGato;
        this.plato = plato;
        this.tipoAnimal = 1;
    }

    public void run() {

        this.plato.ingresanGatos();
        this.plato.comiendo(nombreGato, " Gato ");
        this.plato.saliendoGatos(nombreGato);
    }

}
