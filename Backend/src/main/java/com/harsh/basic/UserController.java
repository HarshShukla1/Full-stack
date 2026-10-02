package com.harsh.basic;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final NameRepository nameRepository;

    public UserController(NameRepository nameRepository) {
        this.nameRepository = nameRepository;
    }

    @PostMapping
    public Name createUser(@RequestBody Name name) {
        System.out.println("Hi");
        return nameRepository.save(name);
    }
}