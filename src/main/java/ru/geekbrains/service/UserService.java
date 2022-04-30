package ru.geekbrains.service;

import org.springframework.data.domain.Page;
import ru.geekbrains.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Page<UserDto> findUsersByFilter(String usernameFilter, String emailFilter, Integer page, Integer size);

    Optional<UserDto> findById(long id);

    UserDto save (UserDto user);

    void deleteById(long id);
}
