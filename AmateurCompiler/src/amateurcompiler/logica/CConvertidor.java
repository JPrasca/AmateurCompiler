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
                        "#include<string.h>\n\n" +
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
                    codigoCPP += "){";
                    break;
                case "PR_CIERRA":
                    codigoCPP += "}";
                    break;
                case "PR_SI":
                    codigoCPP+= "if(";
                    break;
                case "PR_SINO":
                    codigoCPP+= "}else{";
                    break;
                case "PR_SEGUN":
                    codigoCPP+="switch(";
                    break;
                case "PR_DE_OTRO_MODO":
                    codigoCPP+="default";
                    break;
                case "PR_MIENTRAS":
                    codigoCPP+="while(";
                    break;
                case "PR_HACER":
                    codigoCPP+="(do";
                    break;
                case "PR_MIENTRAS_QUE":
                    codigoCPP+="while(";
                    break;
                case "PR_PARA":
                    codigoCPP+="for(";
                    break;
                case "PR_HASTA":
                    codigoCPP+="";
                    break;
                case "PR_PASO":
                    codigoCPP+="";
                    break;
                case "OR_MAYOR_QUE":
                    codigoCPP+=">";
                    break;
                case "OR_MENOR_QUE":
                    codigoCPP+="<";
                    break;
                case "OR_IGUAL_QUE":
                    codigoCPP+="==";
                    break;
                case "OR_MENOR_O_IGUAL_QUE":
                    codigoCPP+="<=";
                    break;
                case "OR_MAYOR_O_IGUAL_QUE":
                    codigoCPP+=">=";
                    break;
                case "OR_DIFERENTE_DE":
                    codigoCPP+="!=";
                    break;
                case "OL_Y":
                    codigoCPP+="&&";
                    break;
                case "OL_O":
                    codigoCPP+="||";
                    break;
                case "OL_NO":
                    codigoCPP+="!";
                    break;
                case "OA_SUMA":
                    codigoCPP+="+";
                    break;
                case "OA_RESTA":
                    codigoCPP+="-";
                    break;
                case "OA_PRODUCTO":
                    codigoCPP+="*";
                    break;
                case "OA_DIVISION":
                    codigoCPP+="/";
                    break;
                case "OA_MODULO":
                    codigoCPP+="%";
                    break;
                case "O_ASIGNACION":
                    codigoCPP+="=";
                    break;
                case "O_DOS_PUNTOS":
                    codigoCPP+=":";
                    break;
                case "O_PAREN_ABRE":
                    codigoCPP+="(";
                    break;
                case "O_PAREN_CIERRA":
                    codigoCPP+=")";
                    break;
                case "O_CORCHETE_ABRE":
                    codigoCPP+="[";
                    break;
                case "O_CORCHETE_CIERRA":
                    codigoCPP+="]";
                    break;
                case "ID_VAR":
                    codigoCPP+=token.getToken();
                    break;
                case "VALOR_ENTERO":
                    codigoCPP+=token.getToken();
                    break;
                case "VALOR_REAL":
                    codigoCPP+=token.getToken();
                    break;
                case "VALOR_CADENA":
                    codigoCPP+=token.getToken();
                    break;
                case "EXPRESION_COMENTARIOS":
                    codigoCPP+="/*"+ token.getToken() + "*/";
                    break;
                    
            }
        }
        
        return codigoCPP;
    }
}
