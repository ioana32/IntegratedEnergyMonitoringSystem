package ro.tuc.ds2020.controllers;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.PersonDetailsDTO;
import ro.tuc.ds2020.dtos.UserDTO;
import ro.tuc.ds2020.dtos.UserDetailsDTO;
import ro.tuc.ds2020.services.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

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
    public ResponseEntity<List<UserDTO>> getUsers(){
        return null;
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<UserDetailsDTO> getUser(@PathVariable("userId") Long userId) {
        UserDetailsDTO dto = userService.getUser(userId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        //return new ResponseEntity<>(userService.createUser(userDTO),HttpStatus.CREATED);
        UserDTO dto = userService.createUser(userDTO);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/{userId}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("userId") Long userId, @RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userService.updateUser(userId,userDTO),HttpStatus.OK);
    }

    @DeleteMapping(value = "/{userId}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable Long userId) throws NotFoundException {
        return new ResponseEntity<>(userService.deleteUser(userId),HttpStatus.OK);
    }

    @GetMapping(value="/clients")
    public ResponseEntity<List<UserDetailsDTO>> getClients() throws NotFoundException{
        return new ResponseEntity<>(userService.getClients(),HttpStatus.OK);
    }


}
