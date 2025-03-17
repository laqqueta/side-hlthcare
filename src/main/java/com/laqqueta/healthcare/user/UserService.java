package com.laqqueta.healthcare.user;

import com.laqqueta.healthcare.biodata.BiodataRepository;
import com.laqqueta.healthcare.role.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BiodataRepository biodataRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, BiodataRepository biodataRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.biodataRepository = biodataRepository;
        this.roleRepository = roleRepository;
    }

    public UserModel getUser(Long id) {
        Optional<UserModel> user = userRepository.findById(id);

        if (user.isEmpty()) throw new EntityNotFoundException("");

        return user.get();
    }

    public UserModel saveUser(UserModel model) {

        Thread.ofVirtual().
                start(() -> {
                    biodataRepository.findByIdAndDeletedIsFalse(model.getBiodata().getId())
                            .orElseThrow();
                })
                .start();



        return userRepository.save(model);
    }
}

