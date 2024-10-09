/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.Ejercicio2;

/**
 *
 * @author juanc
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {

        Plato plato = new Plato(60, 5);
        Perro[] perros = new Perro[30];
        Gato[] gatos = new Gato[20];
        int cantPerros, cantGatos;
        cantPerros = perros.length;
        cantGatos = gatos.length;
        for (int i = 0; i < cantPerros; i++) {
            perros[i] = new Perro(i, plato);

        }
        for (int i = 0; i < cantGatos; i++) {
            gatos[i] = new Gato(i, plato);

        }

        for (int i = 0; i < cantPerros; i++) {
            perros[i].start();
        }

        for (int i = 0; i < cantGatos; i++) {
            gatos[i].start();
        }
        for (int i = 0; i < cantPerros; i++) {
            perros[i].join();
        }

        for (int i = 0; i < cantGatos; i++) {
            gatos[i].join();
        }
        System.out.println("Comedor finalizado");

    }

}
