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
public class CLogStrings {
    private ArrayList<String> listadoLog;
    
    public CLogStrings(){
        listadoLog = new ArrayList<>();
    }

    public ArrayList<String> getListadoLog() {
        return listadoLog;
    }
    
    public void setListadoLog(ArrayList<String> listadoLog) {
        this.listadoLog = listadoLog;
    }    
}
