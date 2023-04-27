package com.example.spring.userinfo;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomDetails implements UserDetailsService {
    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomUser user = userRepo.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("Username not found."));
        return User.builder().
                username(user.getUsername()).
                password(user.getPassword()).
                roles(user.getRole().toString()).
                build();
    }
}
