/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.Ejercicio4;

/**
 *
 * @author juanc
 */
public class Visitante extends Thread {

    String visitante = "";
    Area[] areas;
    int ocuparUnLugar = 0;
    boolean cortar = false;

    public Visitante(String nombreVisitantes, Area[] unaArea, int ocupar) {
        areas = unaArea;
        this.visitante = nombreVisitantes;
        this.ocuparUnLugar = ocupar;
    }

    public String getNombre() {
        return this.visitante;
    }

    public void run() {
        int posArea = 0;
        Area unArea = areas[posArea];
        while (posArea < areas.length) {

            cortar = unArea.reservar(ocuparUnLugar, this.getNombre());
            if (cortar) {
                posArea++;
                unArea = areas[posArea];
            } else {
                return;
            }
        }

    }

}
