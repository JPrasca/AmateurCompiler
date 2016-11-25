/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amateurcompiler.logica.fuentes;

import java.util.ArrayList;

/**
 *
 * @author jdpra
 */
public class CPilaLlaves {

    private int tope = 0;
    private ArrayList<String> elementos;

    public CPilaLlaves() {

        elementos = new ArrayList<>();
    }

    public String pop() {

        if (!estaVacia()) {
            int i = tope;
            tope--;
            return this.elementos.get(i - 1);
        } else {
            return "VACIA";
        }
    }

    public void push(String caracter) {
        this.elementos.add(caracter);
        this.tope++;
    }

    public boolean estaVacia() {
        return (tope == 0);
    }

}
