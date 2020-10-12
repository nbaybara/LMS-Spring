package com.nur.librarymanagement.service.implementation;

import com.nur.librarymanagement.dto.AuthorDto;
import com.nur.librarymanagement.dto.BookDto;
import com.nur.librarymanagement.dto.UserDto;
import com.nur.librarymanagement.entity.Author;
import com.nur.librarymanagement.service.UserService;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public UserDto save(UserDto user) {
        return null;
    }

    @Override
    public UserDto getById(Long id) {
        return null;
    }

    @Override
    public Page<UserDto> getAllPageable(Pageable pageable) {
        return null;
    }

    @Override
    public Boolean delete(UserDto user) {
        return null;
    }

    @Override
    public UserDto update(Long id, UserDto user) {
        return null;
    }
}
