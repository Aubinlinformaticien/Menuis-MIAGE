/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.menuismiage.gestionaffairescommerciaux.core.metier;

import fr.miage.toulouse.menuismiage.gestionaffairescommerciaux.core.controllers.AffairesBeanLocal;
import fr.miage.toulouse.menuismiage.menuismiageshared.entities.Affaire;
import fr.miage.toulouse.menuismiage.menuismiageshared.exceptions.StatutAffaireInvalide;
import java.util.LinkedHashMap;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author aubin.sacco
 */
@Stateless
public class AffairesMetier implements AffairesMetierLocal {

    @EJB
    private AffairesBeanLocal affairesBean;

    @Override
    public void ajouterAffaire(Affaire affaire) {
        this.affairesBean.ajouterAffaire(affaire);
    }

    @Override
    public LinkedHashMap<Integer, Affaire> listerAffaires() {
        return this.affairesBean.getAffaires();
    }

    @Override
    public String modifierStatut(int id, String statut) throws StatutAffaireInvalide{
        if(!statut.equals("RDV_CONFIRME")){
            throw new StatutAffaireInvalide();
        } else{
            return this.affairesBean.updateStatut(id, statut);
        }
    }
}