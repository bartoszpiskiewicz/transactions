package com.transactions.dao;

import com.transactions.entities.Transaction;
import com.transactions.exceptions.DaoException;

import java.util.List;

/**
 * Created by Bartosz Piśkiewicz on 14.04.2017.
 */
public interface TransactionDao {

    List<Transaction> fetchAll() throws DaoException;

    List<Transaction> fetchByTypeAndCurrency(String type, String currency) throws DaoException;

}
