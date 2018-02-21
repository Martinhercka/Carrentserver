package io.dropwizard.archetypes.db;

import io.dropwizard.archetypes.resources.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQL {

    private Connection conn;
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/car_rent";
    private String userName = "root";
    String password = "";


    public List<String> getCars(String category) throws SQLException {
        List<String> list = new ArrayList<String>();
        try {
            Class.forName(driver).newInstance();

            conn = DriverManager.getConnection(url, userName, password);
            String query = "SELECT cars from cars where category like '" + category + "'";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String cat = rs.getString("cars");

                list.add(cat);


                System.out.println(cat);
            }

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }


        return list;

    }

    public List<String> getCity(String city) throws SQLException {
        List<String> list = new ArrayList<String>();
        try {
            Class.forName(driver).newInstance();

            conn = DriverManager.getConnection(url, userName, password);
            String query = "SELECT city from city where city like'" + city + "'";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String cat = rs.getString("city");

                list.add(cat);


                System.out.println(cat);
            }

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }


        return list;

    }

    public List<String> getDeCity(String decity) throws SQLException {
        List<String> list = new ArrayList<String>();
        try {
            Class.forName(driver).newInstance();

            conn = DriverManager.getConnection(url, userName, password);
            String query = "SELECT city from city where city like'" + decity + "'";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String cat = rs.getString("city");

                list.add(cat);


                System.out.println(cat);
            }

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }


        return list;

    }

    public String setCity(String city)
    {
        List <String> list = new ArrayList<>();
        try
        {

            Class.forName(driver).newInstance();

            conn = DriverManager.getConnection(url, userName, password);
            String query = "INSERT into orders(PickPlace) VALUES (?)";
            PreparedStatement ps = conn.prepareStatement(query);
           ps.setString(1,city);

        int rowInserted = ps.executeUpdate();
        if(rowInserted > 0 )
            System.out.println("WAS ADDED");
            System.out.println(city);

        } catch (Exception ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }


        return city;

        }





}