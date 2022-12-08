package com.crewmeister.cmcodingchallenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crewmeister.cmcodingchallenge.business.CurrencyExchangeBusiness;
import com.crewmeister.cmcodingchallenge.model.CurrencyConversionRates;
import com.crewmeister.cmcodingchallenge.model.CurrencyExchangeRates;
import com.crewmeister.cmcodingchallenge.util.CurrencyExchangeUtil;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.validation.ConstraintViolationException;

@RestController()
@RequestMapping("/api")
public class CurrencyController {

	@Autowired 
	CurrencyExchangeBusiness currencyExchangeBusiness;
	
    @GetMapping("/currencies")
    public ResponseEntity<List<String>> getCurrencies() {
		
    	List<String> currencyExchRates=currencyExchangeBusiness.getAllCurrencies();
    	if(currencyExchRates!=null)
    		return new ResponseEntity<List<String>>(currencyExchRates, HttpStatus.OK);
        else
			throw new NoSuchElementException("No Records Found");

    }
    
    @GetMapping("/allExchangeRates")
    public ResponseEntity<Map<Date, List<CurrencyExchangeRates>>> getAllExchangeRates() {
		
    	List<CurrencyExchangeRates> currencyExchRates=currencyExchangeBusiness.getAllExchangeRatesByDate();
    	Map<Date,List<CurrencyExchangeRates>> currencyMap=new ConcurrentHashMap<Date,List<CurrencyExchangeRates>>();
    	if(currencyExchRates!=null)
    	currencyMap=CurrencyExchangeUtil.getDatewiseData(currencyExchRates);
    	if(currencyMap!=null)
    		return new ResponseEntity<Map<Date,List<CurrencyExchangeRates>>>(currencyMap, HttpStatus.OK);
    	else
			throw new NoSuchElementException("No Records Found");

    }
    
    @GetMapping("/getExchangeRatesByDate/{date}")
    public ResponseEntity<String> getExchangeRatesByDate(@PathVariable(required=true,name="date") String data,
            @RequestParam(required=true) Map<String,String> qparams) throws ParseException {
    	if(data==null || qparams.isEmpty() )
    		throw new ConstraintViolationException("Parameters Missing",null);
	
    	String toCurrency=qparams.get("toCurrency");
    	String currencyExchRates=null;
    			currencyExchRates=	currencyExchangeBusiness.getExchangeRateByDateAndToCurrency(data,toCurrency);
		if(currencyExchRates!=null)
			return new ResponseEntity<String>(currencyExchRates, HttpStatus.OK);
		else
			throw new NoSuchElementException("No Records Found");
    }
    @PostMapping("/getExchangeAmountByDate")
    public ResponseEntity<String> getExchangeAmountByDate(@RequestBody CurrencyConversionRates req) throws ParseException {
    	if(req.getDate()==null || req.getCurrency()==null )
    		throw new ConstraintViolationException("Parameters not valid",null);
		String result=currencyExchangeBusiness.getExchangeRateByDateAndToCurrency(req.getDate(),req.getCurrency());
		String currencyExchRates=null;
		if(result!=null)
		currencyExchRates=currencyExchangeBusiness.getExchangeAmount(result,req.getCurrenciesToConvert());
		if(currencyExchRates!=null) {
			return new ResponseEntity<String>(currencyExchRates, HttpStatus.OK);
			
			  } 
		throw new NoSuchElementException("No Records Found");
			 
    }
	
}
