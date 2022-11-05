package ro.tuc.ds2020.controllers;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.UserDTO;
import ro.tuc.ds2020.dtos.UserDetailsDTO;
import ro.tuc.ds2020.services.UserService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<UserDTO>> getClients(){
        return null;
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<UserDetailsDTO> getUser(@PathVariable Long userId){
        return new ResponseEntity<>(userService.getUser(userId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userService.createUser(userDTO),HttpStatus.CREATED);
    }

    @PutMapping(value = "/{userId}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long userId, @RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userService.updateUser(userId,userDTO),HttpStatus.OK);
    }

    @DeleteMapping(value = "/{userId}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable Long userId) throws NotFoundException {
        return new ResponseEntity<>(userService.deleteUser(userId),HttpStatus.OK);
    }


}
