package com.example.spring.userinfo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Data
@Entity
public class CustomUser implements UserDetails {
    String username;
    @Id
            @SequenceGenerator(name = "id_generator", sequenceName = "id_generator", allocationSize = 1)
            @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "id_generator")
    int id;
    String password;
    @ManyToOne
    @JsonManagedReference
    CustomRole role;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> list=Arrays.asList(new SimpleGrantedAuthority(role.getName()));
        return list;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getRoleByName() {
        return role.getName();
    }
}
