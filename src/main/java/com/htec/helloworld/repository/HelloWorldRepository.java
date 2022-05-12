package com.htec.helloworld.repository;

public interface HelloWorldRepository {

    default String getMessage() {
        return "Hello World!";
    }
}
