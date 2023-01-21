package isi.idl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="conversionoperation")
public class ConversionOperation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private Long id;

	@Column(name="currency_from") 
	private String currency_from;

	@Column(name="currency_to") 
	private String currency_to;

	@Column(name="initial_amount")
	private Double initial_amount;
	
	@Column(name="converted_amount")
	private Double converted_amount;
	
	@Column(name="conversion_rate")
	private Double conversion_rate;

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

	public Double getInitial_amount() {
		return initial_amount;
	}

	public void setInitial_amount(Double initial_amount) {
		this.initial_amount = initial_amount;
	}

	public Double getConverted_amount() {
		return converted_amount;
	}

	public void setConverted_amount(Double converted_amount) {
		this.converted_amount = converted_amount;
	}

	public Double getConversion_rate() {
		return conversion_rate;
	}

	public void setConversion_rate(Double conversion_rate) {
		this.conversion_rate = conversion_rate;
	}

	public ConversionOperation(Long id, String currency_from, String currency_to, Double initial_amount,
			Double converted_amount, Double conversion_rate) {
		super();
		this.id = id;
		this.currency_from = currency_from;
		this.currency_to = currency_to;
		this.initial_amount = initial_amount;
		this.converted_amount = converted_amount;
		this.conversion_rate = conversion_rate;
	}

	public ConversionOperation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
