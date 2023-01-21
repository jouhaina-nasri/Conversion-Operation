package isi.idl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="conversionrate")
public class ConvertionRate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private Long id;

	@Column(name="currency_from") 
	private String currency_from;

	@Column(name="currency_to") 
	private String currency_to;

	@Column(name="rate")
	private Double rate;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="validity_startdate")
	private Date validity_startdate;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="validity_enddate")
	private Date validity_enddate;

	public ConvertionRate(Long id, String currency_from, String currency_to, Double rate, Date validity_startdate,
			Date validity_enddate) {
		super();
		this.id = id;
		this.currency_from = currency_from;
		this.currency_to = currency_to;
		this.rate = rate;
		this.validity_startdate = validity_startdate;
		this.validity_enddate = validity_enddate;
	}

	public ConvertionRate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCurrency_from() {
		return currency_from;
	}

	public void setCurrency_from(String currency_from) {
		this.currency_from = currency_from;
	}

	public String getCurrency_to() {
		return currency_to;
	}

	public void setCurrency_to(String currency_to) {
		this.currency_to = currency_to;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Date getValidity_startdate() {
		return validity_startdate;
	}

	public void setValidity_startdate(Date validity_startdate) {
		this.validity_startdate = validity_startdate;
	}

	public Date getValidity_enddate() {
		return validity_enddate;
	}

	public void setValidity_enddate(Date validity_enddate) {
		this.validity_enddate = validity_enddate;
	}
	
}
