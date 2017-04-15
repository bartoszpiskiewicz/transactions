package com.transactions.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Bartosz Piśkiewicz on 14.04.2017.
 */
@RunWith(SpringRunner.class)
public class TransactionFileReaderTest {

    @Test
    public void readFromFile() throws Exception {

        String expectedString = "1,’trip’,20,5,’EUR’,true\n" +
                "2,’ticket’,10,2,’EUR’,true\n" +
                "3,’trip’,80,20,’PLN’,false\n" +
                "4,’transfer’,100,0,’PLN’,true\n" +
                "5,’trip’,50,18,’EUR’,true\n" +
                "6,’trip’,120,5,’PLN’,false";

        TransactionFileReader transactionFileReader = new TransactionFileReader();
        String fileContent = transactionFileReader.readFromFile("E:\\testFile.csv").trim();

        assertEquals(expectedString, fileContent);

    }

}