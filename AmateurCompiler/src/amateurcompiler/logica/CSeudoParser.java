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
public class CSeudoParser {
    
    private ArrayList<CToken> tokens;
    int auxLinea = 0;
    public CSeudoParser(){
        this.tokens = new ArrayList<>();
    } 
    
    public CSeudoParser(ArrayList<CToken> tokensIn){
        this.tokens = tokensIn;
    }
    
    
    public boolean recorridoAbreCierra() {
        
        return false;
    }
}
