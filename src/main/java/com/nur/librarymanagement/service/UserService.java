package com.nur.librarymanagement.service;

import com.nur.librarymanagement.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    UserDto save(UserDto user);

    UserDto getById(Long id);

    Page<UserDto> getAllPageable(Pageable pageable);

    Boolean delete(UserDto user);

    UserDto update(Long id, UserDto user);
}
