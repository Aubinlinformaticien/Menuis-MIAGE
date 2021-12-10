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
public class Affaire1 implements Serializable {
    private int id;
    private String statut;
    private String idenfiantCommercial;
    private String identifiantPoseur;
    private Cheque cheque1;
    private Cheque cheque2;
    private Commande commande;
    private RdvCommercial rdvCommercial;
    private RdvPoseur rdvPoseur;
    private String nom;
    private String prenom;
    private String mail;
    private String adressePostale;
    private String telephone;
    private String geolocalisation;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setStatut(String statut) {
        this.statut = statut;
    }
    
}
