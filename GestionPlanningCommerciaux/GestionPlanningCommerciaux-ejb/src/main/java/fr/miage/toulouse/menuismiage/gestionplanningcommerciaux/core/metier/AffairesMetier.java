/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.menuismiage.gestionplanningcommerciaux.core.metier;

import fr.miage.toulouse.menuismiage.gestionplanningcommerciaux.core.controllers.AffairesBeanLocal;
import fr.miage.toulouse.menuismiage.gestionplanningcommerciaux.expo.jms.EnvoitAffaireRdvConfirmeLocal;
import fr.miage.toulouse.menuismiage.menuismiageshared.entities.Affaire;
import fr.miage.toulouse.menuismiage.menuismiageshared.exceptions.AffaireInexistanteException;
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
    private EnvoitAffaireRdvConfirmeLocal envoitAffaireRdvConfirme;

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

    /**
     *
     * @param id
     * @param statut
     * @return
     * @throws StatutAffaireInvalide
     * @throws fr.miage.toulouse.menuismiage.menuismiageshared.exceptions.AffaireInexistanteException
     */
    @Override
    public String modifierStatut(int id, String statut) throws StatutAffaireInvalide, AffaireInexistanteException{
        if(!statut.equals("RDV_CONFIRME")){
            throw new StatutAffaireInvalide();
        } else{
            String s = this.affairesBean.updateStatut(id, statut);
            // Dès que le statut est bien inséré en base, on envoit l'affaire dans le topic AffaireRdvConfirmé
            Affaire a = this.affairesBean.getAffaire(id);
            this.envoitAffaireRdvConfirme.propositionRdvCommercialJMS(a);
            return s;
        }
    }
}
