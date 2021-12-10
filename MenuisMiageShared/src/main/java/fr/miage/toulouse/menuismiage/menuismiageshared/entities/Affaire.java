/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.menuismiage.menuismiageshared.entities;

import java.io.Serializable;

/**
 *
 * Classe regroupant les services relatifs aux affaires et pouvant être exposés à l'extérieur du coeur de l'application.
 *
 *
 * @author Aubin Sacco  <aubin.sacco@toulouse.miage.fr>, MIAGE, Université Paul Sabatier
 * @version 1.1, 8 dec. 2021
 */
public class Affaire implements Serializable {
    private int id;
    private String statut;
    private Cheque cheque1;
    private Cheque cheque2;
    private Commande commande;
    private RdvCommercial rdvCommercial;
    private RdvPoseur rdvPoseur;
    private Client client;
    private String geolocalisation;

    public Affaire(Client client) {
        this.client = client;
    }
    
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getStatut() {
        return statut;
    }

    public RdvCommercial getRdvCommercial() {
        return this.rdvCommercial;
    }

    public void setRdvCommercial(RdvCommercial rdvCommercial) {
        this.rdvCommercial = rdvCommercial;
    }

    public void setRdvPoseur(RdvPoseur rdvPoseur) {
        this.rdvPoseur = rdvPoseur;
    }

    public RdvPoseur getRdvPoseur() {
        return rdvPoseur;
    }
    
    
    
    
    
}
