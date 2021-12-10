/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.menuismiage.gestionaffairessca.core.controllers;

import fr.miage.toulouse.menuismiage.gestionaffairessca.core.entities.AffairesBD;
import fr.miage.toulouse.menuismiage.menuismiageshared.entities.Affaire;
import fr.miage.toulouse.menuismiage.menuismiageshared.entities.RdvCommercial;
import fr.miage.toulouse.menuismiage.menuismiageshared.exceptions.AffaireInexistanteException;
import java.util.ArrayList;
import javax.ejb.Singleton;

/**
 *
 * @author aubin.sacco
 */
@Singleton
public class AffaireBean implements AffaireBeanLocal {
   
    private AffairesBD bd;

    public AffaireBean() {
        this.bd = new AffairesBD();
    }
    
    @Override
    public Affaire ajouterAffaire(Affaire a) {
        a.setId(bd.getLength());
        this.bd.ajouterAffaire(a);
        return a;
    }

    @Override
    public ArrayList<RdvCommercial> getRdvCommerciaux() {
        ArrayList<RdvCommercial> rdvs = new ArrayList<>();
        RdvCommercial rdv;
        
        for (Affaire affaire : bd.affaires) {
            rdv = affaire.getRdvCommercial();
            rdvs.add(rdv);
        }
        
        return rdvs;
    }

    @Override
    public Affaire getAffaire(int idAffaire) throws AffaireInexistanteException{
        try {
            return this.bd.affaires.get(idAffaire);
        } catch (NullPointerException ex){
            throw new AffaireInexistanteException();
        }
    }
    
}
