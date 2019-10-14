package com.br.marvel.avengers.resources.v1.dtos;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CharacterRequestDto {
    private Integer id;
    private String name;
    private String description;
    private Date createdAt;
}
