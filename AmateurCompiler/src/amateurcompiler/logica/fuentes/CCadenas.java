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
    public static final String OL_Y = "y";
    public static final String OL_O = "o";
    public static final String OL_NO = "no";
    public static final String OA_SUMA = "[+]";
    public static final String OA_RESTA = "[-]";
    public static final String OA_PRODUCTO = "[*]";
    public static final String OA_DIVISION = "[/]";
    public static final String OA_MODULO = "[%]";
    public static final String OA_TODOS = "(" + OA_SUMA + "|" + OA_RESTA + "|" + OA_DIVISION + "|" + OA_MODULO + "|" + OA_PRODUCTO + ")";
    public static final String O_ASIGNACION = "[=]";
    //VALOR_BOOLEANO = ("verdadero"|"falso")
    public static final String ID_VAR = "([A-Za-z0-9_])([\\w])*";
    public static final String VALOR_ENTERO = "([-]?([0-9])+)";
    public static final String VALOR_REAL = "((" + VALOR_ENTERO + ")+[.](([0-9])+)";
    //VALOR_BOOLEANO = [verdadero]|[falso]
    public static final String VALOR_CADENA = "([\"](([A-Za-z0-9])([\\w])*|[\\W])*[\"])";

    public static final String VALOR_ESPACIO = "[ \t]+";
    public static final String VALOR_FIN_LINEA = "([\n]|[\r]|[\r\n])";
    
    public static final String ASIGNACION = ID_VAR + VALOR_ESPACIO + O_ASIGNACION + VALOR_ESPACIO +
        "(" + ID_VAR + "|" + VALOR_REAL + "|" + VALOR_CADENA + "|" + VALOR_ENTERO + ")";
    
    public static final String EXPRESION_ALGEBRAICA_SIMPLE = "(" + ID_VAR + "|" + VALOR_REAL + "|" + VALOR_ENTERO +
        "|" + VALOR_CADENA + ")" + OA_TODOS + "(" + ID_VAR + "|" + VALOR_REAL + "|" + VALOR_ENTERO +
        "|" + VALOR_CADENA + ")";
    //public static final String EXPRESIONES_ALGEBRAICAS = EXPRESION_ALGEBRAICA_SIMPLE + ;
    
}