/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2024;

/**
 *
 * @author juanc
 */
public class Carroceria extends Thread {

    Fabrica f;

    public Carroceria(Fabrica f) {
            this.f=f;
    }

    public void run() {

        while (true) {
            f.carroceria();
        }
    }

}
