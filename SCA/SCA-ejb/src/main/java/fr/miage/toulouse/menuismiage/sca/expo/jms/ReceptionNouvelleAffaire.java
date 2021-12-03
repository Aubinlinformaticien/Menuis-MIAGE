/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.menuismiage.sca.expo.jms;

import com.google.gson.Gson;
import fr.miage.toulouse.menuismiage.menuismiageshared.entities.Affaire;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author aubin.sacco
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "NouvelleAffaireFile")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class ReceptionNouvelleAffaire implements MessageListener {
    private Gson gson;
    
    public ReceptionNouvelleAffaire() {
    }
    
    @Override
    public void onMessage(Message message) {
         if (message instanceof TextMessage) {
            try {
                String json = ((TextMessage) message).getText();

                Affaire affaire = this.gson.fromJson(json, Affaire.class);
                System.out.println("Received: " + affaire.getId());
                /*try {
                    
                    this.bourseBusiness.ajouterTitre(titre);
                    this.logDansJMS.sendLog(titre, "AJOUT");
                } catch (TitreExistantException ex) {
                    Logger.getLogger(ReceptionNouveauTitre.class.getName()).log(Level.SEVERE, null, ex);
                } catch (TitreIncorrectException ex) {
                    Logger.getLogger(ReceptionNouveauTitre.class.getName()).log(Level.SEVERE, null, ex);
                }
*/
            } catch (JMSException ex) {
                Logger.getLogger(ReceptionNouvelleAffaire.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (message != null) {
            System.out.println("Received non TitreBoursier message");
        }
    }
    
}
