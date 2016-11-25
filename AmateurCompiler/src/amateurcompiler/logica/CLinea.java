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
public class CLinea {
    ArrayList<CToken> tokens;
    int index;
    
    public CLinea(int indexIn, ArrayList<CToken> tokensIn){
        index = indexIn;
        this.tokens = tokensIn;
    }
    
    public CLinea(){
        tokens = new ArrayList<>();
        index = 0;
    }
    
    public String getLineaString() {
        String l = "";
        for(int i = 0; i < tokens.size(); i ++) {
            l += tokens.get(i).getToken();
        }
        return l;
    }
}
