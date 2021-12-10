/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.menuismiage.gestionaffairessca.core.metier;

import fr.miage.toulouse.menuismiage.menuismiageshared.entities.Affaire;
import fr.miage.toulouse.menuismiage.menuismiageshared.entities.RdvCommercial;
import fr.miage.toulouse.menuismiage.menuismiageshared.exceptions.AffaireInexistanteException;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author aubin.sacco
 */
@Local
public interface AffaireMetierLocal {

    public Affaire ajouterAffaire(Affaire affaire);

    public ArrayList<RdvCommercial> listerRDVCommerciaux();

    public Affaire getAffaire(int idAffaire) throws AffaireInexistanteException;
    
}
