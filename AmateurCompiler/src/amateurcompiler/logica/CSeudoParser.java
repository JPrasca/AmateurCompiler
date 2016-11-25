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
    
//    public boolean inicioPrograma(){
//        
//        for (CToken t : tokens) {
//
//            if (t.getToken().matches(CCadenas.PR_ABRE) || t.getToken().matches(CCadenas.PR_CIERRA)) {
//
//                abreCierre.add(t);
//            }
//        }
//        
//    }
    
    public void recorridoAbreCierra() {
        this.abreCierre = new ArrayList<>();

        for (CToken t : tokens) {

            if (t.getToken().matches(CCadenas.PR_ABRE) || t.getToken().matches(CCadenas.PR_CIERRA)) {

                abreCierre.add(t);
            }
        }

    }

    public boolean verificarSintaxis() {

        if (validarInicioFin() == true && verificarLineasIndividualmente()) {
            return true;
        } else {
            return false;
        }

    }

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
                this.log.getListadoLog().add("Encontró ABRE, Metio en pila, SALTO A Q1");
                pila.push("A");
                estado = 1;
            }
            else if(abreCierre.get(0).getToken().matches(CCadenas.PR_CIERRA)){
                this.log.getListadoLog().add("Encontró CIERRA, ESTA SECUENCIA NO ES VALIDA");
                return false;
            }
            for (int i = 1; i < abreCierre.size(); i++) {

                if (abreCierre.get(i).getToken().matches(CCadenas.PR_ABRE)) {
                    pila.push("A");
                    estado = 1;
                    this.log.getListadoLog().add("Encontró ABRE, Metio en pila, SALTO A Q1");
                } else if (abreCierre.get(i).getToken().matches(CCadenas.PR_CIERRA)) {

                    this.log.getListadoLog().add("Encontró CIERRA");

                    if (pila.estaVacia()) {
                        this.log.getListadoLog().add("LA PILA NO TIENE NA");

                        this.log.getListadoLog().add("LA CADENA NO ENTRA AQUI");
                        bandera = false;
                        return bandera;

                    } else {
                        this.log.getListadoLog().add("SACA UN A DE PILA, SALTO A Q1");
                        pila.pop();
                        estado = 1;
                        this.log.getListadoLog().add("TOKEN " + i);
                        if (i == abreCierre.size() - 1) {
                            this.log.getListadoLog().add("FIN DE CADENA, SALTA A Q2 SI LA PILA ESTA VACIA");
                            estado = 2;
                        }
                    }

                }

                if (pila.estaVacia() && estado == 2) {

                    this.log.getListadoLog().add("PILA VACIA Y ESTADO FINAL");
                    bandera = true;
                }

            }
        } catch (Exception ex) {

        }
        return bandera;

    }

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
            if(flag == false){
                this.log.getListadoLog().add("ERROR EN LA LINEA "+ l.index + " - " + l.getLineaString());
            }
            lineaIndividual = "";
        }

        return flag;
    }

    public boolean sintaxisDeLinea(String linea) {
        boolean flag;
        
        flag = CCadenas.evaluarCadena(linea);

        return flag;
    }

    public ArrayList<CLinea> getLineasDeCodigo() {
        return lineasDeCodigo;
    }

    public ArrayList<CToken> getTokens() {
        return tokens;
    }

    public CLogStrings getLog() {
        return log;
    }

}
