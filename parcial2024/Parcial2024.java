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
public class Parcial2024 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //capacidadRuedas, int capacidadPuertas, int capacidadCarroceria
        Fabrica f = new Fabrica(600, 300, 100);
        Rueda r = new Rueda(f);
        Puerta p = new Puerta(f);
        Carroceria c = new Carroceria(f);
        Ensamblador e = new Ensamblador(f);

        r.start();
        p.start();
        c.start();
        e.start();

    }

}
