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
public class Test {

    public static void main(String[] args) throws InterruptedException {

        Plato plato = new Plato(50, 3, 10);
        Rotar rotar = new Rotar(plato);

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
        rotar.start();

        for (int i = 0; i < cantPerros; i++) {
            perros[i].join();
        }

        for (int i = 0; i < cantGatos; i++) {
            gatos[i].join();
        }
        rotar.join();
        System.out.println("Comedor finalizado");

    }

}
