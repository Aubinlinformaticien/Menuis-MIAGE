/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.menuismiage.gestionplanningcommerciaux.core.services;

import com.google.gson.Gson;
import fr.miage.toulouse.menuismiage.gestionplanningcommerciaux.core.metier.AffairesMetierLocal;
import fr.miage.toulouse.menuismiage.gestionplanningcommerciaux.expo.jms.EnvoitAffaireRdvConfirmeLocal;
import fr.miage.toulouse.menuismiage.menuismiageshared.entities.Affaire;
import fr.miage.toulouse.menuismiage.menuismiageshared.exceptions.AffaireInexistanteException;
import fr.miage.toulouse.menuismiage.menuismiageshared.exceptions.StatutAffaireInvalide;
import java.util.Properties;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author aubin.sacco
 */
@Stateless
public class ServiceAffaires implements ServiceAffairesLocal {

    @EJB
    private EnvoitAffaireRdvConfirmeLocal envoitAffaireRdvConfirme;

    @EJB
    private AffairesMetierLocal affairesMetier;
    
    private Gson gson;
    
    public ServiceAffaires(){
        this.gson = new Gson();
    }

    @Override
    public void ajouterAffaire(Affaire affaire) {
        this.affairesMetier.ajouterAffaire(affaire);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Object listerAffaires() {
        return this.gson.toJson(this.affairesMetier.listerAffaires());
    }

    @Override
    public Object modifierStatut(String id, String content) throws StatutAffaireInvalide, AffaireInexistanteException {
        Properties data = this.gson.fromJson(content, Properties.class);
        String statut = data.getProperty("statut");
        return "{ \"statut\" : \""+this.affairesMetier.modifierStatut(Integer.parseInt(id), statut)+"\" }";

    }
}
