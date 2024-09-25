/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.Ejercicio7;

/**
 *
 * @author juanc
 */
public class Impresora extends Thread {

    Dato dato;
    int cantidad, turno;
    char imprimir;

    public Impresora(char imprimir, int cant, int turno, Dato dato) {
        this.dato = dato;
        this.cantidad = cant;
        this.turno = turno;
        this.imprimir = imprimir;

    }

    public void run() {
        String yaImprimio = "";
        while (yaImprimio.equals("")) {

            yaImprimio = this.dato.imprimir(cantidad, imprimir);
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(Impresora.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        boolean cortar = false;
        while (!cortar) {

            cortar = this.dato.finalizarImpresion(turno, yaImprimio);
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(Impresora.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
