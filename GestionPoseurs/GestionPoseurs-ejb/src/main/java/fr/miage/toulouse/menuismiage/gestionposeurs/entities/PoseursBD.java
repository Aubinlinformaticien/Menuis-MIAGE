/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.menuismiage.gestionposeurs.entities;

import fr.miage.toulouse.menuismiage.menuismiageshared.entities.RdvPoseur;
import fr.miage.toulouse.menuismiage.menuismiageshared.entities.Poseur;
import java.util.HashMap;

/**
 *
 * @author aubin.sacco
 */
public class PoseursBD {
    public HashMap<String, Poseur> poseurs;
    public HashMap<String, RdvPoseur> rdvs;

    /**
     * constructeur initialisant une nouvelle base vide.
     */
    
    public PoseursBD() {
        this.poseurs = new HashMap<>();
        this.rdvs = new HashMap<>();
    }
}
