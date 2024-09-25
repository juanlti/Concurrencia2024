/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.Ejercicio2;

import java.util.concurrent.Semaphore;

/**
 *
 * @author juanc
 */
public class Compartido {

    private Semaphore proceso1, proceso2, proceso3;

    public Compartido() {
        proceso1 = new Semaphore(1);
        proceso2 = new Semaphore(0);
        proceso3 = new Semaphore(0);

    }

    public void proceso1() throws InterruptedException {
        //tomo el permiso de proceso1, solo 1
        proceso1.acquire();

        System.out.println("proceso 1");
        Thread.sleep(200);
        //otorgo el permiso de proceso3
        proceso3.release(1);

    }

    public void proceso2() throws InterruptedException {
        //tomo el permiso de proceso 2
        proceso2.release(1);
        System.out.println("proceso 2");
        Thread.sleep(200);
        proceso1.release(1);

    }

    public void proceso3() throws InterruptedException {
        //tomo el permiso de proceso 3
        proceso3.acquire(1);
        System.out.println("proceso 3");
        Thread.sleep(200);
        proceso2.release(1);
    }

}
