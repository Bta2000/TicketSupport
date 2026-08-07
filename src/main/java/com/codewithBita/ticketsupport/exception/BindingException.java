package com.codewithBita.ticketsupport.exception;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class BindingException extends RuntimeException {

    private final List<String> errors = new ArrayList<>();

    public void addError(String code, String message) {
        errors.add(message);
    }
}