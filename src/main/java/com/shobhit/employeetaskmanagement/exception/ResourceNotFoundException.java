package com.shobhit.employeetaskmanagement.exception;

public class ResourceNotFoundException extends RuntimeException{
        public ResourceNotFoundException(String message) {
            super(message);
        }
}
