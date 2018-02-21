package io.dropwizard.archetypes.resources;


import io.dropwizard.archetypes.db.MySQL;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Path("/rent")
public class Car
{
    @GET
    @Path("/car/{cars}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCars(@PathParam("cars")String cars) throws SQLException
    {
        System.out.println(cars);
       List <String> list = new MySQL().getCars(cars);


        boolean b = false;

        String result = "getCars({\"cars\":[";
        for (String temp : list) {
            if (b == true) {
                result += ',';
            } else
                b = true;
            result += "\"" + temp + "\"";

        }
        result += "]})";
        return result;


    }

    @GET
    @Path("/city/{city}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCity(@PathParam("city")String city) throws SQLException
    {

        List <String> list = new MySQL().getCity(city);


        boolean b = false;

        String result = "getCity({\"city\":[";
        for (String temp : list) {
            if (b == true) {
                result += ',';
            } else
                b = true;
            result += "\"" + temp + "\"";

        }
        result += "]})";
        return result;


    }

    @GET
    @Path("/decity/{city}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getDeliverCity(@PathParam("city")String decity) throws SQLException
    {

        List <String> list = new MySQL().getDeCity(decity);


        boolean b = false;

        String result = "getDeCity({\"decity\":[";
        for (String temp : list) {
            if (b == true) {
                result += ',';
            } else
                b = true;
            result += "\"" + temp + "\"";

        }
        result += "]})";
        return result;


    }







}
