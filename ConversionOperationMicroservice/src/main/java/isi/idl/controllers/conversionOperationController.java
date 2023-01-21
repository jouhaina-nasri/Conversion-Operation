package isi.idl.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import isi.idl.entity.ConversionOperation;
import isi.idl.services.conversionOperationService;
import pojo.Rate;
@RestController
@RequestMapping("/api")
public class conversionOperationController {
    @Autowired
    conversionOperationService service;

    @RequestMapping(method = RequestMethod.POST)
    public ConversionOperation create (@RequestBody ConversionOperation conv) {
        return service.create(conv);
    }

    @RequestMapping(method=RequestMethod.GET)
    public List<ConversionOperation> readAll() { return service.getALL(); 
}

    
    @RequestMapping(value="/conv_op" ,  method=RequestMethod.GET)
    public ConversionOperation convert(@RequestParam(name="currfrom") String currfrom , @RequestParam(name="currto") String currto ,@RequestParam(name="initialamount") Double initialamount  )
    {
    	
    	  ConversionOperation op = new ConversionOperation();
    	  try {
    		  URL oracle = new URL("http://localhost:8081/api/rate?currfrom="+currfrom+"&currto="+currto);
    	        URLConnection yc = oracle.openConnection();
    	        yc.setDoOutput(true);
    	        ((HttpURLConnection) yc).setRequestMethod("POST");
    	        yc.setRequestProperty("Content-Type", "application/json");

      		    OutputStream os = yc.getOutputStream();
      		    os.flush(); //tabaath req
    	        BufferedReader in = new BufferedReader(new InputStreamReader(
    	                                    yc.getInputStream()));
    	        String inputLine;
    	        System.out.println("Output from Server .... \n");
      		    String outputJson ="";
    	        while ((inputLine = in.readLine()) != null) 
    	        	{outputJson = inputLine;}
    	        
    	        in.close();
    	        
    		  Gson g = new Gson();
    		  Rate result = g.fromJson(outputJson,Rate.class);
    		  
              op.setConversion_rate(result.getRate()) ;
              op.setCurrency_from(currfrom) ;
              op.setCurrency_to(currto);
              op.setInitial_amount(initialamount);
              op.setConverted_amount(initialamount*result.getRate());
              service.create(op);
              
    		  //conn.disconnect();

    		   } catch (MalformedURLException e) {

    		  e.printStackTrace();

    		   } catch (IOException e) {

    		  e.printStackTrace();

    		  }

    	  return op ;
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}