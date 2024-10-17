/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.Ejercicio7;

/**
 *
 * @author juanc
 */
public class Persona extends Thread {

    Mirador mirador;
    int toboganAsignado, nombre;

    public Persona(Mirador mirador, int nombre) {
        this.mirador = mirador;
        toboganAsignado = -1;
        this.nombre = nombre;
    }

    public void run() {
        while (toboganAsignado == -1) {
            toboganAsignado = this.mirador.ingresar(this.nombre);
            if (toboganAsignado == 1) {

                this.mirador.tobogan1();
                System.out.println(this.nombre + " salida por el tobogan 1 ");
            } else {
                if (toboganAsignado == 2) {
                    this.mirador.tobogan2();
                    System.out.println(this.nombre + " salida por el tobogan 2 ");
                } else {
                    System.out.println(this.nombre + " vuelve a intentarlo valor " + this.toboganAsignado);
                }

            }

        }

    }
}
