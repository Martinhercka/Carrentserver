package io.dropwizard.archetypes.db;

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
}