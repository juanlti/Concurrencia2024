/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.Ejercicio6;

/**
 *
 * @author juanc
 */
public class Sumadora extends Thread {

    Numeros nros;
    int pos, ultimaPosicion;
    int nombre;

    public Sumadora(int posicion, Numeros n, int nombreHilo) {
        this.nros = n;
        this.pos = posicion;
        this.nombre = nombreHilo;

    }

    public void run() {

        //asignacion
        ultimaPosicion = this.nros.asignacionPorHilo();

        //indiceDeHilo, int nombreHilo, int ultimaPosicion
        int total = this.nros.sumaLocal(5, nombre, ultimaPosicion);

        this.nros.sumar(total);

    }
}
