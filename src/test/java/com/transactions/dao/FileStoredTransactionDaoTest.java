package com.transactions.dao;

import com.transactions.entities.Transaction;
import com.transactions.utils.TransactionFileReader;
import com.transactions.utils.TransactionParser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Bartosz Piśkiewicz on 15.04.2017.
 */
@RunWith(SpringRunner.class)
public class FileStoredTransactionDaoTest {

    @MockBean
    private TransactionFileReader fileReader;
    @MockBean
    private TransactionParser parser;

    private TransactionDao transactionDao;

    @Before
    public void init(){
        Mockito.when(parser.parseTransactions(Mockito.anyString())).thenReturn(fillTransactions());
        transactionDao = new FileStoredTransactionDao(fileReader, parser);
    }

    @Test
    public void fetchAll() throws Exception {
        List<Transaction> transactions = transactionDao.fetchAll();
        List<Transaction> expected = fillTransactions();
        assertEquals(expected, transactions);
    }

    @Test
    public void fetchByTypeAndCurrency() throws Exception {
        List<Transaction> transactions = transactionDao.fetchByTypeAndCurrency("trip", "PLN");
        assertEquals(1, transactions.size());
        Transaction transaction = new Transaction.Builder()
                .id(3)
                .type("trip")
                .price(80)
                .commision(20)
                .currency("PLN")
                .paid(false)
                .build();

        assertEquals(transaction, transactions.get(0));

    }

    private List<Transaction> fillTransactions() {
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
                .type("trip")
                .price(80)
                .commision(20)
                .currency("PLN")
                .paid(false)
                .build();

        return Arrays.asList(new Transaction[]{transaction1, transaction2, transaction3});
    }

}