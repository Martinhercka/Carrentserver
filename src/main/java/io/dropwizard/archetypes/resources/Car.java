package io.dropwizard.archetypes.resources;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.archetypes.db.MySQL;

import javax.ws.rs.*;
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

        List <String> list = Collections.singletonList(new MySQL().setCity(city));


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
        System.out.println(decity);

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


    @GET

    @Path("/info{firstname}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfo(@PathParam ("firstname")String firstname) throws SQLException
    {
        System.out.println(firstname);

        String result = "getDeCity({\"decity\":[";
        result += "]})";
        return result;






    }









}
