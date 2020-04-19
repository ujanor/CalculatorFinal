package com.madhumanti.calculator;

import java.util.Date;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
public class CalculatorResponse {

   
    int _result;
    String _time;
    String expression;

    public CalculatorResponse(String s) {
        
    	expression = s;
        _time = new Date().toString();
    }
   
   
    public int getResult() {
        return _result;
    }

    public String getTime() {
        return _time;
    }
    boolean isOperand(char c)  
    {  
        return (c >= '0' && c <= '9');  
          
    }  
      
    // utility function to find value of and operand  
    public String evaluate() 
    { 
    	ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        Object k;
		try {
			k = (Object) engine.eval(expression);
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			return "Invalid expression";
		}
        return k+"";
    } 
  
}
