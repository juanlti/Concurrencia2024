/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Baile;

/**
 *
 * @author juanc
 */
public class Caballero extends Thread {

    Baile b;
    int n;

    public Caballero(Baile b, int n) {
        this.b = b;
        this.n = n;
    }

    public void run() {
        this.b.filaVaron(n);
        this.b.bailar();
    }
}
