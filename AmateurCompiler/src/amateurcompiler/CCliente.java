/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amateurcompiler;

import amateurcompiler.vista.FPrincipal;


/**
 *
 * @author jdpra
 */
public class CCliente {

    /**
     * @param args the command line arguments
     */
    public static String path = "";
    
    public static void main(String[] args) {
        // TODO code application logic here
           
//        System.out.println("cad  =  \"valor\"".matches(amateurcompiler.logica.fuentes.CCadenas.ASIGNACION));
//        System.out.println("c = valor".matches(amateurcompiler.logica.fuentes.CCadenas.ASIGNACION));
//        System.out.println("cad = 1".matches(amateurcompiler.logica.fuentes.CCadenas.ASIGNACION));
        System.out.println("entero vad,a , s2".matches(amateurcompiler.logica.fuentes.CCadenas.EXPRESION_DECLARACION));
        System.out.println(amateurcompiler.logica.fuentes.CCadenas.EXPRESION_DECLARACION);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FPrincipal().setVisible(true);
            }
        });
        
    }
    
    
}
