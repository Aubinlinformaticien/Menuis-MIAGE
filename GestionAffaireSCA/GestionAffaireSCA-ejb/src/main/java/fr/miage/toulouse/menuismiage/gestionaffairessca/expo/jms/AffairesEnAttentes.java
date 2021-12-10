/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.menuismiage.gestionaffairessca.expo.jms;

import fr.miage.toulouse.menuismiage.menuismiageshared.entities.Affaire;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.ObjectMessage;
import javax.jms.Topic;

/**
 *
 * @author aubin.sacco
 */
@Stateless
public class AffairesEnAttentes implements AffairesEnAttentesLocal {
    /**
     * Nom du Topic recherché.
     */
    @Resource(mappedName = "AffairesEnAttentes")
    private Topic affaireEnAttentes;
    /**
     * contexte JMS. Injection auto par serveur d'appli.
     */
    @Inject
    @JMSConnectionFactory("ConnectionFactory")
    private JMSContext context;
    
    @Override
    public void propositionRdvCommercialJMS(Affaire a, String etat) {
        try {
            JMSProducer producer = context.createProducer();

            ObjectMessage mess = context.createObjectMessage();
            mess.setJMSType(etat);
            mess.setObject(a);
            context.createProducer().send(affaireEnAttentes, mess);
            System.out.println(a + " envoyé.");

        } catch (JMSException ex) {
            Logger.getLogger(AffairesEnAttentes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
