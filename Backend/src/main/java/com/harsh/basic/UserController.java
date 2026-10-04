package com.harsh.basic;

import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return nameRepository.save(name);
    }

    @GetMapping
    public List<Name> getUsers() {
        return nameRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        System.out.println("Deleting user with id: " + id);
        nameRepository.deleteById(id);
    }

}