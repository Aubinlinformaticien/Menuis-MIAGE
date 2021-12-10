/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.menuismiage.gestionplanningcommerciaux.core.services;

import fr.miage.toulouse.menuismiage.menuismiageshared.entities.Affaire;
import fr.miage.toulouse.menuismiage.menuismiageshared.exceptions.AffaireInexistanteException;
import fr.miage.toulouse.menuismiage.menuismiageshared.exceptions.StatutAffaireInvalide;
import javax.ejb.Local;

/**
 *
 * @author aubin.sacco
 */
@Local
public interface ServiceAffairesLocal {

    public void ajouterAffaire(Affaire affaire);

    public Object listerAffaires();

    public Object modifierStatut(String id, String content) throws StatutAffaireInvalide, AffaireInexistanteException;
    
}
