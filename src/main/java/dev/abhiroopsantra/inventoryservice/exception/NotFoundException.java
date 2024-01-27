package dev.abhiroopsantra.inventoryservice.exception;

import lombok.experimental.StandardException;

@StandardException
public class NotFoundException extends RuntimeException {
        public NotFoundException(String message) {
            super(message);
        }
}
