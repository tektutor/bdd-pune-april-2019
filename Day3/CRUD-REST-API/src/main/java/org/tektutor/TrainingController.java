package org.tektutor;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("trainings")
public class TrainingController {

    private TrainingService trainingService;

    public TrainingController() {
        trainingService = new TrainingService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public ArrayList<Training> getAllTrainings() {
        return trainingService.getAllTrainings();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Training getTrainingById(@PathParam("id") int id ) {
        return trainingService.getTrainingById(id);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public int updateTraining (Training training) {
            return trainingService.updateTraining(training);
    }

}   
