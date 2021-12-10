/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.menuismiage.gestionplanningcommerciaux.core.controllers;

import fr.miage.toulouse.menuismiage.gestionplanningcommerciaux.core.entities.AffairesBD;
import fr.miage.toulouse.menuismiage.menuismiageshared.entities.Affaire;
import fr.miage.toulouse.menuismiage.menuismiageshared.entities.RdvCommercial;
import fr.miage.toulouse.menuismiage.menuismiageshared.exceptions.AffaireInexistanteException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import javax.ejb.Singleton;

/**
 *
 * @author aubin.sacco
 */
@Singleton
public class AffairesBean implements AffairesBeanLocal {
private AffairesBD bd;

    public AffairesBean() {
        this.bd = new AffairesBD();
    }
    
    @Override
    public Affaire ajouterAffaire(Affaire a) {
        this.bd.ajouterAffaire(a);
        return a;
    }

    @Override
    public ArrayList<RdvCommercial> getRdvCommerciaux() {
        ArrayList<RdvCommercial> rdvs = new ArrayList<>();
        RdvCommercial rdv;
        
        for (int i = 0; i < bd.affaires.size(); i++) {
            rdv = bd.affaires.get(i).getRdvCommercial();
            rdvs.add(rdv);
        }
        
        return rdvs;
    }

    @Override
    public Affaire getAffaire(int idAffaire) throws AffaireInexistanteException {
        try {
             return this.bd.affaires.get(idAffaire);
        } catch (NullPointerException ex){
            throw new AffaireInexistanteException();
        }
    }

    @Override
    public LinkedHashMap<Integer, Affaire> getAffaires() {
        return this.bd.affaires;
    }

    // Devrait être dans le metier je pense 
    @Override
    public String updateStatut(int id, String statut) throws AffaireInexistanteException {
            this.getAffaire(id).setStatut(statut);
            return this.getAffaire(id).getStatut();
        
    }
}
