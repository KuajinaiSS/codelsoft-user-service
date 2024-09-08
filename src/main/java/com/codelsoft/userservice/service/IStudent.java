package com.codelsoft.userservice.service;

import com.codelsoft.userservice.model.dto.UserDto;
import com.codelsoft.userservice.model.dto.UserResponseDto;
import com.codelsoft.userservice.model.entity.Student;

import java.util.UUID;

public interface IStudent {

    /**
     * Guarda un estudiante en la base de datos mediante un UserDto
     * @param userResponseDto
     * @return Student
     */
    UserResponseDto save(UserDto userResponseDto);


    /**
     * Actualiza un estudiante en la base de datos mediante un UserDto
     * @param userResponseDto
     * @return Student
     */
    UserResponseDto update(UserResponseDto userResponseDto);


    /**
     * Busca a un estudiante por su id
     * @param uuid
     * @return Student
     */
    UserResponseDto findById(UUID uuid);


    /**
     * Busca a todos los estudiantes en la base de datos y los retorna
     * @return Iterable<UserDto>
     */
    Iterable<UserResponseDto> findAll();
}
