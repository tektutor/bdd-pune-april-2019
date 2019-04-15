package org.tektutor;

public class Hello {

    private String message;

    public Hello() { 
	message = "Hello REST API!";
    }

    public Hello( String message ) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage ( String message ) {
        this.message = message;
    }

}
