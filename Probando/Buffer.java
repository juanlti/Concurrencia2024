/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp7.Probando;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author juanc
 */
public class Buffer {

    private int cantidad;
    private int tamanio;
    Queue<Integer> cola = new LinkedList<>();

    //para exclusión mutua y tener las condiciones asociadas
    private final Lock mutex = new ReentrantLock();

    private Condition productores;

    private Condition consumidores;
    boolean despertar, despertarProductor;

    public Buffer(int tam) {
        this.cantidad = 0;
        this.tamanio = tam;
        this.productores = mutex.newCondition();
        this.consumidores = mutex.newCondition();
        despertar = false;
        despertarProductor = false;
    }

    public void producir(int id) throws InterruptedException {
        mutex.lock();

        while (cantidad == tamanio) {
            if (!despertar) {
                this.despertar = true;
                consumidores.signal();

            }
            this.despertar = false;
            System.out.println("PRODUCTOR A ESPERAR!!!" + id);
            productores.await(); //espera bloqueado y libera el lock para que lo tome otro hilo
            if (!despertar) {
                this.despertar = true;
                consumidores.signal();

            }
            this.despertar = false;
        }

        cantidad++;
        cola.add(cantidad);
        consumidores.signal(); //notifica a un consumidor
        mutex.unlock();

    }

    public void consumir(int id) throws InterruptedException {
        mutex.lock();
        try {
            //System.out.println("CONSUMIDOR R");

            while (cantidad == 0) {
                if (!despertarProductor) {
                    this.despertarProductor = true;
                    productores.signal();
                }
                System.out.println("CONSUMIDOR A ESPERAR!!" + id);
                this.despertarProductor = false;
                consumidores.await(); //espera bloqueado y libera el lock para que lo tome otro hilo

            }
            System.out.println("Consumiendo " + id);

            cantidad--;

            cola.remove();
            System.out.println("Consumio " + this.cola.toString());
            productores.signal(); //notifica a un productor

        } finally {
            mutex.unlock();
        }

    }

}
