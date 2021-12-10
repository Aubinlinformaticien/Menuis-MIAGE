/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.menuismiage.menuismiageshared.entities;

import java.io.Serializable;

/**
 *
 * @author aubin.sacco
 */
public class RdvCommercial implements Serializable {
    private int idAffaire;
    private String date;
    private String idCommercial;

    public RdvCommercial(int idAffaire, String date, String idCommercial) {
        this.idAffaire = idAffaire;
        this.date = date;
        this.idCommercial = idCommercial;
    }

    public int getIdAffaire() {
        return idAffaire;
    }
    
    
    
    
}


