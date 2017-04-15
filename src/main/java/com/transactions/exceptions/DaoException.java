package com.transactions.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Bartosz Piśkiewicz on 14.04.2017.
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class DaoException extends Exception {
}
