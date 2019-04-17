package org.tektutor;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("trainings")
public class TrainingController {

    private TrainingService trainingService = new TrainingService();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public ArrayList<Training> getAllTrainings() {
        return trainingService.getAllTrainings();
    }

}