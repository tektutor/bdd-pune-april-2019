package org.tektutor;

public class HelloService {

    private Hello hello = new Hello("Hello REST API!");

    public HelloService() {
    }

    public Hello sayHello() {
        return hello;
    }

}
