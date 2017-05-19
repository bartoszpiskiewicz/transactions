package com.transactions.services;

/**
 * Created by Bartosz Piśkiewicz on 19.05.2017.
 */
public interface CurrencyComputator {

    double fetchCourse(String fromCurrency, String toCurrency);

}
