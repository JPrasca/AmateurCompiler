/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amateurcompiler.logica.fuentes;

import javax.swing.JOptionPane;
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
    public static final String PR_ABRE = "abre";
    public static final String PR_CIERRA = "cierra";
    public static final String PR_SI = "si";
    public static final String PR_SINO = "sino";
    //public static final String PR_FIN_SI = "finsi";
    public static final String PR_SEGUN = "segun";
    public static final String PR_DE_OTRO_MODO = "deotromodo";
    //public static final String PR_FIN_SEGUN = "finsegun";
    public static final String PR_MIENTRAS = "(mientras)";
    //public static final String PR_FIN_MIENTRAS = "finmientras";
    public static final String PR_HACER = "hacer";
    public static final String PR_MIENTRAS_QUE = "mientrasque";
    public static final String PR_PARA = "para";
    public static final String PR_HASTA = "hasta";
    public static final String PR_PASO = "paso";
    //public static final String PR_FIN_PARA = "finpara";

    public static final String OR_MAYOR_QUE = ">";
    public static final String OR_MENOR_QUE = "<";
    public static final String OR_IGUAL_QUE = "==";
    public static final String OR_MENOR_O_IGUAL_QUE = "<=";
    public static final String OR_MAYOR_O_IGUAL_QUE = ">=";
    public static final String OR_DIFERENTE_DE = "!=";
    public static final String OR_TODOS = "(" + OR_IGUAL_QUE + "|" + OR_MAYOR_O_IGUAL_QUE
            + "|" + OR_MAYOR_QUE + "|" + OR_MENOR_O_IGUAL_QUE + "|" + OR_MENOR_QUE + "|" + OR_DIFERENTE_DE + ")";

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
    public static final String O_DOS_PUNTOS = ":";
    public static final String O_PAREN_ABRE = "\\(";
    public static final String O_PAREN_CIERRA = "\\)";
    public static final String O_CORCHETE_ABRE = "\\[";
    public static final String O_CORCHETE_CIERRA = "\\]";
    public static final String O_COMA = ",";

    //VALOR_BOOLEANO = ("verdadero"|"falso")
    public static final String ID_VAR = "(([A-Za-z]+)(_)*[0-9]*)";
    public static final String VALOR_ENTERO = "([-]?([0-9])+)|\\(([-]?([0-9])+)\\)";
    public static final String VALOR_REAL = "(" + VALOR_ENTERO + ")+[.](([0-9])+)|\\((" + VALOR_ENTERO + ")+[.](([0-9])+)\\)";
    //VALOR_BOOLEANO = [verdadero]|[falso]
    public static final String VALOR_CADENA = "([\"](([A-Za-z0-9 ])([\\w])*)*[\"])";

    public static final String VALOR_ESPACIO = "[ \t]+";
    public static final String VALOR_FIN_LINEA = "([\n]|[\r]|[\r\n])";

    public static final String EXPRESION_COMENTARIOS = "([#])(([A-Za-z0-9])([\\w])*|[\\W])*([#])";
    public static final String EXPRESION_LEER = "((" + VALOR_ESPACIO + ")*" + PR_LEER + "(" + VALOR_ESPACIO + ")+"
            + ID_VAR + "(" + VALOR_ESPACIO + ")*)";
    public static final String EXPRESION_ESCRIBIR = "((" + VALOR_ESPACIO + ")*" + PR_ESCRIBIR + "(" + VALOR_ESPACIO + ")+"
            + "((" + VALOR_CADENA + "|" + ID_VAR + ")(" + VALOR_ESPACIO + OA_SUMA + VALOR_ESPACIO + ID_VAR + ")*)" + "(" + VALOR_ESPACIO + ")*" + ")";
    public static final String ASIGNACION = "((" + VALOR_ESPACIO + ")*" + ID_VAR + VALOR_ESPACIO + O_ASIGNACION + VALOR_ESPACIO
            + "(" + ID_VAR + "|" + VALOR_REAL + "|" + VALOR_CADENA + "|" + VALOR_ENTERO + "))";

    public static final String EXPRESION_ABRE_DECLARIONES = "((" + VALOR_ESPACIO + ")*" + PR_VARIABLE + "(" + VALOR_ESPACIO + ")*)";
    public static final String EXPRESION_ABRE_PROGRAMA = "((" + VALOR_ESPACIO + ")*" + PR_PROGRAMA + "(" + VALOR_ESPACIO + ")*)";
    public static final String EXPRESION_INICIO = "((" + VALOR_ESPACIO + ")*" + PR_INICIO + "(" + VALOR_ESPACIO + ")*)";
    public static final String EXPRESION_FIN = "((" + VALOR_ESPACIO + ")*" + PR_FIN + "(" + VALOR_ESPACIO + ")*)";

    public static final String EXPRESION_DECLARACION = ("((" + PR_BOOLEANO + "|" + PR_CADENA + "|" + PR_ENTERO + "|" + PR_REAL + ")" + VALOR_ESPACIO + ID_VAR
             + "(" + VALOR_ESPACIO + ")*)");

    public static final String EXPRESION_ALGEBRAICA_SIMPLE = ("((([-]?" + ID_VAR + "|" + VALOR_REAL + "|" + VALOR_ENTERO
            + "|" + VALOR_CADENA + ")(" + VALOR_ESPACIO + OA_TODOS + VALOR_ESPACIO + "([-]?" + ID_VAR + "|" + VALOR_REAL + "|" + VALOR_ENTERO
            + "|" + VALOR_CADENA + "))*)|"
            + "(\\(([-]?" + ID_VAR + "|" + VALOR_REAL + "|" + VALOR_ENTERO
            + "|" + VALOR_CADENA + ")(" + VALOR_ESPACIO + OA_TODOS + VALOR_ESPACIO + "([-]?" + ID_VAR + "|" + VALOR_REAL + "|" + VALOR_ENTERO
            + "|" + VALOR_CADENA + "))*\\)))");

    public static final String EXPRESIONES_ALGEBRAICAS = ("((" + EXPRESION_ALGEBRAICA_SIMPLE + ")"
            + "(" + VALOR_ESPACIO + OA_TODOS + VALOR_ESPACIO + "(" + EXPRESION_ALGEBRAICA_SIMPLE + "))*"
            + "|\\(((" + EXPRESION_ALGEBRAICA_SIMPLE + "))"
            + "(" + VALOR_ESPACIO + OA_TODOS + VALOR_ESPACIO + "(" + EXPRESION_ALGEBRAICA_SIMPLE + "))*\\))");

    public static final String EXPRESION_COMPARACION = ("(" + EXPRESIONES_ALGEBRAICAS + "(" + VALOR_ESPACIO + OR_TODOS + VALOR_ESPACIO + EXPRESIONES_ALGEBRAICAS + ")*"
            + "|(\\" + EXPRESIONES_ALGEBRAICAS + "(" + VALOR_ESPACIO + OR_TODOS + VALOR_ESPACIO + EXPRESIONES_ALGEBRAICAS + ")*\\))");

    public static final String EXPRESION_LOGICA = ("(" + EXPRESION_COMPARACION + "(" + VALOR_ESPACIO + OL_TODOS + VALOR_ESPACIO + "(" + EXPRESION_COMPARACION + "))*"
            + "|"
            + "(\\(" + EXPRESION_COMPARACION + "(" + VALOR_ESPACIO + OL_TODOS + VALOR_ESPACIO + "(" + EXPRESION_COMPARACION + "))*\\)))");

    public static final String EXPRESION_ASIGNACION = ("((" + VALOR_ESPACIO + ")*" + ID_VAR + VALOR_ESPACIO + O_ASIGNACION + VALOR_ESPACIO + EXPRESIONES_ALGEBRAICAS + "(" + VALOR_ESPACIO + ")*)");

    public static final String EXPRESION_ABRE_SI = ("(" + VALOR_ESPACIO + ")*" + PR_SI + VALOR_ESPACIO + EXPRESION_LOGICA + "(" + VALOR_ESPACIO + ")+" + PR_ABRE + "(" + VALOR_ESPACIO + ")*");

    public static final String EXPRESION_CIERRE = ("((" + VALOR_ESPACIO + ")*" + PR_CIERRA + "(" + VALOR_ESPACIO + ")*)");

    public static final String EXPRESION_CIERRE_SI = ("(" + VALOR_ESPACIO + ")*" + PR_CIERRA + "(" + VALOR_ESPACIO + ")*");

    public static final String EXPRESION_ABRE_SINO = ("(" + VALOR_ESPACIO + ")*" + PR_SINO + "(" + VALOR_ESPACIO + ")*");

    public static final String EXPRESION_ABRE_HACER_MIENTRAS = ("(" + VALOR_ESPACIO + ")*" + PR_HACER + "(" + VALOR_ESPACIO + ")*" + PR_ABRE + "(" + VALOR_ESPACIO + ")*");

    public static final String EXPRESION_CIERRA_HACER_MIENTRAS = ("(" + VALOR_ESPACIO + ")*" + PR_CIERRA + "(" + VALOR_ESPACIO + ")*" + PR_MIENTRAS_QUE + VALOR_ESPACIO + EXPRESION_LOGICA + "(" + VALOR_ESPACIO + ")*");

    public static final String EXPRESION_ABRE_MIENTRAS = ("((" + VALOR_ESPACIO + ")*" + PR_MIENTRAS + VALOR_ESPACIO + "(" + EXPRESION_LOGICA + ")" + "(" + VALOR_ESPACIO + ")+" + PR_ABRE + "(" + VALOR_ESPACIO + ")*)");

    public static final String EXPRESION_CIERRA_MIENTRAS = ("(" + VALOR_ESPACIO + ")*" + PR_CIERRA + "(" + VALOR_ESPACIO + ")*");

    public static final String EXPRESION_ABRE_PARA = (
            "((" + VALOR_ESPACIO + ")*" + PR_PARA + VALOR_ESPACIO  + EXPRESION_ASIGNACION  + VALOR_ESPACIO
            + PR_HASTA + VALOR_ESPACIO + "(" + VALOR_ENTERO + ")" + VALOR_ESPACIO + PR_PASO + VALOR_ESPACIO + VALOR_ENTERO + "(" + VALOR_ESPACIO + ")+" + PR_ABRE + "(" + VALOR_ESPACIO + ")*)"
    );
 
    public static final String EXPRESION_CIERRE_PARA = ("(" + VALOR_ESPACIO + ")*" + PR_CIERRA + "(" + VALOR_ESPACIO + ")*");

    public static final String EXPRESION_ABRE_SEGUN = ("(" + VALOR_ESPACIO + ")*" + PR_SEGUN + "(" + VALOR_ESPACIO + ")*" + ID_VAR + "(" + VALOR_ESPACIO + ")*" + PR_ABRE + "(" + VALOR_ESPACIO + ")*");

    public static final String EXPRESION_ABRE_OPCION = ("(" + VALOR_ESPACIO + ")*" + "([-]?" + ID_VAR + "|" + VALOR_REAL + "|" + VALOR_ENTERO
            + "|" + VALOR_CADENA + ")" + VALOR_ESPACIO + O_DOS_PUNTOS + "(" + VALOR_ESPACIO + ")*");

    public static final String EXPRESION_ABRE_SEGUN_DE_OTRO_MODO = ("((" + VALOR_ESPACIO + ")*" + PR_DE_OTRO_MODO + VALOR_ESPACIO + O_DOS_PUNTOS + "(" + VALOR_ESPACIO + ")*)");

    public static final String EXPRESION_CIERRE_SEGUN = ("(" + VALOR_ESPACIO + ")*" + PR_CIERRA + "(" + VALOR_ESPACIO + ")*");

    public static boolean evaluarCadena(String cadenaIn) {
         
        System.out.println("Evaluando cadena: " + cadenaIn);
        if (cadenaIn.matches(EXPRESION_ASIGNACION)) {
            System.out.println("Asignacion");
            return true;
        }
        if (cadenaIn.matches(EXPRESION_ESCRIBIR)) {

            System.out.println("Ecribir");
            return true;
        }
        if (cadenaIn.matches(EXPRESION_LEER)) {
            System.out.println("leer");
            return true;
        }
        if (cadenaIn.matches(EXPRESION_ABRE_PROGRAMA)) {
            System.out.println("abrir programa");
            return true;
        }
        if (cadenaIn.matches(EXPRESION_DECLARACION)) {
            System.out.println("variable");
            return true;
        }
        if (cadenaIn.matches(EXPRESION_ABRE_DECLARIONES)){
            System.out.println("declaraciones");
            return true;
        }
        if (cadenaIn.matches(EXPRESION_INICIO)) {
            System.out.println("inicio");
            return true;
        }
        if (cadenaIn.matches(EXPRESION_FIN)) {
            System.out.println("final");
            return true;
        }
        if (cadenaIn.matches(EXPRESION_ASIGNACION)) {
            System.out.println("Asignacion");

            return true;
        }
        if (cadenaIn.matches(EXPRESION_ABRE_HACER_MIENTRAS)) {
            System.out.println("abre do while");
            return true;
        }
        if (cadenaIn.matches(EXPRESION_ABRE_MIENTRAS)) {
            System.out.println("abre while");
            return true;
        }
        if (cadenaIn.matches(EXPRESION_ABRE_OPCION)) {
            System.out.println("abrir opc");
            return true;
        }
        if (cadenaIn.matches(EXPRESION_ABRE_PARA)) {
            System.out.println("abrir for");
            return true;
        }
        if (cadenaIn.matches(EXPRESION_ABRE_SEGUN)) {
            System.out.println("abrir segun");
            return true;
        }
        if (cadenaIn.matches(EXPRESION_ABRE_SEGUN_DE_OTRO_MODO)) {
            System.out.println("abrir deotromodo");
            return true;
        }
        if (cadenaIn.matches(EXPRESION_ABRE_SI)) {
            System.out.println("abrir si");
            return true;
        }
        if (cadenaIn.matches(EXPRESION_ABRE_SINO)) {
            System.out.println("abrir sino");
            return true;
        }
        if (cadenaIn.matches(EXPRESION_CIERRA_HACER_MIENTRAS)) {
            System.out.println("cierre do while");
            return true;
        }
        if (cadenaIn.matches(EXPRESION_CIERRA_MIENTRAS) || cadenaIn.matches(EXPRESION_CIERRE_PARA)
                || cadenaIn.matches(EXPRESION_CIERRE_SEGUN) || cadenaIn.matches(EXPRESION_CIERRE_SI)) {
            System.out.println("cierre");
            return true;
        }
        if (cadenaIn.matches(EXPRESION_COMENTARIOS)) {
            System.out.println("comentarios");
            return true;
        }
        if(cadenaIn.matches(VALOR_ESPACIO) || cadenaIn.matches(VALOR_FIN_LINEA)) {
            return true;
        }
        if(cadenaIn.isEmpty()){
            return true;
        }
 
        return false;

    }
}
