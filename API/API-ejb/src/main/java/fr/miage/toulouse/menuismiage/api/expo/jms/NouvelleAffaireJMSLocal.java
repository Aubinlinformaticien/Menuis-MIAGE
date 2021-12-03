/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.menuismiage.api.expo.jms;

import fr.miage.toulouse.menuismiage.menuismiageshared.entities.Affaire;
import javax.ejb.Local;

/**
 *
 * @author aubin.sacco
 */
@Local
public interface NouvelleAffaireJMSLocal {
    public void creerAffaire(Affaire affaire);
}
