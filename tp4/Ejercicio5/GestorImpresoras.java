/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.Ejercicio5;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanc
 */
public class GestorImpresoras {

    Impresion impresoraA1, impresoraA2, impresoraB;
    Semaphore mutexA, mutexA2, mutexB;
    boolean disponibleA1, disponibleA2, disponibleB, impresaFalloA1, impresaFalloA2, impresaFalloB;
    int resA1, resA2, resB;

    public GestorImpresoras(Impresion A1, Impresion A2, Impresion B) {
        impresoraA1 = A1;
        impresoraA2 = A2;
        impresoraB = B;
        disponibleA1 = true;
        disponibleA2 = true;
        disponibleB = true;
        resA1 = -1;
        resA2 = -1;
        resB = -1;
        impresaFalloA1 = false;
        impresaFalloA2 = false;
        impresaFalloB = false;
        this.mutexA = new Semaphore(1);
        this.mutexA2 = new Semaphore(1);
        this.mutexB = new Semaphore(1);

    }

    public int derivarImpresion(int docImprimir, char tipoDocumento) {

        if (tipoDocumento == 'A' || tipoDocumento == 'X') {
            //derivo a las impresoras A1,A2
            if (!this.impresaFalloA1) {

                this.resA1 = this.ingresarA1(docImprimir);
                if (this.resA1 == 1) {
                    this.impresaFalloA1 = true;
                    return resA1;

                } else {
                    if (this.resA1 == 2) {
                        System.out.println("Impresa A1 fallo, intenta en Impresora A2");
                        this.resA2 = this.ingresarA2(docImprimir);
                        return resA2;
                    } else {
                        // aca es resA1== 0 entonces imprimio y salio
                        System.out.println("salio todo bien debe ser 0 igual "+resA1);
                        return resA1;
                    }
                }

            }
            return 1;

        } else {

            //derivo a las impresoras B
            if (!this.impresaFalloB) {

                this.resB = this.ingresarB(docImprimir);
                if (this.resB == 1) {
                    this.impresaFalloB = true;
                    return resB;

                } else {
                    if (this.resB == 2) {
                        System.out.println("Impresa B fallo, intenta en Impresora B (la misma)");
                        this.resB = this.ingresarA2(docImprimir);
                        return resB;
                    } else {
                        // aca es resB== 0 entonces imprimio y salio
                        return resB;
                    }
                }

            }
            return 1;
        }

    }

    public int ingresarA1(int docImprimir) {

        // return 0 => se imprimio
        // return 1 => no hay impresora (no hay tinta, impresora rota)
        // return 2 => No hay disponibilidad (vuelve a intentarlo)
        if (disponibleA1) {

            this.disponibleA1 = false;
            if (impresoraA1.cupoDisponible() >= docImprimir) {
                try {
                    //aca semaforo
                    mutexA.acquire();
                } catch (InterruptedException ex) {
                    Logger.getLogger(GestorImpresoras.class.getName()).log(Level.SEVERE, null, ex);
                }
                impresoraA1.impresoraA(docImprimir);
                mutexA.release();
                return 0;
            } else {
                this.disponibleA1 = true;
                return 1;
            }
        }

        return 2;
    }

    public int ingresarA2(int docImprimir) {

        // return 0 => se imprimio
        // return 1 => no hay impresora (no hay tinta, impresora rota)
        // return 2 => No hay disponibilidad (vuelve a intentarlo)
        if (disponibleA2) {

            this.disponibleA2 = false;
            if (impresoraA2.cupoDisponible() >= docImprimir) {
                try {
                    //aca semaforo
                    mutexA2.acquire();
                } catch (InterruptedException ex) {
                    Logger.getLogger(GestorImpresoras.class.getName()).log(Level.SEVERE, null, ex);
                }
                impresoraA2.impresoraA(docImprimir);
                mutexA2.release();
                return 0;
            } else {
                this.disponibleA2 = true;
                return 1;
            }
        }

        return 2;
    }

    public int ingresarB(int docImprimir) {

        // return 0 => se imprimio
        // return 1 => no hay impresora (no hay tinta, impresora rota)
        // return 2 => No hay disponibilidad (vuelve a intentarlo)
        if (disponibleB) {

            this.disponibleB = false;
            if (impresoraB.cupoDisponible() >= docImprimir) {
                try {
                    //aca semaforo
                    mutexB.acquire();
                    impresoraB.impresoraA(docImprimir);
                    mutexB.release();
                    return 0;
                } catch (InterruptedException ex) {
                    Logger.getLogger(GestorImpresoras.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                this.disponibleB = true;
                return 1;
            }
        }

        return 2;
    }

    public void disponibilidadRestante() {
        System.out.println("Impresora A1 " + this.disponibleA1);
        System.out.println("Impresora A2 " + this.disponibleA2);
        System.out.println("Impresora b " + this.disponibleB);
    }

}
