package com.transactions.services;

import com.transactions.dao.TransactionDao;
import com.transactions.dto.TransactionSummary;
import com.transactions.entities.Transaction;
import com.transactions.exceptions.DaoException;
import com.transactions.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Bartosz Piśkiewicz on 14.04.2017.
 */
@Service
public class TransactionService {

    private TransactionDao transactionDao;

    @Autowired
    public TransactionService(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    public TransactionSummary generateSummaryByTypeAndCurrency(String type, String currency) throws NotFoundException, DaoException {
        List<Transaction> transactions = transactionDao.fetchByTypeAndCurrency(type, currency);
        if (transactions.size() == 0) {
            throw new NotFoundException();
        }
        return generateSummaryFromTransactions(transactions);
    }

    private TransactionSummary generateSummaryFromTransactions(List<Transaction> transactions) {
        String currency = transactions.get(0).getCurrency();
        String type = transactions.get(0).getType();
        double price = 0;
        double commision = 0;
        double toCharge = 0;
        for (Transaction t : transactions) {
            price += t.getPrice();
            commision += t.getCommision();
            if (!t.isPaid()) {
                toCharge += t.getPrice();
            }
        }
        double settlementValue = price - commision - toCharge;
        return new TransactionSummary(currency, price, type, commision, toCharge, settlementValue);
    }




}
