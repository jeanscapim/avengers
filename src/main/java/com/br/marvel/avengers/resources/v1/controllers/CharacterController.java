package com.br.marvel.avengers.resources.v1.controllers;

import com.br.marvel.avengers.business.CharacterBusiness;
import com.br.marvel.avengers.resources.mapper.CharacterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/avengers/v1/characters")
public class CharacterController {

    @Autowired
    private CharacterBusiness characterBusiness;

    @Autowired
    private CharacterMapper characterMapper;

}
