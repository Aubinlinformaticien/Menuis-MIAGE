/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.menuismiage.gestionaffairessca.core.services;

import fr.miage.toulouse.menuismiage.menuismiageshared.exceptions.AffaireInexistanteException;
import javax.ejb.Local;

/**
 *
 * @author aubin.sacco
 */
@Local
public interface ServiceAffairesLocal {

    public Object ajouterAffaire(String content);
    
    public Object listerRDVCommerciaux();

    public Object ajouterRdvCommercial(String content) throws AffaireInexistanteException;
    
}
