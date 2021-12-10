/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.menuismiage.gestionaffairessca.core.entities;

import fr.miage.toulouse.menuismiage.menuismiageshared.entities.Affaire;
import java.util.ArrayList;

/**
 *
 * @author aubin.sacco
 */
public class AffairesBD {
    
    public ArrayList<Affaire> affaires;

    /**
     * constructeur initialisant une nouvelle base vide.
     */
    public AffairesBD() {
        this.affaires = new ArrayList<>();
    }
    
    public void ajouterAffaire(Affaire a){ 
        this.affaires.add(a);
    }
    
    public Affaire getAffaire(int id){
        return this.affaires.get(id);
    }
    
    public int getLength(){
        return this.affaires.size();
    }
}
