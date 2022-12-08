package com.crewmeister.cmcodingchallenge.business.impl;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crewmeister.cmcodingchallenge.business.CurrencyExchangeBusiness;
import com.crewmeister.cmcodingchallenge.model.CurrencyExchangeRates;
import com.crewmeister.cmcodingchallenge.repository.CurrencyExchangeRepository;

@Service("currencyExchangeBusiness")
public class CurrencyExchangeBusinessImpl implements CurrencyExchangeBusiness {

	@Autowired
	CurrencyExchangeRepository currencyExchRepository;
	
    private static final DecimalFormat df = new DecimalFormat("0.00");

	@Override
	public List<String> getAllCurrencies() {

		List<String> toCurrency=new ArrayList<String>();
		toCurrency=currencyExchRepository.findDistinctToCurrency();
		return toCurrency;
	}

	@Override
	public List<CurrencyExchangeRates> getAllExchangeRatesByDate() {
		List<CurrencyExchangeRates> allRates=currencyExchRepository.findByExchDate();
		return allRates;
	}

	@Override
	public List<CurrencyExchangeRates> getExchangeRatesByDate() {
		return null;
	}

	@Override
	public String getExchangeRateByDateAndToCurrency(String data, String toCurrency) throws ParseException {

		String result = null;
	    try {
			Date date = (new SimpleDateFormat("yyyy-mm-dd")).parse(data);

			result=currencyExchRepository.findByExchDateAndToCurrency(date,toCurrency);
		} catch (ParseException e) {
			throw new ParseException("Date parsing error", 0);
		}

		return result;
	}

	@Override
	public String getExchangeAmount(String req,double noOfCurr) {

		Double rate=Double.parseDouble(req);
		Double amount=noOfCurr/rate;
		
		return df.format(amount);
	}

}
