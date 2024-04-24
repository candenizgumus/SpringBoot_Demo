package com.candenizgumus.springbootdemo.controller;

import com.candenizgumus.springbootdemo.dto.LoginDto;
import com.candenizgumus.springbootdemo.entity.Auth;
import com.candenizgumus.springbootdemo.exception.DemoException;
import com.candenizgumus.springbootdemo.exception.ErrorType;
import com.candenizgumus.springbootdemo.repository.AuthRepository;
import com.candenizgumus.springbootdemo.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController
{
    private final AuthRepository authRepository;
    private final AuthService authService;

    @PostMapping("/login")
    @CrossOrigin("*")
    public ResponseEntity<Boolean> doLogin(@RequestBody LoginDto dto)
    {
        Optional<Auth> auth = authRepository.findOptionalByUsernameAndPassword(dto.getUsername(), dto.getPassword());
        if (auth.isPresent())
        {
            return ResponseEntity.ok(true);
        } else
        {
            throw new DemoException(ErrorType.USERNAME_OR_PASSWORD_WRONG);
        }
    }

    @PostMapping("/register")
    @CrossOrigin("*")
    public ResponseEntity<Auth> doRegister(String username, String password)
    {
        Auth auth = Auth.builder().username(username).password(password).build();
        authRepository.save(auth);
        return ResponseEntity.ok(auth);
    }


    @GetMapping("/findall")
    @CrossOrigin("*")
    public ResponseEntity<List<Auth>> getAllAuth()
    {
        return ResponseEntity.ok(authRepository.findAll());
    }

    @GetMapping("/findbyusername")
    public ResponseEntity<Auth> findByUsername(String username)
    {
        if (username ==null)
        {
            throw new RuntimeException("Username cannot be null");
        }
        return ResponseEntity.ok(authService.findByUsername(username));
    }
}
