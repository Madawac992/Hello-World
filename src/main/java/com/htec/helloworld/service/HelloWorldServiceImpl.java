package com.htec.helloworld.service;

import com.htec.helloworld.repository.HelloWorldRepository;
import com.htec.helloworld.repository.HelloWorldRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {

    @Autowired
    private HelloWorldRepository helloWorldRepository;

    @Override
    public String getMessage() {
        return helloWorldRepository.getMessage();
    }
}
