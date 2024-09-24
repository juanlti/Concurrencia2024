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
public class Test {
      public static void main(String[] args) throws InterruptedException {

        int[] numerosArray = new int[50000];
        int longitudNumeros = numerosArray.length;
        int testSumaTotal = 0;
        for (int i = 0; i < longitudNumeros; i++) {
            int num = util.numrosAleatorios();
            numerosArray[i] = num;
            System.out.println("num "+num);
            testSumaTotal = testSumaTotal + num;

        }
        
        System.out.println("TEST => El resultado correcto es " + testSumaTotal);
        Numeros numeros = new Numeros(numerosArray);
        //(int posicion, Numeros n, String nombreHilo)
        Sumadora[] arraysSumadora = new Sumadora[10];
      
        int postAsignacion = longitudNumeros / arraysSumadora.length;
        
          System.out.println("devision "+postAsignacion);
        //10 hilos
        for (int i = 0; i < arraysSumadora.length; i++) {

            arraysSumadora[i] = new Sumadora(postAsignacion, numeros, i);

        }
        for (int i = 0; i < arraysSumadora.length; i++) {

            arraysSumadora[i].start();

        }
        for (int i = 0; i < arraysSumadora.length; i++) {

            arraysSumadora[i].join();

        }

        System.out.println("suma total " + numeros.resultadoTotal());

    }
}
