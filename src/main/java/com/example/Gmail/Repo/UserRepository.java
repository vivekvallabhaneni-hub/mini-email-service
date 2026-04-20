package com.example.Gmail.Repo;

import com.example.Gmail.Entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  UserRepository extends JpaRepository<User,Long> {
    Optional<Object> findByEmail(String email);
    Optional<User> findByUsername(String username);
}
