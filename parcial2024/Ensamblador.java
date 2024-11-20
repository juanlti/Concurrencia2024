/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2024;

/**
 *
 * @author juanc
 */
public class Ensamblador extends Thread {
    Fabrica f;
    public Ensamblador(Fabrica f) {
           this.f=f;
    }

    public void run() {
        
        while(true){
                f.ensamblador();
        }
    }
}
