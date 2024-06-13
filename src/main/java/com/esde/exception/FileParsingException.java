package com.esde.exception;

public class FileParsingException extends Exception{

    public FileParsingException() {

    }

    public FileParsingException(String message){
        super("Parsing failed: " + message);
    }

    public FileParsingException(String message, Throwable cause){
        super(message, cause);
    }

    public FileParsingException(Throwable cause){
        super(cause);
    }
}
