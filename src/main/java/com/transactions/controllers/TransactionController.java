package com.transactions.controllers;

import com.transactions.dto.TransactionSummary;
import com.transactions.exceptions.DaoException;
import com.transactions.exceptions.NotFoundException;
import com.transactions.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Bartosz Piśkiewicz on 14.04.2017.
 */
@RestController
@RequestMapping("transactionSummary")
public class TransactionController {

    TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("type/{type}/currency/{currency}")
    public TransactionSummary fetchByTypeAndCurrency(@PathVariable String type, @PathVariable String currency ) throws NotFoundException, DaoException {
        return transactionService.generateSummaryByTypeAndCurrency(type, currency);
    }

    @GetMapping("type/{type}/currency/{currency}")
    public TransactionSummary fetchByTypeAndCurrencyInRequestedCurrency(@PathVariable String type, @PathVariable String currency, @RequestParam String expectedCurrency) throws NotFoundException, DaoException {
        return transactionService.generateSummaryByTypeAndCurrency(type, currency);
    }




}
