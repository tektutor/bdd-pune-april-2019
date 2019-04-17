package org.tektutor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TrainingService {

    private Connection connection;
    private Training training;
    private ArrayList<Training> listOfTrainings;

    public TrainingService() {
        connection = new DatabaseConnectionManager().getConnection();
        listOfTrainings = new ArrayList<Training>();
    }

    public ArrayList<Training> getAllTrainings() {
        String sqlQuery = "select * from training";

        listOfTrainings.clear();

        try {
            PreparedStatement ps = connection.prepareStatement(sqlQuery);

            ResultSet rs = ps.executeQuery();

            while ( rs.next() ) {
                training = new Training();

                training.setId( rs.getInt(1) );
                training.setName( rs.getString(2) );
                training.setDuration( rs.getString(3) );

                listOfTrainings.add( training );
            }

        }
        catch ( Exception e) {
            e.printStackTrace();
        }

        return listOfTrainings;
        
    }
    
    public Training getTrainingById( int id) {
        String sqlQuery = "select * from training where id=" + id;

        try {
            PreparedStatement ps = connection.prepareStatement(sqlQuery);
            ResultSet rs = ps.executeQuery();

            if ( rs.next() ) {
                training = new Training();

                training.setId( rs.getInt(1) );
                training.setName( rs.getString(2) );
                training.setDuration( rs.getString(3) );
            }
        }
        catch ( Exception e) {
            e.printStackTrace();
        }

        return training;
        
    }

    public int updateTraining( Training training ) {

        String sqlQuery = "update training set name='" + training.getName()
            + "', duration='" + training.getDuration() + "' where id=" + training.getId();

        System.out.println ( sqlQuery );

        int status = -1;

        try {
            PreparedStatement ps = connection.prepareStatement(sqlQuery);
            status = ps.executeUpdate(sqlQuery);
        }
        catch ( Exception e) {
            e.printStackTrace();
        }

        return status;
        
    }

}
