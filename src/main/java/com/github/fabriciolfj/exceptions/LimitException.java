package com.github.fabriciolfj.exceptions;

import lombok.Data;

@Data
public class LimitException extends RuntimeException {

    public LimitException(final String msg) {
        super(msg);
    }
}
