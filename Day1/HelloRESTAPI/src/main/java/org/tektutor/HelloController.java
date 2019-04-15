package org.tektutor;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/hello")
public class HelloController {

    private HelloService helloService = new HelloService();

    public HelloController() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("sayHello")
    public Hello sayHello() {
        return helloService.sayHello();
    }

}
