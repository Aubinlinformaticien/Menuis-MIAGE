/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.menuismiage.gestionplanningcommerciaux.expo.rest;

import fr.miage.toulouse.menuismiage.gestionplanningcommerciaux.core.services.ServiceAffairesLocal;
import fr.miage.toulouse.menuismiage.menuismiageshared.exceptions.AffaireInexistanteException;
import fr.miage.toulouse.menuismiage.menuismiageshared.exceptions.StatutAffaireInvalide;
import java.util.Properties;
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
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author aubin.sacco
 */
@Path("affaires/{id}/statut")
@RequestScoped
public class AffairesStatutResource {

    ServiceAffairesLocal serviceAffaires = lookupServiceAffairesLocal();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AffairesStatutResource
     */
    public AffairesStatutResource() {
    }

    /**
     * Retrieves representation of an instance of fr.miage.toulouse.menuismiage.gestionplanningcommerciaux.expo.rest.AffairesStatutResource
     * @param id resource URI parameter
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("id") String id) {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of AffairesStatutResource
     * @param id resource URI parameter
     * @param content representation for the resource
     * @return 
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response putJson(@PathParam("id") String id, String content) {
        try{
            return Response.ok(this.serviceAffaires.modifierStatut(id, content)).build();
        } catch (StatutAffaireInvalide ex){
            Logger.getLogger(AffairesStatutResource.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        } catch (AffaireInexistanteException ex){
            Logger.getLogger(AffaireInexistanteException.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
    }

    private ServiceAffairesLocal lookupServiceAffairesLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (ServiceAffairesLocal) c.lookup("java:global/GestionPlanningCommerciaux-ear/GestionPlanningCommerciaux-ejb-1.0-SNAPSHOT/ServiceAffaires");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
