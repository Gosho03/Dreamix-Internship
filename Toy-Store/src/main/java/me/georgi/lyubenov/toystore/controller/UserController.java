package me.georgi.lyubenov.toystore.controller;

import me.georgi.lyubenov.toystore.dto.UserDTO;
import me.georgi.lyubenov.toystore.model.User;
import me.georgi.lyubenov.toystore.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.addUser(userDTO);
    }
    @GetMapping("")
    public List<UserDTO> getAllUsers() {
        return userService.findAllUsers();
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id) {
         userService.deleteUserById(id);
    }
    @PatchMapping("/{id}")
    public UserDTO updateUser(@PathVariable("id") int id, @RequestBody UserDTO userDTO) {
        return userService.updateUser(id,userDTO);
    }
}
