/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amateurcompiler.logica.fuentes;

import jdk.nashorn.internal.runtime.regexp.joni.constants.CCVALTYPE;

/**
 *
 * @author jdpra
 */
public class CCadenas {
  
    public static final String PR_PROGRAMA = "programa";
    public static final String PR_VARIABLE = "variable";
    public static final String PR_ENTERO = "entero";
    public static final String PR_REAL = "real";
    public static final String PR_CADENA = "cadena";
    public static final String PR_BOOLEANO = "booleano";
    public static final String PR_INICIO = "inicio";
    public static final String PR_FIN = "fin";
    public static final String PR_LEER = "leer";
    public static final String PR_ESCRIBIR = "escribir";
    public static final String PR_SI = "si";
    public static final String PR_SINO = "sino";
    public static final String PR_FIN_SI = "finsi";
    public static final String PR_SEGUN = "segun";
    public static final String PR_DE_OTRO_MODO = "de otro modo";
    public static final String PR_FIN_SEGUN = "finsegun";
    public static final String PR_MIENTRAS = "mientras";
    public static final String PR_FIN_MIENTRAS = "finmientras";
    public static final String PR_HACER = "hacer";
    public static final String PR_MIENTRAS_QUE = "mientrasque";
    public static final String PR_PARA = "para";
    public static final String PR_HASTA = "hasta";
    public static final String PR_PASO = "paso";
    public static final String PR_FIN_PARA = "finpara";

    public static final String OR_MAYOR_QUE = ">";
    public static final String OR_MENOR_QUE = "<";
    public static final String OR_IGUAL_QUE = "==";
    public static final String OR_MENOR_O_IGUAL_QUE = "<=";
    public static final String OR_MAYOR_O_IGUAL_QUE = ">=";
    public static final String OR_DIFERENTE_DE = "!=";
    public static final String OR_TODOS = "(" + OR_IGUAL_QUE + "|" + OR_MAYOR_O_IGUAL_QUE + 
        "|" + OR_MAYOR_QUE + "|" + OR_MENOR_O_IGUAL_QUE  + "|" + OR_MENOR_QUE + "|" + OR_DIFERENTE_DE + ")";
    
    public static final String OL_Y = "y";
    public static final String OL_O = "o";
    public static final String OL_NO = "no";
    public static final String OL_TODOS = "([" + OL_Y + "]|[" + OL_O + "])";
    
    public static final String OA_SUMA = "[+]";
    public static final String OA_RESTA = "[-]";
    public static final String OA_PRODUCTO = "[*]";
    public static final String OA_DIVISION = "[/]";
    public static final String OA_MODULO = "[%]";
    public static final String OA_TODOS = "(" + OA_SUMA + "|" + OA_RESTA + "|" + OA_DIVISION + "|" + OA_MODULO + "|" + OA_PRODUCTO + ")";
    public static final String O_ASIGNACION = "[=]";
    
    //VALOR_BOOLEANO = ("verdadero"|"falso")
    public static final String ID_VAR = "(([A-Za-z0-9_])[\\w]*)";
    public static final String VALOR_ENTERO = "([-]?([0-9])+)|\\(([-]?([0-9])+)\\)";
    public static final String VALOR_REAL = "(" + VALOR_ENTERO + ")+[.](([0-9])+)|\\((" + VALOR_ENTERO + ")+[.](([0-9])+)\\)";
    //VALOR_BOOLEANO = [verdadero]|[falso]
    public static final String VALOR_CADENA = "([\"](([A-Za-z0-9])([\\w])*|[\\W])*[\"])";

    public static final String VALOR_ESPACIO = "[ \t]+";
    public static final String VALOR_FIN_LINEA = "([\n]|[\r]|[\r\n])";
    
    public static final String ASIGNACION = ID_VAR + VALOR_ESPACIO + O_ASIGNACION + VALOR_ESPACIO +
        "(" + ID_VAR + "|" + VALOR_REAL + "|" + VALOR_CADENA + "|" + VALOR_ENTERO + ")";
    
    public static final String EXPRESION_ALGEBRAICA_SIMPLE = (
        "((([-]?" + ID_VAR + "|" + VALOR_REAL + "|" + VALOR_ENTERO +
        "|" + VALOR_CADENA + ")(" + VALOR_ESPACIO + OA_TODOS + VALOR_ESPACIO +  "([-]?" + ID_VAR + "|" + VALOR_REAL + "|" + VALOR_ENTERO +
        "|" + VALOR_CADENA + "))*)|" + 
        "(\\(([-]?" + ID_VAR + "|" + VALOR_REAL + "|" + VALOR_ENTERO +
        "|" + VALOR_CADENA + ")(" + VALOR_ESPACIO + OA_TODOS + VALOR_ESPACIO +  "([-]?" + ID_VAR + "|" + VALOR_REAL + "|" + VALOR_ENTERO +
        "|" + VALOR_CADENA + "))*\\)))"
    );
    
    public static final String EXPRESIONES_ALGEBRAICAS = (
        "((" + EXPRESION_ALGEBRAICA_SIMPLE + ")" +
        "(" + VALOR_ESPACIO + OA_TODOS + VALOR_ESPACIO + "(" + EXPRESION_ALGEBRAICA_SIMPLE + "))*" +
        "|\\(((" + EXPRESION_ALGEBRAICA_SIMPLE + "))" +
        "(" + VALOR_ESPACIO + OA_TODOS + VALOR_ESPACIO + "(" + EXPRESION_ALGEBRAICA_SIMPLE + "))*\\))"
    );
    
    public static final String EXPRESION_COMPARACION = (
        "(" + EXPRESIONES_ALGEBRAICAS + "(" + VALOR_ESPACIO + OR_TODOS + VALOR_ESPACIO + EXPRESIONES_ALGEBRAICAS + ")*" +
        "|(\\" + EXPRESIONES_ALGEBRAICAS + "(" + VALOR_ESPACIO + OR_TODOS + VALOR_ESPACIO + EXPRESIONES_ALGEBRAICAS + ")*\\))"
    );
    
    public static final String EXPRESION_LOGICA = (
        "(" + EXPRESION_COMPARACION + "(" + VALOR_ESPACIO + OL_TODOS + VALOR_ESPACIO + "(" + EXPRESION_COMPARACION + "))*" +
        "|"+
        "(\\(" + EXPRESION_COMPARACION + "(" + VALOR_ESPACIO + OL_TODOS + VALOR_ESPACIO + "(" + EXPRESION_COMPARACION + "))*\\)))"
    );
    
    public static final String EXPRESION_ASIGNACION = (
        "(" + VALOR_ESPACIO + ")*" + ID_VAR + VALOR_ESPACIO + O_ASIGNACION + VALOR_ESPACIO + EXPRESIONES_ALGEBRAICAS  + "(" + VALOR_ESPACIO + ")*"
    );
    
    public static final String EXPRESION_ABRE_SI = (
        "(" + VALOR_ESPACIO + ")*" + PR_SI + VALOR_ESPACIO + EXPRESION_LOGICA  + "(" + VALOR_ESPACIO + ")*"
    );
    
    public static final String EXPRESION_CIERRE_SI = (
        "(" + VALOR_ESPACIO + ")*" + PR_FIN_SI  + "(" + VALOR_ESPACIO + ")*"
    );
    
    public static final String EXPRESION_ABRE_SINO = (
        "(" + VALOR_ESPACIO + ")*" + PR_SINO  + "(" + VALOR_ESPACIO + ")*"
    );
    
    public static final String EXPRESION_ABRE_HACER_MIENTRAS = (
        "(" + VALOR_ESPACIO + ")*" + PR_HACER + "(" + VALOR_ESPACIO + ")*"
    );
    
    public static final String EXPRESION_CIERRA_HACER_MIENTRAS = (
        "(" + VALOR_ESPACIO + ")*" + PR_MIENTRAS_QUE + VALOR_ESPACIO + EXPRESION_LOGICA  + "(" + VALOR_ESPACIO + ")*"        
    );
    
    public static final String EXPRESION_ABRE_MIENTRAS = (
        "(" + VALOR_ESPACIO + ")*" + PR_MIENTRAS + VALOR_ESPACIO + EXPRESION_LOGICA  + "(" + VALOR_ESPACIO + ")*"  
    );
    
    public static final String EXPRESION_CIERRA_MIENTRAS = (
        "(" + VALOR_ESPACIO + ")*" + PR_FIN_MIENTRAS  + "(" + VALOR_ESPACIO + ")*"
    );
    
    public static final String EXPRESION_ABRE_PARA = (
        "((" + VALOR_ESPACIO + ")*" + PR_PARA + VALOR_ESPACIO + EXPRESION_ASIGNACION + VALOR_ESPACIO +
        PR_HASTA + VALOR_ESPACIO + EXPRESION_ALGEBRAICA_SIMPLE + VALOR_ESPACIO + PR_PASO + VALOR_ESPACIO + VALOR_ENTERO + "(" + VALOR_ESPACIO + ")*)" 
    );
    
    public static final String EXPRESION_CIERRE_PARA = (
        "(" + VALOR_ESPACIO + ")*" + PR_FIN_PARA  + "(" + VALOR_ESPACIO + ")*"
    );
    
    public static final String EXPRESION_ABRE_SEGUN = (
        "(" + VALOR_ESPACIO + ")*" + PR_SEGUN + "(" + VALOR_ESPACIO + ")*" + ID_VAR + "(" + VALOR_ESPACIO + ")*"
    );
}