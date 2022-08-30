package com.sivalabs.devzone.users.domain.repositories;

import com.sivalabs.devzone.users.domain.models.User;
import java.util.Optional;

public interface UserRepository {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    Optional<User> findById(Long id);

    User save(User user);

    void delete(User user);
}