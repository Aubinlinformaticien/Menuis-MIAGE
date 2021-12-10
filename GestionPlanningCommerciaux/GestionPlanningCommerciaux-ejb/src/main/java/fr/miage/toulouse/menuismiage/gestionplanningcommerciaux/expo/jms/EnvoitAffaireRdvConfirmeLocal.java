/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.menuismiage.gestionplanningcommerciaux.expo.jms;

import fr.miage.toulouse.menuismiage.menuismiageshared.entities.Affaire;
import javax.ejb.Local;

/**
 *
 * @author aubin.sacco
 */
@Local
public interface EnvoitAffaireRdvConfirmeLocal {
    public void propositionRdvCommercialJMS(Affaire a);
}
