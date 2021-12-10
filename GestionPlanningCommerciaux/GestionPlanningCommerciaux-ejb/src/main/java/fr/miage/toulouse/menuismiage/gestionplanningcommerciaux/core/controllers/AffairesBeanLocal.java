/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.menuismiage.gestionplanningcommerciaux.core.controllers;

import fr.miage.toulouse.menuismiage.menuismiageshared.entities.Affaire;
import fr.miage.toulouse.menuismiage.menuismiageshared.entities.RdvCommercial;
import fr.miage.toulouse.menuismiage.menuismiageshared.exceptions.AffaireInexistanteException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import javax.ejb.Local;

/**
 *
 * @author aubin.sacco
 */
@Local
public interface AffairesBeanLocal {
    public Affaire ajouterAffaire(Affaire a);
    
    public ArrayList<RdvCommercial> getRdvCommerciaux();

    public Affaire getAffaire(int idAffaire) throws AffaireInexistanteException;

    public LinkedHashMap<Integer, Affaire> getAffaires();

    public String updateStatut(int id, String statut) throws AffaireInexistanteException;
}
