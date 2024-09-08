package com.codelsoft.userservice.controller;


import com.codelsoft.userservice.model.dto.UserDto;
import com.codelsoft.userservice.model.dto.UserResponseDto;
import com.codelsoft.userservice.service.ITeaching;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/teaching")
public class TeachingController {

    @Autowired
    private ITeaching teachingService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto create(@Valid @RequestBody UserDto user) {
        return teachingService.save(user);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDto update(@PathVariable UUID id, @Valid @RequestBody UserDto userDto) {
        UserResponseDto userResponseDto = UserResponseDto.builder()
                .uuid(id)
                .firstname(userDto.getFirstname())
                .lastname(userDto.getLastname())
                .email(userDto.getEmail())
                .build();

        return teachingService.update(userResponseDto);
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDto findById(@PathVariable UUID id) {
        return teachingService.findById(id);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<UserResponseDto> findAll() {
        return teachingService.findAll();
    }
}
