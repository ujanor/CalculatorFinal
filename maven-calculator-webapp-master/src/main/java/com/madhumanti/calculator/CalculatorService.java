package com.madhumanti.calculator;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Date;

@Path("/calculator")
public class CalculatorService {

    @GET
    @Path("ping")
    @Produces(MediaType.TEXT_PLAIN)
    public String ping() {
        return "Welcome to Java Maven Calculator Web App!!!\n" + new Date().toString();
    }

    @POST
    @Path("calculate")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String calculate(String s) throws ParseException {
    	JSONObject jObj =(JSONObject)new JSONParser().parse(s);
    	CalculatorResponse c=new CalculatorResponse(jObj.get("data").toString());
        String m=c.evaluate();
    	return m;
    }
}
