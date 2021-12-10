/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.menuismiage.gestionaffairescommerciaux.core.controllers;

import fr.miage.toulouse.menuismiage.gestionaffairescommerciaux.core.entities.AffairesBD;
import fr.miage.toulouse.menuismiage.menuismiageshared.entities.Affaire;
import fr.miage.toulouse.menuismiage.menuismiageshared.entities.RdvCommercial;
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
    public Affaire getAffaire(int idAffaire) {
        System.out.println(idAffaire);
        return this.bd.affaires.get(idAffaire);
    }

    @Override
    public LinkedHashMap<Integer, Affaire> getAffaires() {
        return this.bd.affaires;
    }

    @Override
    public String updateStatut(int id, String statut) {
        this.bd.affaires.get(id).setStatut(statut);
        return this.bd.affaires.get(id).getStatut();
    }
}
