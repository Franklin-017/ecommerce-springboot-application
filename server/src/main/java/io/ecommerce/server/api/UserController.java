package io.ecommerce.server.api;

import io.ecommerce.server.model.User;
import io.ecommerce.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:3000")
@RequestMapping("/user")
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
       return userService.getAllUsers();
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable("id") long id) {
        return userService.getUserById(id);
    }

    @GetMapping(path = "/email/{email}")
    public ResponseEntity<Optional<User>> getUserByEmail(@PathVariable("email") String email) {
        return userService.getUserByEmail(email);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id) {
        return userService.deleteUser(id);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Optional<User>> updateUser(@PathVariable("id") long id, User user) {
        return userService.updateUser(id, user);
    }
}
