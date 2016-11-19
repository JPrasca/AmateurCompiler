/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amateurcompiler.logica;

import java.util.ArrayList;

/**
 *
 * @author jdpra
 */
public class CDisqueSyntactico {
    
    private ArrayList<CToken> tokens;
    int auxLinea = 0;
    public CDisqueSyntactico(){
        this.tokens = new ArrayList<>();
    } 
    
    public CDisqueSyntactico(ArrayList<CToken> tokensIn){
        this.tokens = tokensIn;
    }
    
    
    public boolean recorridoAbreCierra() {
        
        return false;
    }
}
