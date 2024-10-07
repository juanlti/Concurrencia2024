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
public class Usuario extends Thread {

    String tipoDcomento;
    GestorImpresoras gestorImpresora;
    int cantHojas, id;

    public Usuario(GestorImpresoras gestorImpresora, String unTipoDoc, int id, int cantHojasMas) {
        this.gestorImpresora = gestorImpresora;
        this.tipoDcomento = unTipoDoc;
        this.cantHojas = cantHojasMas;
        this.id = id;

    }

    public void run() {
        int res = 2;

        int i = 0;
        while ((res != 1 && res != 0) && i < 50) {
            try {
                res = this.gestorImpresora.derivarImpresion(this.cantHojas, this.tipoDcomento, this.id);

                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("RES " + res + " i " + i);
            i++;

        }
        System.out.println("Salio " + id + " valor de salida " + res);

    }

}
