/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.menuismiage.api.services;

import com.google.gson.Gson;
import fr.miage.toulouse.menuismiage.api.expo.jms.NouvelleAffaireJMS;
import fr.miage.toulouse.menuismiage.menuismiageshared.entities.Affaire;
import javax.ejb.Stateless;

/**
 *
 * @author aubin.sacco
 */
@Stateless
public class ServiceAffaire implements ServiceAffaireLocal {

    private Gson gson;
    
    private NouvelleAffaireJMS nouvelleAffaireJMS;

    @Override
    public void ajouterAffaire(String a) {
            System.out.println(a);
            Affaire affaire = this.gson.fromJson(a, Affaire.class);
            // titrevalide permet de positionner correctement la date de prise en compte de la cotation
            //Affaire titrevalide = new TitreBoursier(titre.getMnemo(), titre.getNom(), titre.getCours());

            this.nouvelleAffaireJMS.creerAffaire(affaire);
    }
}
