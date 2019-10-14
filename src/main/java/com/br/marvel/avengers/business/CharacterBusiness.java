package com.br.marvel.avengers.business;

import lombok.NonNull;

import java.util.List;
import java.util.Optional;
import com.br.marvel.avengers.model.Character;

public interface CharacterBusiness {
    Optional<Character> create(@NonNull final Character character);
    Optional<List<Character>> read();
    Optional<Character> update(@NonNull final Character character);
    void delete(@NonNull final Integer id);
    Optional<Character> findById(@NonNull final Integer id);
}
