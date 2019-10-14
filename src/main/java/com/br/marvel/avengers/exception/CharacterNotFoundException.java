package com.br.marvel.avengers.exception;

import com.br.marvel.avengers.exception.handler.BaseHandlerException;

public class CharacterNotFoundException extends BaseHandlerException {
    public CharacterNotFoundException(Object... parameters) {
        super(parameters);
    }
}
