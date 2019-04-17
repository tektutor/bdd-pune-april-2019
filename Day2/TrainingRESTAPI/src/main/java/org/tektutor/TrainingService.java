package org.tektutor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TrainingService {

    public ArrayList<Training> getAllTrainings( ) {

        ArrayList<Training> listOfTrainings = new ArrayList<Training>();
        
        String sqlQuery = "select * from training";
        Training training;

        try {
            Connection connection = 
                new DatabaseConnectionManager().getConnection();


            PreparedStatement statement = connection.prepareStatement(sqlQuery); 
            ResultSet rs = statement.executeQuery();

            while ( rs.next() ) {
                training = new Training();

                training.setId( rs.getInt(1) );
                training.setName ( rs.getString(2) );
                training.setDuration( rs.getString(3) );

                listOfTrainings.add ( training );
            }
        }
        catch ( Exception e) {
            e.printStackTrace();
        } 

        return listOfTrainings;

    }

}