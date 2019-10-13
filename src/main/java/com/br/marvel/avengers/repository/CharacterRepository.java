package com.br.marvel.avengers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.br.marvel.avengers.model.Character;

public interface CharacterRepository extends JpaRepository<Character, Integer> {
}
