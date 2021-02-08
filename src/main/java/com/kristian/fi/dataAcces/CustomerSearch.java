package com.kristian.fi.dataAcces;

import com.kristian.fi.logger.Logger;
import com.kristian.fi.models.CustomerSearchResult;

import java.sql.*;
import java.util.*;

public class CustomerSearch {

    private final String URL = ConnectionHelper.CONNECTION_URL;
    private Connection conn = null;

    private final Logger logger = Logger.getInstance();
    private Object Q2Obj;

    /**
     * Customer Search*/
    public ArrayList<CustomerSearchResult> getCustomerSearch(String search){
        ArrayList<CustomerSearchResult> results = new ArrayList<>();

        
        try{
            // Connect to DB
            conn = DriverManager.getConnection(URL);
            Logger.log("Connection to SQLite has been established.");
            // Make SQL query
            String searchStatement="SELECT DISTINCT A2.Name as ArtistName,A.Title as AlbumName, Track.name as TrackName, Track.Composer as composer,G.Name as GenreName FROM Track join Album A on A.AlbumId = Track.AlbumId join Artist A2 on A2.ArtistId = A.ArtistId join Genre G on G.GenreId = Track.GenreId WHERE Track.Name=? COLLATE NOCASE or A2.Name=? COLLATE NOCASE or A.Title=? COLLATE NOCASE";
            PreparedStatement preparedStatement = conn.prepareStatement(searchStatement);
            preparedStatement.setString(1, search);
            // Execute Query
            ResultSet resultSet = preparedStatement.executeQuery();

            
            while (resultSet.next()) {

            results.add( new CustomerSearchResult(
                    search,
                    resultSet.getString("ArtistName"),
                    resultSet.getString("AlbumName"),
                    resultSet.getString("TrackName"),
                    resultSet.getString("composer"),
                    resultSet.getString("GenreName")));

            }
            Logger.log("fetching Customer Search results from SQL");
        }
        catch (Exception exception){
            Logger.log("Something went wrong Sorry");
            Logger.log(exception.toString());
        }
        finally {
            try {
                conn.close();
            }
            catch (Exception exception){
                Logger.log(exception.toString());
            }
        }

        return results;
    }


}
