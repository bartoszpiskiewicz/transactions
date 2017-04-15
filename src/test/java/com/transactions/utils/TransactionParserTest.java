package com.transactions.utils;

import com.transactions.entities.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Bartosz Piśkiewicz on 14.04.2017.
 */
@RunWith(SpringRunner.class)
public class TransactionParserTest {



    @Test
    public void parseTransactions() throws Exception {
        String inputString = "1,’trip’,20,5,’EUR’,true\n" +
                "2,’ticket’,10,2,’EUR’,true";

        TransactionParser transactionParser = new TransactionParser();
        List<Transaction> expectedTransactions = getExpectedTransactions();
        List<Transaction> transactions = transactionParser.parseTransactions(inputString);

        assertEquals(expectedTransactions, transactions);
    }

    private List<Transaction> getExpectedTransactions(){
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

        return Arrays.asList(new Transaction[]{transaction1, transaction2});
    }

}