package isi.idl.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import isi.idl.entity.ConvertionRate;


@Repository
public interface convertionRateRepository extends JpaRepository<ConvertionRate, Long> {
	
	@Query("SELECT c FROM ConvertionRate c WHERE c.currency_from = ?1 and c.currency_to = ?2 and ?3 BETWEEN c.validity_startdate AND c.validity_enddate")
	ConvertionRate getRate(String curFrom ,String curTo , Date date );

}