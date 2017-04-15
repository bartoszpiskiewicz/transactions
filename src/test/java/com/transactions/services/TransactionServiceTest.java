package com.transactions.services;

import com.transactions.dao.TransactionDao;
import com.transactions.dto.TransactionSummary;
import com.transactions.entities.Transaction;
import com.transactions.exceptions.DaoException;
import com.transactions.exceptions.NotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Bartosz Piśkiewicz on 15.04.2017.
 */
@RunWith(SpringRunner.class)
public class TransactionServiceTest {

    @MockBean
    TransactionDao transactionDao;
    TransactionService transactionService;


    @Before
    public void init() throws DaoException {
        transactionService = new TransactionService(transactionDao);
    }


    @Test
    public void generateSummaryByTypeAndCurrency() throws Exception {
        Mockito.when(transactionDao.fetchByTypeAndCurrency(Mockito.anyString(), Mockito.anyString())).thenReturn(this.fetchMockData());
        TransactionSummary expectedSummary = new TransactionSummary("EUR", 110, "trip", 27, 80, 3);

        TransactionSummary transactionSummary = transactionService.generateSummaryByTypeAndCurrency("trip", "EUR");
        assertEquals(expectedSummary, transactionSummary);
    }

    @Test(expected = NotFoundException.class)
    public void generateSummaryByTypeAndCurrencyWithEmpty() throws Exception {
        Mockito.when(transactionDao.fetchByTypeAndCurrency(Mockito.anyString(), Mockito.anyString())).thenReturn(Collections.emptyList());
        TransactionSummary expectedSummary = new TransactionSummary("EUR", 110, "trip", 27, 80, 3);

        TransactionSummary transactionSummary = transactionService.generateSummaryByTypeAndCurrency("trip", "EUR");
        assertEquals(expectedSummary, transactionSummary);
    }

    private List<Transaction> fetchMockData() {
        Transaction transaction1 = new Transaction.Builder()
                .id(1)
                .type("trip")
                .price(20)
                .commision(5)
                .currency("EUR")
                .paid(true)
                .build();

        Transaction transaction2 = new Transaction.Builder()
                .id(2)
                .type("ticket")
                .price(10)
                .commision(2)
                .currency("EUR")
                .paid(true)
                .build();

        Transaction transaction3 = new Transaction.Builder()
                .id(3)
                .type("ticket")
                .price(80)
                .commision(20)
                .currency("EUR")
                .paid(false)
                .build();

        return Arrays.asList(new Transaction[]{transaction1, transaction2, transaction3});
    }

}