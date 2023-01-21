package isi.idl.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import isi.idl.entity.ConvertionRate;
import isi.idl.services.convertionRateService;



@RestController
@RequestMapping("/api")
public class convertionRateController {
	
    @Autowired
    convertionRateService service;

    @RequestMapping(method = RequestMethod.POST)
    public ConvertionRate create (@RequestBody ConvertionRate conv) {
        return service.create(conv);
    }

    @RequestMapping( method=RequestMethod.GET)
    public List<ConvertionRate> readAll() { return service.getALL(); }
    
    @RequestMapping(value="/rate" ,  method=RequestMethod.POST)
    public ConvertionRate getRate(@RequestParam(name="currfrom") String currfrom , @RequestParam(name="currto") String currto  )
    { return service.getRate(currfrom , currto); }


}
