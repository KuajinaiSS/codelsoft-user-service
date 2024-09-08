package com.codelsoft.userservice.service;

import com.codelsoft.userservice.model.dto.UserDto;
import com.codelsoft.userservice.model.dto.UserResponseDto;

import java.util.UUID;

public interface ITeaching {

    /**
     * Guarda un docente en la base de datos mediante un UserDto
     * @param userDto
     * @return Teaching
     */
    UserResponseDto save(UserDto userDto);


    /**
     * Actualiza un docente en la base de datos mediante un UserDto
     * @param userResponseDto
     * @return Teaching
     */
    UserResponseDto update(UserResponseDto userResponseDto);


    /**
     * Busca a un docente por su id
     * @param uuid
     * @return Teaching
     */
    UserResponseDto findById(UUID uuid);


    /**
     * Busca a todos los docentes en la base de datos y los retorna
     * @return Iterable<UserDto>
     */
    Iterable<UserResponseDto> findAll();
}
