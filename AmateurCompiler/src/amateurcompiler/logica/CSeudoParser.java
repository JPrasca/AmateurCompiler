/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amateurcompiler.logica;

import java.util.ArrayList;
import amateurcompiler.logica.fuentes.*;

/**
 *
 * @author jdpra
 */
public class CSeudoParser {

    private ArrayList<CToken> tokens, abreCierre;

    private ArrayList<CLinea> lineasDeCodigo;
    private CLogStrings log = new CLogStrings();

    public CSeudoParser(ArrayList<CToken> tokensIn) {

        lineasDeCodigo = new ArrayList<>();
        this.tokens = tokensIn;

        int i = 0;
        CToken t;
        CLinea c = new CLinea();

        do {
            t = tokens.get(i);

            c.tokens.add(t);
            c.index = t.getLinea();

            if (t.getToken().matches(CCadenas.VALOR_FIN_LINEA) || i == tokens.size() - 1) {
                c.tokens.remove(t);
                lineasDeCodigo.add(c);
                //System.out.println("LINEA ARMADA #:" + c.index + " -> " + c.getLineaString());
                c = new CLinea();
            }

            i++;
        } while (i < tokens.size());
    }
    
    
    
    /**
     * @return verdadero si las secciones del código estan en su sitio
     *
     */
    public boolean verEstructuraPrograma() {
        boolean flag;
        int estado = 0;
        ArrayList<CToken> otro = new ArrayList<>();
        this.log.getListadoLog().add("AÑADIENDO TOKENS A EVALUAR");
        this.log.getListadoLog().add("VERIFICANDO INICIO DEL PROGRAMA");
        for (CToken t : tokens) {

            if (t.getToken().matches(CCadenas.PR_PROGRAMA) || t.getToken().matches(CCadenas.PR_VARIABLE)
                    || t.getToken().matches(CCadenas.PR_ENTERO) || t.getToken().matches(CCadenas.PR_CADENA)
                    || t.getToken().matches(CCadenas.PR_REAL) || t.getToken().matches(CCadenas.PR_BOOLEANO)
                    || t.getToken().matches(CCadenas.PR_INICIO) || t.getToken().matches(CCadenas.PR_FIN)) {

                otro.add(t);
            }
        }

        this.log.getListadoLog().add("PREPARANDO MAQUINA DE RECORRIDO");

        for (int i = 0; i < otro.size(); i++) {

            if (otro.get(i).getToken().matches(CCadenas.PR_PROGRAMA) && estado == 0) {
                this.log.getListadoLog().add("palabra reservada: programa... paso a Q1");
          
                estado = 1;
            } else if (otro.get(i).getToken().matches(CCadenas.PR_VARIABLE) && estado == 1) {
                this.log.getListadoLog().add("palabra reservada: variable... paso a Q2");
                
                estado = 2;
            } else if (otro.get(i).getToken().matches(CCadenas.PR_ENTERO) || otro.get(i).getToken().matches(CCadenas.PR_CADENA)
                    || otro.get(i).getToken().matches(CCadenas.PR_REAL) || otro.get(i).getToken().matches(CCadenas.PR_BOOLEANO) && estado == 2) {
               
                estado = 2;
                this.log.getListadoLog().add("palabra reservada de declaracion de tipos... paso a Q2");
            } else if (otro.get(i).getToken().matches(CCadenas.PR_INICIO) && (estado == 2 || estado == 1) ) {
               
                estado = 3;
                this.log.getListadoLog().add("palabra reservada de inicio... Ppaso a Q3");
            } else if (otro.get(i).getToken().matches(CCadenas.PR_FIN) && estado == 3) {
                
                estado = 4;
                this.log.getListadoLog().add("palabra reservada: fin... paso a Q4");
            } else {
                this.log.getListadoLog().add("palabra reservada: " + otro.get(i).getToken() + "... no se puede procesar");
                this.log.getListadoLog().add("ERROR EN LA LÍNEA " + otro.get(i).getLinea());
                return false;
            }

            if (i == otro.size() - 1 && estado == 4) {
                this.log.getListadoLog().add("fin de cadena... Q4 estado final");
                return true;
            }

        }
        return false;
    }

     public boolean verificarVariables() {
        ArrayList<CToken> variablesDeclaradas = new ArrayList<>();
        boolean flag = true;
        int limit = 0;
        this.log.getListadoLog().add("VERIFICANDO EXISTENCIA DE VARIABLES");
        for(int i = 0; i < tokens.size(); i ++){
            if (tokens.get(i).getToken().matches(CCadenas.ID_VAR)) {
                variablesDeclaradas.add(tokens.get(i));
            }
            if(tokens.get(i).getToken().matches(CCadenas.PR_INICIO)){
                limit = i;
                
                break;
            }
        }
        
      
        
        for(int i = limit; i < tokens.size(); i ++){
            if(tokens.get(i).getTipo().equals("ID_VAR")){
    
                for(int j = 0; j < variablesDeclaradas.size(); j++){
                    System.out.println("COMPARANDO " + tokens.get(i).getToken() + " CON " + variablesDeclaradas.get(j).getToken());
                    if(tokens.get(i).getToken().equals("i")){
                        
                        flag = true;
                        break;
                    }
                    else{
                        
                        flag = false;
                    }
                }
                
                if(flag == false){
                    this.log.getListadoLog().add("error en la linea " + tokens.get(i).getLinea() + " variable " + tokens.get(i).getToken() + " no declarada");
                }
            }
        }
        
        return flag;
    }
    
    /**
     * Llena un arreglo con todas las directivas de apertura y cierre de
     * estructuras
     */
    public void recorridoAbreCierra() {
        this.abreCierre = new ArrayList<>();

        for (CToken t : tokens) {

            if (t.getToken().matches(CCadenas.PR_ABRE) || t.getToken().matches(CCadenas.PR_CIERRA)) {

                abreCierre.add(t);
            }
        }

    }

    /**
     * ejecuta que este bien escrito, inplica aquellos métodos que verifican
     * ciertas características
     * @return un valor true si el codigo ingresado cumple con las condiciones
     */
    public boolean verificarSintaxis() {

        return (verEstructuraPrograma() == true && validarInicioFin() == true && verificarLineasIndividualmente() == true && verificarVariables() == true);

    }

    /**
     * Ejecuta el mecanismo de un AFDP que verifica que las aperturas y los
     * cierres concuerden, de paso se va llenando el log
     */
    public boolean validarInicioFin() {
        boolean bandera = false;
        int estado = 0;
        CPilaLlaves pila = new CPilaLlaves();
        this.recorridoAbreCierra();
        try {
            this.log.getListadoLog().add("VERIFICANDO APERTURAS Y CIERRES");
            if (abreCierre.isEmpty()) {
                this.log.getListadoLog().add("No hay aperturas ni cierre");
                return true;
            }
            if (abreCierre.get(0).getToken().matches(CCadenas.PR_ABRE)) {
                this.log.getListadoLog().add("encontró ABRE, push en pila, paso a Q1");
                pila.push("A");
                estado = 1;
            } else if (abreCierre.get(0).getToken().matches(CCadenas.PR_CIERRA)) {
                this.log.getListadoLog().add("encontró CIERRA, esta secuencia no es válida");
                return false;
            }
            for (int i = 1; i < abreCierre.size(); i++) {

                if (abreCierre.get(i).getToken().matches(CCadenas.PR_ABRE)) {
                    pila.push("A");
                    estado = 1;
                    this.log.getListadoLog().add("encontró ABRE, Metio en pila, SALTO A Q1");
                } else if (abreCierre.get(i).getToken().matches(CCadenas.PR_CIERRA)) {

                    this.log.getListadoLog().add("encontró CIERRA");

                    if (pila.estaVacia()) {
                        this.log.getListadoLog().add("pila vacía");

                        this.log.getListadoLog().add("la secuencia no se acepta");
                        bandera = false;
                        return bandera;

                    } else {
                        this.log.getListadoLog().add("pop en pila... paso a Q1");
                        pila.pop();
                        estado = 1;
                        this.log.getListadoLog().add("TOKEN " + i);
                        if (i == abreCierre.size() - 1) {
                            this.log.getListadoLog().add("fin de cadena... salto a Q2 si no hay nada en pila");
                            estado = 2;
                        }
                    }

                }

                if (pila.estaVacia() && estado == 2) {

                    this.log.getListadoLog().add("pila vacía y estado final");
                    bandera = true;
                }

            }
        } catch (Exception ex) {

        }
        return bandera;

    }

    /**
     *
     * con el arraylist de lineasDeCodigo se van armando cadenas
     * correspondientes a una línea de código de lo ingresado por el usuario
     * cuando llega al fin de línea, se evalúa la cadena de turno con el método
     * sisntaxisDeLinea
     */
    public boolean verificarLineasIndividualmente() {

        boolean flag = false;
        String lineaIndividual = "";
        this.log.getListadoLog().add("VERIFICANDO SINTAXIS...");
        for (int i = 0; i < lineasDeCodigo.size(); i++) {

            CLinea l = lineasDeCodigo.get(i);
            for (int j = 0; j < l.tokens.size(); j++) {

                CToken t = l.tokens.get(j);
                lineaIndividual += t.getToken();
            }

            flag = sintaxisDeLinea(lineaIndividual);
            if (flag == false) {
                this.log.getListadoLog().add("ERROR EN LA LINEA " + l.index + " - " + l.getLineaString());
            }
            lineaIndividual = "";
        }

        return flag;
    }

    /**
     * @return un valor booleano que indica si la cadena corresponde a alguna de
     * las expresiones de la clase CCadenas
     */
    public boolean sintaxisDeLinea(String linea) {
        boolean flag;

        flag = CCadenas.evaluarCadena(linea);

        return flag;
    }

    /**
     *
     * @return el arraylist de arraylist de tokens, correspondiente a las lineas
     * de código analizado
     */
    public ArrayList<CLinea> getLineasDeCodigo() {
        return lineasDeCodigo;
    }

    /**
     * @return un arreglo de tokens
     */
    public ArrayList<CToken> getTokens() {
        return tokens;
    }

    /**
     *
     * @return los eventos detectados
     */
    public CLogStrings getLog() {
        return log;
    }

}
