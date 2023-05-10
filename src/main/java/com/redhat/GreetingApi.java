package com.redhat;

import org.jboss.logging.annotations.Param;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import java.util.List;

@ApplicationScoped
@Path("/greeting")
public class GreetingApi {

    @POST
    @Transactional
    public Greeting addGreeting(Greeting greeting) {

        greeting.persist();
        return greeting;
    }

    @GET
    public List<Greeting> allGreetings() {
        return Greeting.listAll();
    }

    @PATCH
    @Path("/{id}")
    @Transactional
    public Greeting updateGreeting(@PathParam("id") Long id, Greeting updatedGreeting) {

        Greeting greetingToUpdate = Greeting.findById(id);
        greetingToUpdate.setText(updatedGreeting.text);
        greetingToUpdate.persist();
        return greetingToUpdate;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void updateGreeting(@PathParam("id") Long id) {

        Greeting.findById(id).delete();
    }

}
