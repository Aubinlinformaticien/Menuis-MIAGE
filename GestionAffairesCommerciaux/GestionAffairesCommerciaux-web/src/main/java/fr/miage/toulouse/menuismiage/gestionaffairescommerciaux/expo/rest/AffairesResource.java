/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.menuismiage.gestionaffairescommerciaux.expo.rest;

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

    fr.miage.toulouse.menuismiage.gestionaffairescommerciaux.core.services.ServiceAffairesLocal serviceAffaires = lookupServiceAffairesLocal();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AffairesResource
     */
    public AffairesResource() {
    }

    /**
     * Retrieves representation of an instance of fr.miage.toulouse.menuismiage.gestionaffairescommerciaux.expo.rest.AffairesResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        return Response.ok(this.serviceAffaires.listerAffaires()).build();
    }

    /**
     * PUT method for updating or creating an instance of AffairesResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

    private fr.miage.toulouse.menuismiage.gestionaffairescommerciaux.core.services.ServiceAffairesLocal lookupServiceAffairesLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (fr.miage.toulouse.menuismiage.gestionaffairescommerciaux.core.services.ServiceAffairesLocal) c.lookup("java:global/GestionAffairesCommerciaux-ear/GestionAffairesCommerciaux-ejb-1.0-SNAPSHOT/ServiceAffaires!fr.miage.toulouse.menuismiage.gestionaffairescommerciaux.core.services.ServiceAffairesLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
