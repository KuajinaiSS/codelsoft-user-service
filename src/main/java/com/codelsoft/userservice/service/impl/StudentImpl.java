package com.codelsoft.userservice.service.impl;

import com.codelsoft.userservice.model.dao.StudentDao;
import com.codelsoft.userservice.model.dto.UserDto;
import com.codelsoft.userservice.model.dto.UserResponseDto;
import com.codelsoft.userservice.model.entity.Student;
import com.codelsoft.userservice.service.IStudent;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StudentImpl implements IStudent {

    @Autowired
    private StudentDao studentDao;

    @Override
    public UserResponseDto save(UserDto userResponseDto) {
        Student studentSave = Student.builder()
                .firstname(userResponseDto.getFirstname())
                .lastname(userResponseDto.getLastname())
                .email(userResponseDto.getEmail())
                .build();

        Student student = studentDao.save(studentSave);

        return UserResponseDto.builder()
                .uuid(student.getId())
                .firstname(student.getFirstname())
                .lastname(student.getLastname())
                .email(student.getEmail())
                .build();
    }

    @Override
    public UserResponseDto update(UserResponseDto userResponseDto) {
        Student student = studentDao.findById(userResponseDto.getUuid())
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));

        student.setFirstname(userResponseDto.getFirstname());
        student.setLastname(userResponseDto.getLastname());
        student.setEmail(userResponseDto.getEmail());
        studentDao.save(student);

        return UserResponseDto.builder()
                .uuid(student.getId())
                .firstname(student.getFirstname())
                .lastname(student.getLastname())
                .email(student.getEmail())
                .build();
    }

    @Override
    public UserResponseDto findById(UUID uuid) {
        Student student = studentDao.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));

        return UserResponseDto.builder()
                .uuid(student.getId())
                .firstname(student.getFirstname())
                .lastname(student.getLastname())
                .email(student.getEmail())
                .build();
    }

    @Override
    public Iterable<UserResponseDto> findAll() {
        Iterable<Student> students = studentDao.findAll();
        List<UserResponseDto> userResponseDtos = new ArrayList<>();

        students.forEach(student -> {
            userResponseDtos.add(UserResponseDto.builder()
                    .uuid(student.getId())
                    .firstname(student.getFirstname())
                    .lastname(student.getLastname())
                    .email(student.getEmail())
                    .build());
        });
        return userResponseDtos;
    }
}
