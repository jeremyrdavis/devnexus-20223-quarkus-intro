package com.redhat;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.net.URI;

@ApplicationScoped
@Path("/jaxrsgreeting")
public class JAXRSApi {

    @POST
    @Transactional
    public Response addGreeting(Greeting greeting) {

        greeting.persist();
        return Response.created(URI.create("/" + greeting.id)).entity(greeting).build();
    }

}
