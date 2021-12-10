/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.menuismiage.gestionaffairessca.core.metier;

import fr.miage.toulouse.menuismiage.gestionaffairessca.core.controllers.AffaireBeanLocal;
import fr.miage.toulouse.menuismiage.menuismiageshared.entities.Affaire;
import fr.miage.toulouse.menuismiage.menuismiageshared.entities.RdvCommercial;
import fr.miage.toulouse.menuismiage.menuismiageshared.exceptions.AffaireInexistanteException;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author aubin.sacco
 */
@Stateless
public class AffaireMetier implements AffaireMetierLocal {

    @EJB
    private AffaireBeanLocal affaireBean;
    

    @Override
    public Affaire ajouterAffaire(Affaire affaire) {
        return this.affaireBean.ajouterAffaire(affaire);
    }

    @Override
    public ArrayList<RdvCommercial> listerRDVCommerciaux() {
        return this.affaireBean.getRdvCommerciaux();
    }

    @Override
    public Affaire getAffaire(int idAffaire) throws AffaireInexistanteException {
        return this.affaireBean.getAffaire(idAffaire);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
