/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pelicula;

/**
 *
 * @author juanc
 */
public class Test {

    public static void main(String[] args) {

        Pelicula unaPelicula = new Pelicula(30);

        EnIngles ingles = new EnIngles(unaPelicula);
        EnCastellano enCastellano = new EnCastellano(unaPelicula);
        Redactor r = new Redactor(unaPelicula);
        SocioIngles[] socioI = new SocioIngles[10];
        SocioCastellano[] socioC = new SocioCastellano[10];
        r.start();
        ingles.start();
        enCastellano.start();
        for (int i = 0; i < 10; i++) {
            socioI[i] = new SocioIngles(unaPelicula);
            socioC[i] = new SocioCastellano(unaPelicula);

        }
        for (int i = 0; i < 10; i++) {
            socioI[i].start();
            socioC[i].start();
        }

    }

}
