/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.menuismiage.gestionaffairessca.core.services;

import com.google.gson.Gson;
import fr.miage.toulouse.menuismiage.gestionaffairessca.core.metier.AffaireMetierLocal;
import fr.miage.toulouse.menuismiage.gestionaffairessca.expo.jms.AffairesEnAttentesLocal;
import fr.miage.toulouse.menuismiage.menuismiageshared.entities.Affaire;
import fr.miage.toulouse.menuismiage.menuismiageshared.entities.Client;
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
public class ServiceAffaires implements ServiceAffairesLocal {

    @EJB
    private AffairesEnAttentesLocal affairesEnAttentes;

    @EJB
    private AffaireMetierLocal affaireMetier;
    
    

    private Gson gson;

    public ServiceAffaires() {
        this.gson = new Gson();
    }
    
    @Override
    public Object ajouterAffaire(String content) {
        Client client = this.gson.fromJson(content, Client.class);
        Affaire affaire = new Affaire(client);
        affaire.setStatut("ATT_PROP_RDV_COM");
        affaire = this.affaireMetier.ajouterAffaire(affaire);
        return this.gson.toJson(affaire);
    }
    
    @Override
    public Object listerRDVCommerciaux(){
        ArrayList<RdvCommercial> rdv =  this.affaireMetier.listerRDVCommerciaux();
        return this.gson.toJson(rdv);
    }

    @Override
    public Object ajouterRdvCommercial(String content) throws AffaireInexistanteException {
        
        // Creer RdvCommercial avec JSON reçu
        RdvCommercial rdv = this.gson.fromJson(content, RdvCommercial.class);
        
        // Récuperer affaire du rdv commercial
        Affaire affaire = this.affaireMetier.getAffaire(rdv.getIdAffaire());
        // Faire proposition rdv commercial
        affaire.setRdvCommercial(rdv);
        
        // Mettre affaire en attente de confirmation de rdv du commerercial
        affaire.setStatut("ATT_CONF_RDV_COM");
        
        // Envoyer affaire dans topic "AffairesEnAttentes"
        this.affairesEnAttentes.propositionRdvCommercialJMS(affaire, affaire.getStatut());
        
        // Retourner preuve que RDV bien crée & inséré en base
        return this.gson.toJson(affaire.getRdvCommercial());
    }
}

