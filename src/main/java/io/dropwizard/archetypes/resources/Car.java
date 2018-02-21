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

@Path("/cars")
public class Car
{
    @GET
    @Path("/car")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCars() throws SQLException {
        MySQL mysql = new MySQL();
        List<String> list = mysql.getCars();


        boolean b = false;

        String result = "ajaxRequest({\"brand\":[";
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
    @Path("/cars/{brand}")
    @Produces(MediaType.APPLICATION_JSON)
    public String setCar(@PathParam("brand") String brand) throws SQLException {
        System.out.println(brand);
        List<String> list = Collections.singletonList(new MySQL().setCar(brand));


        boolean c = false;

        String result = "getCar({\"name\":[";
        for (String temp : list) {
            if (c == true) {
                result += ',';
            } else
                c = true;
            result += "\"" + temp + "\"";

        }
        result += "]})";
        return result;
    }



}
