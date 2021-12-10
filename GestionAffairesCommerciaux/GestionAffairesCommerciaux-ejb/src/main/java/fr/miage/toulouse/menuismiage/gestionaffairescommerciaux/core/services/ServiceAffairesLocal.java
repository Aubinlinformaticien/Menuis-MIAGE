/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.menuismiage.gestionaffairescommerciaux.core.services;

import fr.miage.toulouse.menuismiage.menuismiageshared.entities.Affaire;
import fr.miage.toulouse.menuismiage.menuismiageshared.exceptions.StatutAffaireInvalide;
import javax.ejb.Local;

/**
 *
 * @author aubin.sacco
 */
@Local
public interface ServiceAffairesLocal {
    public void ajouterAffaire(Affaire affaire);
    public Object modifierStatut(String id, String content) throws StatutAffaireInvalide;
    public Object listerAffaires();
}
