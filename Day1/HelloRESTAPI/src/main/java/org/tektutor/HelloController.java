package org.tektutor;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("hello")
public class HelloController {

    HelloService helloService = new HelloService();

    @Produces(MediaType.APPLICATION_JSON)
    public Hello sayHello() {
        return helloService.sayHello();
    }

}