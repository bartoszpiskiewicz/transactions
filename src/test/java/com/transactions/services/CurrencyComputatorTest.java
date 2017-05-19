package com.transactions.services;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Currency;

import static org.junit.Assert.*;

/**
 * Created by Bartosz Piśkiewicz on 19.05.2017.
 */
public class CurrencyComputatorTest {

    @Mock
    CurrencyFetcher currencyFetcher;

    @Test
    public void fetchCourse() throws Exception {
        Mockito.when(currencyFetcher.fetchCurrencyCourse("EUR")).thenReturn(3.95);
        Mockito.when(currencyFetcher.fetchCurrencyCourse("USD")).thenReturn(3.20);





    }

}