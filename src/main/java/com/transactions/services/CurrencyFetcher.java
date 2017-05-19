package com.transactions.services;

import java.util.Currency;

/**
 * Created by Bartosz Piśkiewicz on 19.05.2017.
 */
public interface CurrencyFetcher {

    double fetchCurrencyCourse(String currency);
}
