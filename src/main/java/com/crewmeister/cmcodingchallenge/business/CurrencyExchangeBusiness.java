package com.crewmeister.cmcodingchallenge.business;

import java.text.ParseException;
import java.util.List;
import com.crewmeister.cmcodingchallenge.model.CurrencyExchangeRates;

public interface CurrencyExchangeBusiness {

	public List<String> getAllCurrencies();

	public List<CurrencyExchangeRates> getAllExchangeRatesByDate();

	public List<CurrencyExchangeRates> getExchangeRatesByDate();

	public String getExchangeRateByDateAndToCurrency(String data, String toCurrency) throws ParseException;

	public String getExchangeAmount(String result, double d);
}
