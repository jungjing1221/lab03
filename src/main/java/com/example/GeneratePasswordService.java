package com.example;

import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
public class GeneratePasswordService {
    @RequestMapping(value = "/{name}.generate", method = RequestMethod.POST)
    public String generate(@PathVariable("name") String name) {
        Random rnd = new Random();
        int password = rnd.nextInt(999999);
        return String.format("Hi, %s\nYour new password is %06d", name, password);
    }
}
