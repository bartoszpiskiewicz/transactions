package com.transactions.controllers;

import com.transactions.dto.TransactionSummary;
import com.transactions.exceptions.DaoException;
import com.transactions.exceptions.NotFoundException;
import com.transactions.services.TransactionService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.NotActiveException;

import static org.junit.Assert.*;

/**
 * Created by Bartosz Piśkiewicz on 15.04.2017.
 */
@RunWith(SpringRunner.class)
public class TransactionControllerTest {

    @MockBean
    TransactionService transactionService;

    TransactionController transactionController;

    @Before
    public void init() {
        transactionController = new TransactionController(transactionService);
    }

    @Test
    public void fetchByTypeAndCurrency() throws Exception {
        TransactionSummary summary = new TransactionSummary("EUR", 110, "trip", 27, 80, 3);
        when(transactionService.generateSummaryByTypeAndCurrency("trip", "EUR"))
                .thenReturn(summary);

        TransactionSummary expectedSummary = new TransactionSummary("EUR", 110, "trip", 27, 80, 3);

        TransactionSummary transactionSummary = transactionController.fetchByTypeAndCurrency("trip", "EUR");
        assertEquals(expectedSummary, transactionSummary);
    }


    @Test(expected = NotFoundException.class)
    public void fetchByTypeAndCurrencyNotFound() throws Exception{
        when(transactionService.generateSummaryByTypeAndCurrency("trip", "NZD")).thenThrow(new NotFoundException());
        TransactionSummary transactionSummary = transactionController.fetchByTypeAndCurrency("trip", "NZD");

    }

}