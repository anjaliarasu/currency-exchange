package com.crewmeister.cmcodingchallenge.model;

public class CurrencyConversionRates {
    public CurrencyConversionRates(String date, String currency, double currenciesToConvert) {
		super();
		this.date = date;
		this.currency = currency;
		this.currenciesToConvert = currenciesToConvert;
	}

	private double conversionRate;
    
    private String date;
    
    private String currency;
    
    private double currenciesToConvert;

    public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getCurrenciesToConvert() {
		return currenciesToConvert;
	}

	public void setCurrenciesToConvert(double currenciesToConvert) {
		this.currenciesToConvert = currenciesToConvert;
	}

	public CurrencyConversionRates(double conversionRate) {
        this.conversionRate = conversionRate;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }
}
