/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.menuismiage.gestionaffairessca.expo.rest;

import fr.miage.toulouse.menuismiage.gestionaffairessca.core.services.ServiceAffairesLocal;
import fr.miage.toulouse.menuismiage.menuismiageshared.exceptions.AffaireInexistanteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author aubin.sacco
 */
@Path("rdv")
@RequestScoped
public class RdvResource {

    ServiceAffairesLocal serviceAffaires = lookupServiceAffairesLocal();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RdvResource
     */
    public RdvResource() {
    }

    /**
     * Retrieves representation of an instance of fr.miage.toulouse.menuismiage.gestionaffairessca.expo.rest.RdvResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        return Response.ok(this.serviceAffaires.listerRDVCommerciaux()).build();
    }

    /**
     * PUT method for updating or creating an instance of RdvResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    /**
     * PUT method for updating or creating an instance of AffairesResource
     * @param content representation for the resource
     * @return 200 + JSON de l'affaire
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postJson(String content) {
        try{
            return Response.ok(this.serviceAffaires.ajouterRdvCommercial(content)).build();
        }catch(AffaireInexistanteException ex){
            Logger.getLogger(AffaireInexistanteException.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
    }

    private ServiceAffairesLocal lookupServiceAffairesLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (ServiceAffairesLocal) c.lookup("java:global/GestionAffaireSCA-ear/GestionAffaireSCA-ejb-1.0-SNAPSHOT/ServiceAffaires!fr.miage.toulouse.menuismiage.gestionaffairessca.core.services.ServiceAffairesLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    
}
