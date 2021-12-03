/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse;

//import fr.miage.toulouse.menuismiage.api.services.ServiceAffaireLocal;
import fr.miage.toulouse.menuismiage.api.services.ServiceAffaireLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.enterprise.context.RequestScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author aubin.sacco
 */
@Path("affaires")
@RequestScoped
public class AffairesResource {
    
    
    ServiceAffaireLocal serviceAffaire = lookupServiceAffaireLocal();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AffairesResource
     */
    public AffairesResource() {
    }

    /**
     * Retrieves representation of an instance of fr.miage.toulouse.AffairesResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of AffairesResource
     * @param content representation for the resource
     * @return 
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response putJson(String content) {
        //this.serviceAffaire.ajouterAffaire(content);
        return Response.ok().build();
    }

    private fr.miage.toulouse.menuismiage.api.services.ServiceAffaireLocal lookupServiceAffaireLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (fr.miage.toulouse.menuismiage.api.services.ServiceAffaireLocal) c.lookup("java:global/API-ear/API-ejb-1.0-SNAPSHOT/ServiceAffaire");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    
}
