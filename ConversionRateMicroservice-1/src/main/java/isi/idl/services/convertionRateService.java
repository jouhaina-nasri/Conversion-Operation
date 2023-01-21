package isi.idl.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.idl.entity.ConvertionRate;
import isi.idl.repository.convertionRateRepository;
@Service
public class convertionRateService {
    @Autowired
    public convertionRateRepository repo;

    public ConvertionRate create (ConvertionRate conv) {
        return repo.save(conv);
    }
    //READ
    public List<ConvertionRate> getALL() {
        return repo.findAll();
        }
    
    public ConvertionRate getRate(String currfrom , String currto)
    {
    	return repo.getRate(currfrom, currto, new Date());
    }
}
