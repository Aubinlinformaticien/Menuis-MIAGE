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
public class Client implements Serializable{
    private String nom;
    private String prenom;
    private String mail;
    private String adressePostale;
    private String telephone;
    private String geolocalisation;

    public Client(String nom, String prenom, String mail, String adressePostale, String telephone, String geolocalisation) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.adressePostale = adressePostale;
        this.telephone = telephone;
        this.geolocalisation = geolocalisation;
    }
 
}


