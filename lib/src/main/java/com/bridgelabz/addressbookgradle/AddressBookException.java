package com.bridgelabz.addressbookgradle;

public class AddressBookException extends RuntimeException  {
	enum ExceptionType {
        CANNOT_EXECUTE_QUERY, FAILED_TO_CONNECT
    }
    ExceptionType exceptionType;

    public AddressBookException(ExceptionType exceptionType, String message) {
        super(message);
        this.exceptionType = exceptionType;
    }
}
