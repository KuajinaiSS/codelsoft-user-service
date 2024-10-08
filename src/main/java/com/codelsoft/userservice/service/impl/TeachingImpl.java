package com.codelsoft.userservice.service.impl;

import com.codelsoft.userservice.model.dao.TeachingDao;
import com.codelsoft.userservice.model.dto.UserDto;
import com.codelsoft.userservice.model.dto.UserResponseDto;
import com.codelsoft.userservice.model.entity.Teaching;
import com.codelsoft.userservice.service.ITeaching;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TeachingImpl implements ITeaching {

    @Autowired
    private TeachingDao teachingDao;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @Transactional
    @Override
    public UserResponseDto save(UserDto userDto) {

        if (userDto.getFirstname() == null || userDto.getLastname() == null || userDto.getEmail() == null) {
            throw new IllegalArgumentException("All fields are required");
        }

        String rawPassword = userDto.getFirstname().toLowerCase();
        // hash password
        String hashedPassword = passwordEncoder.encode(rawPassword);


        Teaching teachingSave = Teaching.builder()
                .firstname(userDto.getFirstname())
                .lastname(userDto.getLastname())
                .email(userDto.getEmail())
                .password(hashedPassword)
                .build();

        Teaching teaching = teachingDao.save(teachingSave);

        return UserResponseDto.builder()
                .uuid(teaching.getId())
                .firstname(teaching.getFirstname())
                .lastname(teaching.getLastname())
                .email(teaching.getEmail())
                .build();
    }



    @Transactional
    @Override
    public UserResponseDto update(UserResponseDto userResponseDto) {
        Teaching teaching = teachingDao.findById(userResponseDto.getUuid())
                .orElseThrow(() -> new EntityNotFoundException("Teacher not found"));

        teaching.setFirstname(userResponseDto.getFirstname());
        teaching.setLastname(userResponseDto.getLastname());
        teaching.setEmail(userResponseDto.getEmail());
        teachingDao.save(teaching);

        return UserResponseDto.builder()
                .uuid(teaching.getId())
                .firstname(teaching.getFirstname())
                .lastname(teaching.getLastname())
                .email(teaching.getEmail())
                .build();
    }


    @Transactional
    @Override
    public UserResponseDto findById(UUID uuid) {
        Teaching teaching = teachingDao.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Teacher not found"));

        return UserResponseDto.builder()
                .uuid(teaching.getId())
                .firstname(teaching.getFirstname())
                .lastname(teaching.getLastname())
                .email(teaching.getEmail())
                .build();
    }


    @Transactional
    @Override
    public Iterable<UserResponseDto> findAll() {
        Iterable<Teaching> teachings = teachingDao.findAll();
        List<UserResponseDto> userResponseDtos = new ArrayList<>();

        teachings.forEach(teaching -> {
            userResponseDtos.add(UserResponseDto.builder()
                    .uuid(teaching.getId())
                    .firstname(teaching.getFirstname())
                    .lastname(teaching.getLastname())
                    .email(teaching.getEmail())
                    .build());
        });

        return userResponseDtos;
    }
}
