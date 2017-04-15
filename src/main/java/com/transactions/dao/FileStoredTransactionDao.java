package com.transactions.dao;

import com.transactions.entities.Transaction;
import com.transactions.exceptions.DaoException;
import com.transactions.utils.TransactionFileReader;
import com.transactions.utils.TransactionParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Bartosz Piśkiewicz on 14.04.2017.
 */
@Repository
public class FileStoredTransactionDao implements TransactionDao {

    private final String file = "E:\\transactions.csv";
    private TransactionFileReader fileReader;
    private TransactionParser parser;

    @Autowired
    public FileStoredTransactionDao(TransactionFileReader fileReader, TransactionParser parser) {
        this.fileReader = fileReader;
        this.parser = parser;
    }

    @Override
    public List<Transaction> fetchAll() throws DaoException {
        return parser.parseTransactions(fileReader.readFromFile(file));
    }

    @Override
    public List<Transaction> fetchByTypeAndCurrency(String type, String currency) throws DaoException {
        return this.fetchAll().stream()
                .filter(transaction -> transaction.getType().equals(type))
                .filter(transaction -> transaction.getCurrency().equals(currency))
                .collect(Collectors.toList());
    }
}
