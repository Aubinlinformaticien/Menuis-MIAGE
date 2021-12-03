/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.menuismiage.gestioncommerciaux.entities;

import fr.miage.toulouse.menuismiage.menuismiageshared.entities.RdvCommercial;
import fr.miage.toulouse.menuismiage.menuismiageshared.entities.Commercial;
import java.util.HashMap;

/**
 *
 * @author aubin.sacco
 */
public class CommerciauxBDD {
    public HashMap<String, Commercial> commerciaux;
    public HashMap<String, RdvCommercial> rdvs;
    /**
     * constructeur initialisant une nouvelle base vide.
     */
    
    public CommerciauxBDD() {
        this.commerciaux = new HashMap<>();
        this.rdvs = new HashMap<>();
    }
}
