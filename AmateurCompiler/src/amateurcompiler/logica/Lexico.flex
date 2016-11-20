/*Seccion de codigo de usuario*/
package amateurcompiler.logica;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//clase de los token devueltos
/* Seccion de opciones y declaraciones de JFlex */
%% //inicio de opciones
//Cambiamos el nombre la funcion para el siguiente token por nextToken
%function nextToken
//Clase publica
%public //Cambiamos el nombre de la clase del analizador


%class CScaneador //Agregamos soporte a unicode

%unicode
//Codigo java
%{
	
    private int contador;
    private ArrayList<CToken> tokens;

	private void writeOutputFile() throws IOException{
			String filename = "file.out";
			BufferedWriter out = new BufferedWriter(
				new FileWriter(filename));
            System.out.println("\n*** Tokens guardados en archivo ***\n");
			for(CToken t: this.tokens){
				System.out.println(t);
				out.write(t + "\n");
			}
			out.close();
	}
%}
//Creamos un contador para los tokens
%init{
    contador = 0;
	tokens = new ArrayList<CToken>();
%init}
//Cuando se alcanza el fin del archivo de entrada
%eof{
	try{
		this.writeOutputFile();
        
	}catch(IOException ioe){
		ioe.printStackTrace();
	}
%eof}
//Activar el contador de lineas, variable yyline
%line
//Activar el contador de columna, variable yycolumn
%column
//Fin de opciones

//Expresiones regulares
//Declaraciones

PR_PROGRAMA = "programa"
PR_VARIABLE = "variable"
PR_ENTERO = "entero"
PR_REAL = "real"
PR_CADENA = "cadena"
PR_BOOLEANO = "booleano"
PR_INICIO = "inicio"
PR_FIN = "fin"
PR_LEER = "leer"
PR_ESCRIBIR = "escribir"
PR_SI = "si"
PR_SINO = "sino"
PR_FIN_SI = "finsi"
PR_SEGUN = "segun"
PR_DE_OTRO_MODO = "deotromodo"
PR_FIN_SEGUN = "finsegun"
PR_MIENTRAS = "mientras"
PR_FIN_MIENTRAS = "finmientras"
PR_HACER = "hacer"
PR_MIENTRAS_QUE = "mientrasque"
PR_PARA = "para"
PR_HASTA = "hasta"
PR_PASO = "paso"
PR_FIN_PARA = "finpara"

OR_MAYOR_QUE = ">"
OR_MENOR_QUE = "<"
OR_IGUAL_QUE = "=="
OR_MENOR_O_IGUAL_QUE = "<="
OR_MAYOR_O_IGUAL_QUE = ">="
OL_Y = "y"
OL_O = "o"
OL_NO = "no"
OA_SUMA = "+"
OA_RESTA = "-"
OA_PRODUCTO = "*"
OA_DIVISION = "/"
OA_MODULO = "%"
O_ASIGNACION = "="
O_DOS_PUNTOS = ":"
O_PAREN_ABRE = "("
O_PAREN_CIERRA = ")"
O_CORCHETE_ABRE = "["
O_CORCHETE_CIERRA = "]"
O_COMA = ","

VALOR_BOOLEANO = ("verdadero"|"falso")
ID_VAR = ([A-Za-z0-9])([\w])*
VALOR_ENTERO = [-]?([0-9])+
VALOR_REAL = [-]?({VALOR_ENTERO})+[.]({VALOR_ENTERO})+
//VALOR_BOOLEANO = [verdadero]|[falso]
VALOR_CADENA = [\"](([A-Za-z0-9])([\w])*|[\W])*[\"]

VALOR_ESPACIO = [ \t]
VALOR_FIN_LINEA = ([\n]|[\r]|[\r\n])

//fin declaraciones

/* Seccion de reglas lexicas */
%% 
//Regla     {Acciones}


{PR_PROGRAMA} {
	contador++;
    CToken t = new CToken(contador,yytext(),"PR_PROGRAMA",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{PR_VARIABLE} {
	contador++;
    CToken t = new CToken(contador,yytext(),"PR_VARIABLE",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{PR_ENTERO} {
	contador++;
    CToken t = new CToken(contador,yytext(),"PR_ENTERO",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{PR_REAL} {
	contador++;
    CToken t = new CToken(contador,yytext(),"PR_REAL",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{PR_CADENA} {
	contador++;
    CToken t = new CToken(contador,yytext(),"PR_CADENA", yyline, yycolumn);
    tokens.add(t);
    return t;
}

{PR_BOOLEANO} {
	contador++;
    CToken t = new CToken(contador,yytext(),"PR_BOOLEANO",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{PR_INICIO} {
	contador++;
    CToken t = new CToken(contador,yytext(),"PR_INICIO",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{PR_FIN} {
	contador++;
    CToken t = new CToken(contador,yytext(),"PR_FIN",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{PR_LEER} {
	contador++;
    CToken t = new CToken(contador,yytext(),"PR_LEER",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{PR_ESCRIBIR} {
	contador++;
    CToken t = new CToken(contador,yytext(),"PR_ESCRIBIR",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{PR_SI} {
	contador++;
    CToken t = new CToken(contador,yytext(),"PR_SI",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{PR_SINO} {
	contador++;
    CToken t = new CToken(contador,yytext(),"PR_SINO",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{PR_FIN_SI} {
	contador++;
    CToken t = new CToken(contador,yytext(),"PR_FIN_SI",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{PR_SEGUN} {
	contador++;
    CToken t = new CToken(contador,yytext(),"PR_SEGUN",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{PR_DE_OTRO_MODO} {
	contador++;
    CToken t = new CToken(contador,yytext(),"PR_DE_OTRO_MODO",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{PR_FIN_SEGUN} {
	contador++;
    CToken t = new CToken(contador,yytext(),"PR_FIN_SEGUN",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{PR_MIENTRAS} {
	contador++;
    CToken t = new CToken(contador,yytext(),"PR_MIENTRAS",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{PR_FIN_MIENTRAS} {
	contador++;
    CToken t = new CToken(contador,yytext(),"PR_FIN_MIENTRAS",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{PR_HACER} {
	contador++;
    CToken t = new CToken(contador,yytext(),"PR_HACER",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{PR_MIENTRAS_QUE} {
	contador++;
    CToken t = new CToken(contador,yytext(),"PR_MIENTRAS_QUE",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{PR_PARA} {
	contador++;
    CToken t = new CToken(contador,yytext(),"PR_PARA",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{PR_HASTA} {
	contador++;
    CToken t = new CToken(contador,yytext(),"PR_HASTA",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{PR_PASO} {
	contador++;
    CToken t = new CToken(contador,yytext(),"PR_PASO",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{PR_FIN_PARA} {
	contador++;
    CToken t = new CToken(contador,yytext(),"PR_FIN_PARA",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{OR_MAYOR_QUE} {
	contador++;
    CToken t = new CToken(contador,yytext(),"OR_MAYOR_QUE",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{OR_MENOR_QUE} {
	contador++;
    CToken t = new CToken(contador,yytext(),"OR_MENOR_QUE",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{OR_IGUAL_QUE} {
	contador++;
    CToken t = new CToken(contador,yytext(),"OR_IGUAL_QUE",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{OR_MENOR_O_IGUAL_QUE} {
	contador++;
    CToken t = new CToken(contador,yytext(),"OR_MENOR_O_IGUAL_QUE",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{OR_MAYOR_O_IGUAL_QUE} {
	contador++;
    CToken t = new CToken(contador,yytext(),"OR_MAYOR_O_IGUAL_QUE",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{OL_Y} {
	contador++;
    CToken t = new CToken(contador,yytext(),"y",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{OL_O} {
	contador++;
    CToken t = new CToken(contador,yytext(),"OL_O",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{OL_NO} {
	contador++;
    CToken t = new CToken(contador,yytext(),"OL_NO",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{OA_SUMA} {
	contador++;
    CToken t = new CToken(contador,yytext(),"OA_SUMA",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{OA_RESTA} {
	contador++;
    CToken t = new CToken(contador,yytext(),"OA_RESTA",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{OA_PRODUCTO} {
	contador++;
    CToken t = new CToken(contador,yytext(),"OA_PRODUCTO",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{OA_DIVISION} {
	contador++;
    CToken t = new CToken(contador,yytext(),"OA_DIVISION",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{OA_MODULO} {
	contador++;
    CToken t = new CToken(contador,yytext(),"OA_MODULO",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{O_ASIGNACION} {
	contador++;
    CToken t = new CToken(contador,yytext(),"O_ASIGNACION",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{O_DOS_PUNTOS} {
	contador++;
    CToken t = new CToken(contador,yytext(),"O_DOS_PUNTOS",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{O_PAREN_ABRE} {
	contador++;
    CToken t = new CToken(contador,yytext(),"O_PAREN_ABRE",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{O_PAREN_CIERRA} {
	contador++;
    CToken t = new CToken(contador,yytext(),"O_PAREN_CIERRA",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{O_CORCHETE_ABRE} {
	contador++;
    CToken t = new CToken(contador,yytext(),"O_CORCHETE_ABRE",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{O_CORCHETE_CIERRA} {
	contador++;
    CToken t = new CToken(contador,yytext(),"O_CORCHETE_CIERRA",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{O_COMA} {
	contador++;
    CToken t = new CToken(contador,yytext(),"O_COMA",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{ID_VAR} {
	contador++;
    CToken t = new CToken(contador,yytext(),"ID_VAR",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{VALOR_ENTERO} {
	contador++;
    CToken t = new CToken(contador,yytext(),"VALOR_ENTERO",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{VALOR_REAL} {
	contador++;
    CToken t = new CToken(contador,yytext(),"VALOR_REAL",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{VALOR_BOOLEANO} {
	contador++;
    CToken t = new CToken(contador,yytext(),"VALOR_BOOLEANO",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{VALOR_CADENA} {
	contador++;
    CToken t = new CToken(contador,yytext(),"VALOR_CADENA",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{VALOR_ESPACIO} {
	contador++;
    CToken t = new CToken(contador,yytext(),"VALOR_ESPACIO",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{VALOR_FIN_LINEA} {
	contador++;
    CToken t = new CToken(contador,yytext(),"VALOR_FIN_LINEA",yyline,yycolumn);
    tokens.add(t);
    return t;
}
