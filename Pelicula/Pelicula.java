/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pelicula;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanc
 */
public class Pelicula {

    String capitulosIngles[], capitulosCastellano[], capitulosSinIdioma[];
    int indiceI, indiceC, cantCapitulos, capIndice;
    Semaphore redactor, versionIngles, versionCastellano, capituloCastellano, capituloIngles;
    boolean enInglesTerminado, enCastellanoTerminado, filmarFinalizado;

    public Pelicula(int cantCapitulos) {
        indiceI = 0;
        indiceC = 0;
        capIndice = 0;
        this.cantCapitulos = cantCapitulos;
        capitulosIngles = new String[cantCapitulos];
        capitulosCastellano = new String[cantCapitulos];
        capitulosSinIdioma = new String[cantCapitulos];
        versionIngles = new Semaphore(0);
        versionCastellano = new Semaphore(0);
        capituloCastellano = new Semaphore(0);
        capituloIngles = new Semaphore(0);
        redactor = new Semaphore(1);
        enCastellanoTerminado = false;
        enInglesTerminado = false;
        filmarFinalizado = false;
    }

    public boolean filmador() {
        boolean seguir = false;
        try {
            redactor.acquire();
            if (capIndice < this.cantCapitulos) {
                capitulosSinIdioma[capIndice] = "contenido del capitulo " + capIndice;
                System.out.println("Total de capitulos resueltos " + capitulosSinIdioma[capIndice]);

                capIndice++;
                seguir = true;
                capituloCastellano.release();
            }
            redactor.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Pelicula.class.getName()).log(Level.SEVERE, null, ex);
        }
        return seguir;
    }

    public boolean traductorCastellano() {
        boolean seguir = false;
        try {
            capituloCastellano.acquire();

            if (indiceC < cantCapitulos) {
                capitulosCastellano[indiceC] = capitulosSinIdioma[indiceC] + " en castellano | ";
                indiceC++;
                seguir = true;
                this.capituloIngles.release();
                this.versionCastellano.release();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Pelicula.class.getName()).log(Level.SEVERE, null, ex);
        }
        return seguir;
    }

    public void sociosCastellano(int verUnCapitulo) {
        try {
            this.versionCastellano.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Pelicula.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (verUnCapitulo <= this.cantCapitulos && capitulosCastellano[verUnCapitulo] != null) {
            System.out.println("Socio en castellano, viendo capitulo en castellano " + this.capitulosCastellano[verUnCapitulo]);
        }
        this.versionCastellano.release();

    }

    public boolean traductorIngles() {
        boolean seguir = false;
        try {

            capituloIngles.acquire();
            if (indiceI < cantCapitulos) {
                capitulosIngles[indiceI] = capitulosSinIdioma[indiceI] + " en ingles | ";
                indiceI++;
                this.versionIngles.release();
                seguir = true;
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Pelicula.class.getName()).log(Level.SEVERE, null, ex);
        }
        return seguir;
    }

    public void sociosIngles(int verUnCapitulo) {
        try {
            versionIngles.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Pelicula.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (verUnCapitulo <= this.cantCapitulos && capitulosIngles[verUnCapitulo] != null) {
            System.out.println("Socio en ingles, viendo capitulo en ingles " + this.capitulosIngles[verUnCapitulo]);
        }
        versionIngles.release();

    }

    public int obtenerCantCapitulos() {
        return this.cantCapitulos;

    }

}
