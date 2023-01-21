package isi.idl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isi.idl.entity.ConversionOperation;




@Repository
public interface conversionOperationRepo extends JpaRepository<ConversionOperation, Long> {
	
}