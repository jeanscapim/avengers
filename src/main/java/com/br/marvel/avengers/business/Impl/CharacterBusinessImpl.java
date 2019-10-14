package com.br.marvel.avengers.business.Impl;

import com.br.marvel.avengers.business.CharacterBusiness;
import com.br.marvel.avengers.exception.CharacterNotFoundException;
import com.br.marvel.avengers.model.Character;
import com.br.marvel.avengers.repository.CharacterRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CharacterBusinessImpl implements CharacterBusiness {

    @Autowired
    private CharacterRepository characterRepository;

    @Override
    public Optional<Character> create(@NonNull Character character) {
        return Optional.of(characterRepository.saveAndFlush(character));
    }

    @Override
    public Optional<List<Character>> read() {
        return Optional.of(characterRepository.findAll());
    }

    @Override
    public Optional<Character> update(@NonNull Character character) {
        characterRepository.findById(character.getId())
                .orElseThrow(CharacterNotFoundException::new);

        return Optional.of(characterRepository.saveAndFlush(character));
    }

    @Override
    public void delete(@NonNull Integer id) {
        characterRepository.findById(id)
                .orElseThrow(CharacterNotFoundException::new);

        characterRepository.deleteById(id);
    }

    @Override
    public Optional<Character> findById(@NonNull Integer id) {
        return Optional.of(characterRepository.findById(id)
                .orElseThrow(CharacterNotFoundException::new));
    }
}
