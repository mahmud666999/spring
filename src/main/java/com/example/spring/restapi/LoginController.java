package com.example.spring.restapi;

import com.example.spring.userinfo.CustomUser;
import com.example.spring.userinfo.RegisterDTO;
import com.example.spring.userinfo.RolesRepo;
import com.example.spring.userinfo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor

@RequestMapping("/whitelist")
public class LoginController {
    final UserRepo userRepo;
    final RolesRepo rolesRepo;
    final PasswordEncoder passwordEncoder;
    @PostMapping("/register")
    ResponseEntity<String> registerUser(@RequestBody RegisterDTO registerDTO) {
        if (userRepo.existsCustomUserByUsername(registerDTO.getUsername())){
         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        CustomUser user=new CustomUser();
        user.setUsername(registerDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        user.setRole(rolesRepo.findCustomRoleByName("User"));
        return new ResponseEnt
        ity<>(HttpStatus.CREATED);
    }
    @GetMapping("/allUsers")
    List<CustomUser> allUsers(){
        return userRepo.findAll();
    }
}

