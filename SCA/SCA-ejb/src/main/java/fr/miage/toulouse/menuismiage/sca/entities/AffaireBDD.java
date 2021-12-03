/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.menuismiage.sca.entities;

import fr.miage.toulouse.menuismiage.menuismiageshared.entities.Commande;
import fr.miage.toulouse.menuismiage.menuismiageshared.entities.Client;
import fr.miage.toulouse.menuismiage.menuismiageshared.entities.Cheque;
import fr.miage.toulouse.menuismiage.menuismiageshared.entities.Affaire;
import java.util.HashMap;


/**
 *
 * @author aubin.sacco
 */
public class AffaireBDD {
    public HashMap<String, Affaire> affaires;
    public HashMap<String, Cheque> cheques;
    public HashMap<String, Client> clients;
    public HashMap<String, Commande> commandes;

    /**
     * constructeur initialisant une nouvelle base vide.
     */
    
    
    public AffaireBDD() {
        this.affaires = new HashMap<>();
        this.cheques = new HashMap<>();
        this.clients = new HashMap<>();
        this.commandes = new HashMap<>();
    }
}
