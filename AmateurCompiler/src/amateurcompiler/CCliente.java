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
        System.out.println("(-x)".matches(amateurcompiler.logica.fuentes.CCadenas.EXPRESIONES_ALGEBRAICAS));
        System.out.println(amateurcompiler.logica.fuentes.CCadenas.EXPRESIONES_ALGEBRAICAS);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new FPrincipal().setVisible(true);
            }
        });
    }
    
    
}
