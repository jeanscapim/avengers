package com.br.marvel.avengers.business.Impl;

import com.br.marvel.avengers.business.CharacterBusiness;
import com.br.marvel.avengers.model.Character;
import com.br.marvel.avengers.repository.CharacterRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CharacterBusinessImpl implements CharacterBusiness {

    @Autowired
    private CharacterRepository characterRepository;

    @Override
    public Optional<Character> create(@NonNull Character character) {
        return Optional.empty();
    }

    @Override
    public Optional<Character> read() {
        return Optional.empty();
    }

    @Override
    public Optional<Character> update(@NonNull Character character) {
        return Optional.empty();
    }

    @Override
    public Optional<Character> delete(@NonNull Integer id) {
        return Optional.empty();
    }

    @Override
    public Optional<Character> findById(@NonNull Integer id) {
        return Optional.empty();
    }
}
