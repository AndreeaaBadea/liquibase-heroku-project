package com.example.liquidbaseprojectAB.exception;

 public class AccessDatabaseException extends Exception{

        public AccessDatabaseException(String message){
            super("Could not access database.");
        }
}
