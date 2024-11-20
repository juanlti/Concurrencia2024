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
public class Test {

    public static void main(String[] args) {

        Baile baile = new Baile();
        Caballero[] c = new Caballero[35];
        Dama[] d = new Dama[30];

        for (int i = 0; i < c.length; i++) {
            c[i] = new Caballero(baile, i);

        }
        for (int i = 0; i < d.length; i++) {
            d[i] = new Dama(baile, i);
        }

        for (int i = 0; i < c.length; i++) {
            c[i].start();

        }
        for (int i = 0; i < d.length; i++) {
            d[i].start();
        }
    }
}
