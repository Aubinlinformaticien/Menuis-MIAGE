/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.menuismiage.api.expo.jms;

import fr.miage.toulouse.menuismiage.menuismiageshared.entities.Affaire;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;

/**
 *
 * @author aubin.sacco
 */
@Singleton
public class NouvelleAffaireJMS implements NouvelleAffaireJMSLocal {
    
    @Resource(mappedName = "NouvelleAffaireFile")
    private Queue nouvelleAffaireFile;
    /**
     * contexte JMS. Injection auto par serveur d'appli.
     */
    @Inject
    @JMSConnectionFactory("ConnectionFactory")
    private JMSContext context;

    @Override
    public void creerAffaire(Affaire affaire) {
       try {
            JMSProducer producer = context.createProducer();
            ObjectMessage mess = context.createObjectMessage();
            mess.setObject(affaire);
            context.createProducer().send(nouvelleAffaireFile, mess);
            System.out.println(affaire + " envoyé.");

        } catch (JMSException ex) {
            Logger.getLogger(NouvelleAffaireJMS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
}
