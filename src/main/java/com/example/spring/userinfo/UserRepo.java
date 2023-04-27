package com.example.spring.userinfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<CustomUser,Integer> {
    Optional<CustomUser> findByUsername(String name);
    boolean existsCustomUserByUsername(String name);
}
