package com.candenizgumus.springbootdemo.service;

import com.candenizgumus.springbootdemo.DenemeComponent;
import com.candenizgumus.springbootdemo.entity.Auth;
import com.candenizgumus.springbootdemo.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
public class AuthService
{
    private final AuthRepository authRepository;

    public AuthService(AuthRepository authRepository)
    {
        this.authRepository = authRepository;
    }

    public Auth save(Auth auth)
    {
        return authRepository.save(auth);
    }


    public Auth findByUsername(String username)
    {
        return authRepository.findByUsername(username);
    }
}
