package com.laqqueta.healthcare.user;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public UserModel getById(Long id) {
        Optional<UserModel> user = repository.findById(id);

        return user.orElseThrow();
    }
}
