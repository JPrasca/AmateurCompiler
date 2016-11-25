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
public class CConvertidor {
    private ArrayList<CToken> tokens;
    
    public CConvertidor(ArrayList<CToken> tokensIn){
        this.tokens = tokensIn;
    }
    
    public String Convertir (){
        String codigoCPP = "";
        
        for (CToken token : this.tokens) {
            
            switch(token.getTipo()){
                
                case "VALOR_FIN_LINEA":
                    codigoCPP += token.getToken();
                    break;
                case "VALOR_ESPACIO":
                    codigoCPP += token.getToken();
                    break;
                case "O_COMA":
                    codigoCPP += token.getToken();
                case "PR_PROGRAMA":
                    codigoCPP += (
                        "#include<conio.h>\n" +
                        "#include<iostream>\n" +
                        "#include<string.h\n\n>" +
                        "using namespace std;\n\n"
                    );
                    break;
                    
                case "PR_ENTERO":
                    codigoCPP += "int";
                    break;
                        
                case "PR_CADENA":
                    codigoCPP += "String";
                    break;
                case "PR_REAL":
                    codigoCPP += "float";
                    break;
                case "PR_BOOLEANO":
                    codigoCPP += "bool";
                    break;
                case "PR_INICIO":
                    codigoCPP += "int main(){\n";
                    break;
                case "PR_FIN":
                    codigoCPP += "}";
                    break;
                case "PR_LEER":
                    codigoCPP += "cin>>";
                    break;
                case "PR_ESCRIBIR":
                    codigoCPP += "cout<<";
                    break;
                case "PR_ABRE":
                    codigoCPP += "\\){";
                    break;
                case "PR_CIERRA":
                    codigoCPP += "}";
                    break;
                case "PR_SI":
                    codigoCPP+= "if\\(";
                    break;
                case "":
                    break;
            }
        }
        
        return codigoCPP;
    }
}
