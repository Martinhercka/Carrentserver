package io.dropwizard.archetypes.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQL
{

    private Connection conn;
    private String driver = "com.mysql.jdbc.Driver";
    private String url =  "jdbc:mysql://localhost:3306/car_rent";
    private String userName = "root";
    String password = "";


    public List<String> getCars() throws SQLException {
        List<String> list = new ArrayList<String>();
        try {
            Class.forName(driver).newInstance();

            conn = DriverManager.getConnection(url,userName,password);
            String query ="SELECT CarID,Brand from cars";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs=ps.executeQuery();

            while(rs.next())
            {
                String name = rs.getString("brand");

                list.add(name);


                System.out.println(name);
            }

        }catch(Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }







    return list;

    }



    public List<String> getPickUpCity() throws SQLException {
        List<String> list = new ArrayList<String>();
        try {
            Class.forName(driver).newInstance();

            conn = DriverManager.getConnection(url,userName,password);
            String query ="SELECT City from Pickup";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs=ps.executeQuery();

            while(rs.next())
            {
                String name = rs.getString("City");

                list.add(name);


                System.out.println(name);
            }

        }catch(Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }







        return list;

    }



    public String setCar(String brand) throws SQLException {
        List<String> list = new ArrayList<>();
        try {
            Class.forName(driver).newInstance();
            System.out.println(getCars());
            conn = DriverManager.getConnection(url,userName,password);
            String query ="INSERT into orders(Idcar) VALUES(?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,brand);
            int rowsInserted = ps.executeUpdate();
            if(rowsInserted > 0)
                System.out.println("A new values was inserted!");
            System.out.println(brand);


        }catch(Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }


        return brand;
    }



}
