package com.example.spring.userinfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepo extends JpaRepository<CustomRole,Integer> {
    CustomRole findCustomRoleByName(String name);
}
