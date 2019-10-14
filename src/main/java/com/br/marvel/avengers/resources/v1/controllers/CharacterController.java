package com.br.marvel.avengers.resources.v1.controllers;

import com.br.marvel.avengers.business.CharacterBusiness;
import com.br.marvel.avengers.resources.mapper.CharacterMapper;
import com.br.marvel.avengers.resources.v1.dtos.CharacterRequestDto;
import com.br.marvel.avengers.resources.v1.dtos.CharacterResponseDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/avengers/v1/characters")
public class CharacterController {

    @Autowired
    private CharacterBusiness characterBusiness;

    @Autowired
    private CharacterMapper characterMapper;

    @PostMapping
    @ResponseBody
    @ApiOperation(value = "Create Avenger", response = CharacterResponseDto.class, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 409, message = "Conflict"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<Optional<CharacterResponseDto>> create(@RequestBody @Valid final CharacterRequestDto saleRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(characterMapper
                        .serializeToDto(characterBusiness
                                .create(characterMapper
                                        .serializeToModel(Optional.of(saleRequestDto)).get())));
    }

    @GetMapping
    @ResponseBody
    @ApiOperation(value = "Get All Avengers", response = CharacterResponseDto.class, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<Optional<List<CharacterResponseDto>>> read(@PathVariable final Integer id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(characterMapper
                        .serializeListToDto(characterBusiness.read()));
    }

    @PutMapping
    @ResponseBody
    @ApiOperation(value = "Update Avenger", response = CharacterResponseDto.class, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<Optional<CharacterResponseDto>> update(@RequestBody @Valid final CharacterRequestDto saleRequestDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(characterMapper
                        .serializeToDto(characterBusiness
                                .update(characterMapper
                                        .serializeToModel(Optional.of(saleRequestDto)).get())));
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Delete Avenger By ID", response = CharacterResponseDto.class, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<Void> delete(@PathVariable final Integer id) {
        characterBusiness.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Get Avenger By ID", response = CharacterResponseDto.class, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<Optional<CharacterResponseDto>> findById(@PathVariable final Integer id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(characterMapper
                        .serializeToDto(characterBusiness.findById(id)));
    }
}
