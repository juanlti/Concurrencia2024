/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.Ejercicio5;

/**
 *
 * @author juanc
 */
public class Usuario extends Thread {

    char tipoDcomento;
    GestorImpresoras gestorImpresora;
    int cantHojas;

    public Usuario(GestorImpresoras gestorImpresora, char unTipoDoc, int cantHojasMas) {
        this.gestorImpresora = gestorImpresora;
        this.tipoDcomento = unTipoDoc;
        this.cantHojas = cantHojasMas;

    }

    public void run() {
        int res = 5;
        while (res == 5) {
            res = this.gestorImpresora.derivarImpresion(this.cantHojas, this.tipoDcomento);

        }

    }

}
