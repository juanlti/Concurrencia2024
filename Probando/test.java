/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp7.Probando;

/**
 *
 * @author juanc
 */
public class test {

    public static void main(String[] args) throws InterruptedException {
        Buffer buffer = new Buffer(5);
        Productor[] productores = new Productor[10];
        Consumidor[] consumidores = new Consumidor[10];
        int productoresTotal = productores.length;
        int consumidoresTotal = consumidores.length;
        for (int i = 0; i < productoresTotal; i++) {
            productores[i] = new Productor(buffer, i);
        }
        for (int i = 0; i < consumidoresTotal; i++) {
            consumidores[i] = new Consumidor(buffer, i);
        }

        for (int i = 0; i < productoresTotal; i++) {
            productores[i].start();
        }
        for (int i = 0; i < consumidoresTotal; i++) {
            consumidores[i].start();
        }
        for (int i = 0; i < productoresTotal; i++) {
            productores[i].join();
        }
        for (int i = 0; i < consumidoresTotal; i++) {
            consumidores[i].join();
        }

        System.out.println("ultimo ");

    }

}
