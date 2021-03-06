
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amateurcompiler.logica;

/**
 *
 * @author jdpra
 */
public class CToken {

    
    //atributos de la clase
    private int numToken;
    private String token;
    private String tipo;
    private int linea;
    private int columna;
    
    
    CToken (int numToken, String token, String tipo, int linea, int columna){
        //Contador para el número de tokens reconocidos
        this.numToken = numToken;
        //String del token reconocido
        this.token = token;
        //Tipo de componente léxico encontrado
        this.tipo = tipo;
        //Número de linea
        this.linea = linea + 1;
        //Columna donde empieza el primer carácter del token
        this.columna = columna + 1;
        
    }
    
    //Metodo que devuelve los datos necesarios que escribiremos en un archive de salida
    public String toString() {
        return "TOKEN #" +numToken + ": " + token + " LEXEMA: " + tipo + " POS: [" + linea + "," + columna + "]\n";
    }

    public int getNumToken() {
        return numToken;
    }

    public String getToken() {
        return token;
    }

    public String getTipo() {
        return tipo;
    }

    public int getLinea() {
        return linea;
    }

    public int getColumna() {
        return columna;
    }

   
}
