package com.transactions.utils;

import com.transactions.entities.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bartosz Piśkiewicz on 14.04.2017.
 */
@Service
public class TransactionParser {

    private String lineSeparator = "\n";

    public List<Transaction> parseTransactions(String s){
        List<Transaction> transactions = new ArrayList<>();
        String[] split = s.split(lineSeparator);
        for(int i=0; i < split.length; i++) {
            transactions.add(parseTransaction(split[i]));
        }
        return transactions;
    }

    private Transaction parseTransaction(String transactionString) {
        String[] split = transactionString.split(",");
        return new Transaction.Builder()
                .id(Long.parseLong(split[0]))
                .type(split[1].replaceAll("’", ""))
                .price(Double.parseDouble(split[2]))
                .commision(Double.parseDouble(split[3]))
                .currency(split[4].replaceAll("’", ""))
                .paid(Boolean.parseBoolean(split[5]))
                .build();

    }


}
