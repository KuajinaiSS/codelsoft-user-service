package com.codelsoft.userservice.controller;


import com.codelsoft.userservice.model.dto.UserDto;
import com.codelsoft.userservice.model.dto.UserResponseDto;
import com.codelsoft.userservice.service.IStudent;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private IStudent studentService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto create(@Valid @RequestBody UserDto user) {
        return studentService.save(user);
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

        return studentService.update(userResponseDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDto findById(@PathVariable UUID id) {
        return studentService.findById(id);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<UserResponseDto> findAll() {
        return studentService.findAll();
    }


}
