/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.menuismiage.menuismiageshared.entities;

import java.io.Serializable;

/**
 *
 * @author aubin.sacco
 */
public class Affaire implements Serializable {
    private int id;
    private String statut;
    private int idCommercial;
    private int idPoseur;
    private Cheque cheque1;
    private Cheque cheque2;
    private Commande commande;
    private Client client;

    public Affaire(int id, String statut, int idCommercial, int idPoseur, Cheque cheque1, Cheque cheque2, Commande commande, Client client) {
        this.id = id;
        this.statut = statut;
        this.idCommercial = idCommercial;
        this.idPoseur = idPoseur;
        this.cheque1 = cheque1;
        this.cheque2 = cheque2;
        this.commande = commande;
        this.client = client;
    }

    public int getId() {
        return id;
    }
    
    
    
}
