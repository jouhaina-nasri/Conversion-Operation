package isi.idl.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.idl.entity.ConversionOperation;
import isi.idl.repository.conversionOperationRepo;



@Service
public class conversionOperationService {
    @Autowired
    public conversionOperationRepo repo;

    public ConversionOperation create (ConversionOperation conv) {
        return repo.save(conv);
    }
    //READ
    public List<ConversionOperation> getALL() {
        return repo.findAll();
        }
}

