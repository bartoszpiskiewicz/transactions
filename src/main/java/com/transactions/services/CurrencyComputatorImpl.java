package com.transactions.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Bartosz Piśkiewicz on 19.05.2017.
 */
@Service
public class CurrencyComputatorImpl implements CurrencyComputator {

    private CurrencyFetcher fetcher;

    @Autowired
    public CurrencyComputatorImpl(CurrencyFetcher fetcher) {
        this.fetcher = fetcher;
    }

    @Override
    public double fetchCourse(String fromCurrency, String toCurrency) {



        return 0;
    }
}
