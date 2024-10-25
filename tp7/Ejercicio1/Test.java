/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp7.Ejercicio1;
public class Test {

    public static void main(String[] args) {

        Puente puente = new Puente();
        CocheNorte[] cn = new CocheNorte[10];
        CocheSur[] sr = new CocheSur[25];

        for (int i = 0; i < cn.length; i++) {
            cn[i] = new CocheNorte(puente);

        }
        for (int i = 0; i < sr.length; i++) {
            sr[i] = new CocheSur(puente);
        }

        for (int i = 0; i < cn.length; i++) {
            cn[i].start();
        }
        for (int i = 0; i < sr.length; i++) {
            sr[i].start();
        }
        
        
    }
