/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.menuismiage.gestionaffairescommerciaux.core.metier;

import fr.miage.toulouse.menuismiage.menuismiageshared.entities.Affaire;
import fr.miage.toulouse.menuismiage.menuismiageshared.exceptions.StatutAffaireInvalide;
import java.util.LinkedHashMap;
import javax.ejb.Local;

/**
 *
 * @author aubin.sacco
 */
@Local
public interface AffairesMetierLocal {
    
    public void ajouterAffaire(Affaire affaire);

    public LinkedHashMap<Integer, Affaire> listerAffaires();

    public String modifierStatut(int id, String statut) throws StatutAffaireInvalide;
}
