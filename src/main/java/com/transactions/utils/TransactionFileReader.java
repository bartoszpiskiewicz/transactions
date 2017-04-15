package com.transactions.utils;

import com.transactions.exceptions.DaoException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Bartosz Piśkiewicz on 14.04.2017.
 */
@Service
public class TransactionFileReader {

    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Logger logger = Logger.getLogger(TransactionFileReader.class);

    public String readFromFile(String file) throws DaoException {
        lock.readLock().lock();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder stringBuilder = new StringBuilder();
            String ls = "\n";
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            return stringBuilder.toString();
        }catch (IOException e) {
            logger.error("IO Exception: " + e.getMessage());
            DaoException daoException = new DaoException();
            daoException.initCause(e);
            throw daoException;
        }finally {
            lock.readLock().unlock();
        }
    }


}
