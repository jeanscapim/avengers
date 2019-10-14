package com.br.marvel.avengers.resources.mapper;

import com.br.marvel.avengers.resources.v1.dtos.CharacterRequestDto;
import com.br.marvel.avengers.resources.v1.dtos.CharacterResponseDto;
import com.br.marvel.avengers.model.Character;
import lombok.NonNull;
import lombok.var;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CharacterMapper {

    public Optional<List<CharacterResponseDto>> serializeListToDto(@NonNull final Optional<List<Character>> sales) {

        final var serializers = new ArrayList<CharacterResponseDto>();

        sales.ifPresent(t -> t.forEach(sale -> {
            serializers.add(serializeToDto(Optional.of(sale)).get());
        }));

        return Optional.of(serializers);
    }

    public Optional<CharacterResponseDto> serializeToDto(@NonNull final Optional<Character> character) {
        final var model = character.get();

        return Optional.of(CharacterResponseDto.builder()
                .id(model.getId())
                .name(model.getName())
                .description(model.getDescription())
                .createdAt(model.getCreatedAt())
                .build());
    }

    public Optional<Character> serializeToModel(@NonNull final Optional<CharacterRequestDto> sale) {
        final var dto = sale.get();

        return Optional.of(Character.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .createdAt(dto.getCreatedAt())
                .build());
    }
}
