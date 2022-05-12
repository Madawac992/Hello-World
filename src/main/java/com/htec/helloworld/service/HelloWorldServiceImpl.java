package com.htec.helloworld.service;

import com.htec.helloworld.repository.HelloWorldRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HelloWorldServiceImpl implements HelloWorldService {

    private final HelloWorldRepository helloWorldRepository;

    private int counter = load("src/counter.txt");

    @Override
    public String getMessage() {
        counter++;
        save("src/counter.txt");
        return helloWorldRepository.getMessage() + " " + counter;
    }

    private void save(String path) {
        List<String> lines = new ArrayList<>();
        String line = Integer.toString(counter);

        lines.add(line);
        try {
            Files.write(Paths.get(path), lines);
        } catch (Exception e) {
            System.out.println("File " + path + " not found.");
        }
    }

    private int load(String path) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            for (String line : lines) {
                if (line == null) {
                    return 0;
                }
                counter = Integer.parseInt(line);
            }
            return counter;
        } catch (Exception e) {
            System.out.println("File " + path + " not found.");
        }
        return 0;
    }
}
