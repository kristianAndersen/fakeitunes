package com.kristian.fi.dataAcces;

import com.kristian.fi.models.*;
import com.kristian.fi.logger.Logger;

import java.sql.*;
import java.util.ArrayList;

public class CustomerRepository {

    private final String URL = ConnectionHelper.CONNECTION_URL;
    private Connection conn = null;

    private final Logger logger = Logger.getInstance();

/**
 * Get 5 random Genres*/
public ArrayList<String> getFiveRandGenres(){
    ArrayList<String> fiveRandom = new ArrayList<>();
    try{
        // Connect to DB
        conn = DriverManager.getConnection(URL);
        Logger.log("Connection to SQLite has been established.");

        // Make SQL query
        String fiveRandomGenres="SELECT DISTINCT * FROM (SELECT DISTINCT Name as Genres FROM Genre ORDER BY random() LIMIT 5) order by random() LIMIT 5";
        PreparedStatement preparedStatement = conn.prepareStatement(fiveRandomGenres);

        // Execute Query
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            fiveRandom.add(resultSet.getString("Genres") );
        }
        Logger.log("Selected Five Random Genres successful");
    }
    catch (Exception exception){
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
    return fiveRandom;
}


    /**
     * Get 5 random Artists*/
    public ArrayList<String> getFiveRandArtists(){
        ArrayList<String> fiveRandom = new ArrayList<>();
        try{
            // Connect to DB
            conn = DriverManager.getConnection(URL);
            Logger.log("Connection to SQLite has been established.");

            // Make SQL query
            String fiveRandomGenres="SELECT DISTINCT * FROM (SELECT DISTINCT Name as Artists FROM Artist ORDER BY random() LIMIT 5) order by random() LIMIT 5";
            PreparedStatement preparedStatement = conn.prepareStatement(fiveRandomGenres);

            // Execute Query
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                fiveRandom.add(resultSet.getString("Artists") );
            }
            Logger.log("Selected Five Random Artists successful");
        }
        catch (Exception exception){
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
        return fiveRandom;
    }

    /**
     * Get 5 random Songs*/
    public ArrayList<String> getFiveRandSongs(){
        ArrayList<String> fiveRandom = new ArrayList<>();
        try{
            // Connect to DB
            conn = DriverManager.getConnection(URL);
            Logger.log("Connection to SQLite has been established.");

            // Make SQL query
            String fiveRandomGenres="SELECT DISTINCT * FROM (SELECT DISTINCT Name as Songs FROM Track ORDER BY random() LIMIT 5) order by random() LIMIT 5";
            PreparedStatement preparedStatement = conn.prepareStatement(fiveRandomGenres);

            // Execute Query
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                fiveRandom.add(resultSet.getString("Songs") );
            }
            Logger.log("Selected Five Random Songs successful");
        }
        catch (Exception exception){
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
        return fiveRandom;
    }


/**
 * Get all customers from DB*/
    public ArrayList<Customer> getAllCustomers(){
        ArrayList<Customer> customers = new ArrayList<>();
        try{
            // Connect to DB
            conn = DriverManager.getConnection(URL);
            Logger.log("Connection to SQLite has been established.");

            // Make SQL query
            String apiAllCustomers="select CustomerId, FirstName, LastName, Country, PostalCode,Phone,Email from customer";
            PreparedStatement preparedStatement = conn.prepareStatement(apiAllCustomers);

            // Execute Query
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                customers.add(
                        new Customer(
                                resultSet.getString("CustomerId"),
                                resultSet.getString("FirstName"),
                                resultSet.getString("LastName"),
                                resultSet.getString("Country"),
                                resultSet.getString("PostalCode"),
                                resultSet.getString("Phone"),
                                resultSet.getString("Email")));
            }
            Logger.log("Selected all customers successful");
        }
        catch (Exception exception){
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
        return customers;
    }

/**Insert new Customer into DB*/
public Boolean addCustomer(Customer customer){
    boolean success = false;
    try{
        // Connect to DB
        conn = DriverManager.getConnection(URL);
        Logger.log("Connection to SQLite has been established.");

        // Make SQL query
        String apiAddNewCustomer="INSERT INTO customer(CustomerId,FirstName, LastName, Country, PostalCode,Phone,Email) VALUES(?,?,?,?,?,?,?)";

        PreparedStatement preparedStatement = conn.prepareStatement(apiAddNewCustomer);
        preparedStatement.setString(1,customer.getCustomerId());
        preparedStatement.setString(2,customer.getFirstName());
        preparedStatement.setString(3,customer.getLastName());
        preparedStatement.setString(4,customer.getCountry());
        preparedStatement.setString(5,customer.getPostalCode());
        preparedStatement.setString(6,customer.getPhone());
        preparedStatement.setString(7,customer.getEmail());

        // Execute Query
        int result = preparedStatement.executeUpdate();
        success = (result != 0);
        Logger.log("Added a new customer successful");
    }
    catch (Exception exception){

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
    return success;
}

    /**Update Customer in DB*/
    public Boolean updateCustomer(Customer customer){
        boolean success = false;

        try{
            // Connect to DB
            conn = DriverManager.getConnection(URL);
            Logger.log("Connection to SQLite has been established. ready to update");

            // Make SQL query
            String updateCustomer="UPDATE customer SET  CustomerId = ?, FirstName=?, LastName=?, PostalCode=?,Phone=?,Email=? where CustomerId = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(updateCustomer);
            preparedStatement.setString(1,customer.getCustomerId());
            preparedStatement.setString(2,customer.getFirstName());
            preparedStatement.setString(3,customer.getLastName());
            preparedStatement.setString(4,customer.getPostalCode());
            preparedStatement.setString(5,customer.getPhone());
            preparedStatement.setString(6,customer.getEmail());
            preparedStatement.setString(7,customer.getCustomerId());
            // Execute Query
            int result = preparedStatement.executeUpdate();
            success = (result != 0);
            Logger.log("Updated a current customer successful");
        }
        catch (Exception exception){
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
        return success;
    }

/**Get Customers in Country*
 * */
public ArrayList<CustomerInCountry> getCustomersinCountry(){
    ArrayList<CustomerInCountry> customerInCountry = new ArrayList<>();
    try{
        // Connect to DB
        conn = DriverManager.getConnection(URL);
        Logger.log("Connection to SQLite has been established.");

        // Make SQL query
        String apiHighestNumberOfCustomers= "select i.Country, sum(CustomerId) as 'Total' from Customer as i group by Country order by total desc";
        PreparedStatement preparedStatement = conn.prepareStatement(apiHighestNumberOfCustomers);

        // Execute Query
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {

            customerInCountry.add(
                    new CustomerInCountry(
                            resultSet.getString("Country"),
                            resultSet.getString("Total")));
        }
        Logger.log("Got all customers from Country");
    }
    catch (Exception exception){
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
    return customerInCountry;
}

/**Get Highest Spending Customers*
 * */
public ArrayList<CustomerHighSpender> getHighestSpender(){
    ArrayList<CustomerHighSpender> customerHighSpender = new ArrayList<>();
    try{
        // Connect to DB
        conn = DriverManager.getConnection(URL);
        Logger.log("Connection to SQLite has been established.");

        // Make SQL query
        String apiHighestSpendCustomer=  "SELECT c.FirstName, c.LastName, total(round(i.Total)) TotalSpent FROM Customer c JOIN Invoice i ON c.CustomerId = i.CustomerId GROUP BY c.CustomerId order by TotalSpent desc";
        PreparedStatement preparedStatement = conn.prepareStatement(apiHighestSpendCustomer);
        // Execute Query
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {

            customerHighSpender.add(
                    new CustomerHighSpender(
                            resultSet.getString("FirstName"),
                            resultSet.getString("LastName"),
                            resultSet.getString("TotalSpent")));
        }
        Logger.log("Now we know who the big spender is");
    }
    catch (Exception exception){
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
    return customerHighSpender;
}

    /**Get specific Customers favorite genre and thanks to Sean for the SQL query*
     * */
   public  ArrayList<CustomerGenre> getCustomerGenre(String id) {
        ArrayList<CustomerGenre> customerGenre = new ArrayList<>();
        try{
            // Connect to DB
            conn = DriverManager.getConnection(URL);
            Logger.log("Connection to SQLite has been established.");

            // Make SQL query
            String  apiCustomerFavorite="WITH CountQuery AS (SELECT c.FirstName, c.LastName, g.Name, count(g.GenreId) as GenreCount FROM Customer AS c JOIN Invoice AS iv ON iv.CustomerId = c.CustomerId JOIN InvoiceLine AS il ON il.InvoiceId = iv.InvoiceId JOIN Track AS t ON t.TrackId = il.TrackId JOIN Genre AS g ON g.GenreId = t.GenreId WHERE c.CustomerId=? GROUP BY g.GenreId ORDER BY GenreCount) SELECT Name, GenreCount FROM CountQuery WHERE (SELECT MAX(GenreCount) from CountQuery) = GenreCount";
            PreparedStatement preparedStatement = conn.prepareStatement(apiCustomerFavorite);
            preparedStatement.setString(1,id);
            // Execute Query
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                customerGenre.add(
                        new CustomerGenre(

                                resultSet.getString("Name"),
                                resultSet.getString("GenreCount")
                        )
                );
            }

            Logger.log("Selected customer favorite genre");
        }
        catch (Exception exception){
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
        return customerGenre;
    }


}
