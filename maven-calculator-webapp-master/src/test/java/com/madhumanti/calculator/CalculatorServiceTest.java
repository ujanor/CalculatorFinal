package com.madhumanti.calculator;

import org.junit.Test;

import com.madhumanti.calculator.CalculatorService;

import static org.junit.Assert.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import static org.hamcrest.CoreMatchers.*;

public class CalculatorServiceTest {

    @Test
    public void testPing() {
        assertThat(new CalculatorService().ping(), containsString("Welcome to Java Maven Calculator Web App!!!"));
    }

    @Test
    public void testCalculate() throws ParseException {
    	JSONObject jo = new JSONObject(); 
    	jo.put("data", "1+2");
        assertEquals("3", new CalculatorService().calculate(jo.toJSONString()));
    }

}
