package com.crewmeister.cmcodingchallenge.util;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import com.crewmeister.cmcodingchallenge.model.CurrencyExchangeRates;

public class CurrencyExchangeUtil {

	public static Map<Date,List<CurrencyExchangeRates>> getDatewiseData(List<CurrencyExchangeRates> currencyExchRates)
	{
    	Map<Date,List<CurrencyExchangeRates>> currencyMap=new ConcurrentHashMap<Date,List<CurrencyExchangeRates>>();

		for(CurrencyExchangeRates exch:currencyExchRates)
    	{
    		if(currencyMap!=null && currencyMap.containsKey(exch.getExchdate()))
    		{
    			CopyOnWriteArrayList<CurrencyExchangeRates> currencyExchRatesNew=new CopyOnWriteArrayList<CurrencyExchangeRates>();
    			currencyExchRatesNew.addAll(currencyMap.get(exch.getExchdate()));
    			currencyExchRatesNew.add(exch);
    			currencyMap.replace(exch.getExchdate(), currencyExchRatesNew);
    		}
    		else {
    			CopyOnWriteArrayList<CurrencyExchangeRates> currencyExchRatesNew=new CopyOnWriteArrayList();
    			currencyExchRatesNew.add(exch);
    		currencyMap.put(exch.getExchdate(), currencyExchRatesNew);
    		}
    	}
		return currencyMap;
		
    
	}
}
