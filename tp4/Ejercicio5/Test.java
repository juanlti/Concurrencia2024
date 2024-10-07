/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.Ejercicio5;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanc
 */
public class Test {

    public static void main(String[] args) {

        Impresion A1 = new Impresion("A1", 53);
        Impresion A2 = new Impresion("A2", 35);
        Impresion B = new Impresion("B", 45);
        //GestorImpresoras gestorImpresora = new GestorImpresoras(A, B);
        //public Usuario(GestorImpresoras gestorImpresora, char unTipoDoc, int cantHojasMas) {

        GestorImpresoras gestor = new GestorImpresoras(A1, A2, B);

        // usuarios
        Usuario[] usuariosA = new Usuario[5];
        Usuario[] usuariosB = new Usuario[3];
        Usuario[] usuariosX = new Usuario[2];
        for (int i = 0; i < usuariosA.length; i++) {
            usuariosA[i] = new Usuario(gestor, "A", i, 10);

        }
        for (int i = 0; i < usuariosB.length; i++) {
            usuariosB[i] = new Usuario(gestor, "B", i, 10);

        }
        for (int i = 0; i < usuariosX.length; i++) {
            usuariosX[i] = new Usuario(gestor, "X", i, 10);

        }

        for (int i = 0; i < usuariosA.length; i++) {
            usuariosA[i].start();

        }
        for (int i = 0; i < usuariosB.length; i++) {

            usuariosB[i].start();

        }
        for (int i = 0; i < usuariosX.length; i++) {
            usuariosX[i].start();

        }

        // join
        for (int i = 0; i < usuariosA.length; i++) {
            try {
                usuariosA[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        for (int i = 0; i < usuariosB.length; i++) {

            try {
                usuariosB[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        for (int i = 0; i < usuariosX.length; i++) {
            try {
                usuariosX[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        gestor.disponibilidadRestante();

    }

}
