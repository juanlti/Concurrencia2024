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
public class Perro extends Thread {

    Plato plato;
    int nombrePerro;
    int tipoAnimal;

    public Perro(int nombrePerro, Plato plato) {
        this.nombrePerro = nombrePerro;
        this.plato = plato;

    }

    public void run() {

        this.plato.ingresanPerros();
        this.plato.comiendo(nombrePerro, " Perro ");
        this.plato.saliendoPerros(nombrePerro);
    }
}
