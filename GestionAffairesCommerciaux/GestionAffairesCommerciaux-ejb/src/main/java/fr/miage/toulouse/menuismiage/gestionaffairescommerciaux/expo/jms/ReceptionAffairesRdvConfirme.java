/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.menuismiage.gestionaffairescommerciaux.expo.jms;

import com.google.gson.Gson;
import fr.miage.toulouse.menuismiage.gestionaffairescommerciaux.core.services.ServiceAffairesLocal;
import fr.miage.toulouse.menuismiage.menuismiageshared.entities.Affaire;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 *
 * @author aubin.sacco
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "AffairesRdvConfirmeTopic")
    ,
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "AffairesRdvConfirmeTopic")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "AffairesRdvConfirmeTopic")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class ReceptionAffairesRdvConfirme implements MessageListener {
    
    @EJB
    private ServiceAffairesLocal serviceAffaires;
    
    private Gson gson;
    
    public ReceptionAffairesRdvConfirme() {
        this.gson = new Gson();
    }
    
    @Override
    public void onMessage(Message message) {
if (message instanceof ObjectMessage) {
            try {
                Affaire affaire = (Affaire) ((ObjectMessage) message).getObject();
                this.serviceAffaires.ajouterAffaire(affaire);
                     
                System.out.println((this.gson.toJson(affaire)));

            } catch (JMSException ex) {
                Logger.getLogger(ReceptionAffairesRdvConfirme.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (message != null) {
            System.out.println("Received non TitreBoursier message");
        }
    }
    
}
