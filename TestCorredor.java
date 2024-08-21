/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrente2024.tp1.Ejercicio6;

/**
 *
 * @author juanc
 */
public class TestCorredor {

    public static void main(String[] args) throws InterruptedException {
        // creo 4 corredores
        Corredor c1 = new Corredor("Juan");
        Corredor c2 = new Corredor("Bruno");
        Corredor c3 = new Corredor("Mariana");
        Corredor c4 = new Corredor("Marina");

        // creo 4 hilos con los 4 corredores
        Thread Hc1 = new Thread(c1);
        Thread Hc2 = new Thread(c2);
        Thread Hc3 = new Thread(c3);
        Thread Hc4 = new Thread(c4);

        // 4 hilos de corredores, comienzan
        Hc1.start();
        Hc4.start();
        Hc2.start();
        Hc3.start();

        System.out.println("Hilo ganador");
        Hc1.join();
        Hc2.join();
        Hc3.join();
        Hc4.join();
        System.out.println("Resultados");
        System.out.println(c1.datos());
        System.out.println("-------------------");
        System.out.println(c2.datos());
        System.out.println("-------------------");
        System.out.println(c3.datos());
        System.out.println("-------------------");
        System.out.println(c4.datos());

    }

}
