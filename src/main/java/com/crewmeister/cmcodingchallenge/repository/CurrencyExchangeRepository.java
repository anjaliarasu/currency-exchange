package com.crewmeister.cmcodingchallenge.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crewmeister.cmcodingchallenge.model.CurrencyExchangeRates;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchangeRates, Integer>{

	@Query("select distinct exch.toCurrency from CurrencyExchangeRates exch")
	public List<String> findDistinctToCurrency();

	@Query("select exch from CurrencyExchangeRates exch group by exch.exchdate,exch.id")
	public List<CurrencyExchangeRates> findByExchDate();

	@Query("select exch.rate from CurrencyExchangeRates exch where exch.exchdate=:dateparam and exch.toCurrency=:toCurrency")
	public String findByExchDateAndToCurrency(Date dateparam, String toCurrency);

	
	
}
