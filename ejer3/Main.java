/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.ejer3;

/**
 *
 * @author juanc
 */
public class Main {

    public static void main(String[] args) {

        Domir dormir = new Domir();
        Correr correr = new Correr();
        Comer comer = new Comer();

        //3 hamsters de tipo hilo
        Hamster h1 = new Hamster(comer, dormir, correr, "H1");
        Hamster h2 = new Hamster(comer, dormir, correr, "H2");
        Hamster h3 = new Hamster(comer, dormir, correr, "H3");

        h1.start();
        h2.start();
        h3.start();

    }

}
