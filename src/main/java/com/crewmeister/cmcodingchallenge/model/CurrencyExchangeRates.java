package com.crewmeister.cmcodingchallenge.model;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="CURRENCYEXCHANGERATES")
public class CurrencyExchangeRates {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="FROMCURRENCY")
	private String fromCurrency;
	@Column(name="TOCURRENCY")
	private String toCurrency;
	@Column(name="EXCHDATE")
	private Date exchdate;
	@Column(name="RATE")
	private BigDecimal rate;
	
	
	public String getFromCurrency() {
		return fromCurrency;
	}
	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}
	public String getToCurrency() {
		return toCurrency;
	}
	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}

	public Date getExchdate() {
		return exchdate;
	}
	public void setExchdate(Date exchdate) {
		this.exchdate = exchdate;
	}
	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
