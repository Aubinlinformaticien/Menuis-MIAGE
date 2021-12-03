/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.menuismiage.api.services;

import javax.ejb.Local;

/**
 *
 * @author aubin.sacco
 */
@Local
public interface ServiceAffaireLocal {
    public void ajouterAffaire(String a);
}
