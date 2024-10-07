package tp4.Ejercicio5;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorImpresoras {

    Impresion impresoraA1, impresoraA2, impresoraB;
    Semaphore mutexA1, mutexA2, mutexB;

    public GestorImpresoras(Impresion A1, Impresion A2, Impresion B) {
        impresoraA1 = A1;
        impresoraA2 = A2;
        impresoraB = B;
        this.mutexA1 = new Semaphore(1); // Semáforo para impresora A1
        this.mutexA2 = new Semaphore(1); // Semáforo para impresora A2
        this.mutexB = new Semaphore(1);  // Semáforo para impresora B
    }

    public int derivarImpresion(int docImprimir, String tipoDocumento, int id) {
        int resultado = -1;

        if (tipoDocumento.equalsIgnoreCase("A") || tipoDocumento.equalsIgnoreCase("X")) {
            resultado = intentarImpresionA(docImprimir, tipoDocumento, id);

        } else {
            resultado = intentarImpresionB(docImprimir, tipoDocumento, id);
        }

        return resultado;
    }

    private int intentarImpresionA(int docImprimir, String tipoDocumento, int id) {
        int resultado = ingresarA1(docImprimir, tipoDocumento, id);
        if (resultado == 2) {  // Si no hay disponibilidad en A1, intenta en A2
            resultado = ingresarA2(docImprimir, tipoDocumento, id);
        }
        return resultado;
    }

    private int intentarImpresionB(int docImprimir, String tipoDocumento, int id) {
        return ingresarB(docImprimir, tipoDocumento, id);
    }

    private int ingresarA1(int docImprimir, String tipoDocumento, int id) {
        try {
            if (mutexA1.tryAcquire()) {
                if (impresoraA1.cupoDisponible() >= docImprimir) {
                    impresoraA1.impresora(docImprimir, tipoDocumento, id);
                    return 0;
                } else {
                    return 1; // Error: no hay tinta suficiente
                }
            } else {
                return 2; // Impresora ocupada
            }
        } finally {
            mutexA1.release(); // Asegura la liberación del semáforo
        }
    }

    private int ingresarA2(int docImprimir, String tipoDocumento, int id) {
        try {
            if (mutexA2.tryAcquire()) {
                if (impresoraA2.cupoDisponible() >= docImprimir) {
                    impresoraA2.impresora(docImprimir, tipoDocumento, id);
                    return 0;
                } else {
                    return 1; // Error: no hay tinta suficiente
                }
            } else {
                return 2; // Impresora ocupada
            }
        } finally {
            mutexA2.release();
        }
    }

    private int ingresarB(int docImprimir, String tipoDocumento, int id) {
        try {
            if (mutexB.tryAcquire()) {
                if (impresoraB.cupoDisponible() >= docImprimir) {
                    impresoraB.impresora(docImprimir, tipoDocumento, id);
                    return 0;
                } else {
                    return 1; // Error: no hay tinta suficiente
                }
            } else {
                return 2; // Impresora ocupada
            }
        } finally {
            mutexB.release();
        }
    }

    public void disponibilidadRestante() {
        System.out.println("Impresora A1 disponible: " + impresoraA1.cupoDisponible());
        System.out.println("Impresora A2 disponible: " + impresoraA2.cupoDisponible());
        System.out.println("Impresora B disponible: " + impresoraB.cupoDisponible());
    }
}
