package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.UserDTO;
import ro.tuc.ds2020.dtos.UserDetailsDTO;
import ro.tuc.ds2020.services.UserService;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LogInController {

    private final UserService userService;

    @Autowired
    public LogInController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDetailsDTO> loginUser(@RequestBody UserDTO userDTO){
        System.out.println(userDTO.getName());
        UserDetailsDTO dto = userService.logIn(userDTO.getName());
        System.out.println(dto);
        if(dto.getPassword().equals(userDTO.getPassword()))
            return new ResponseEntity<>(dto, HttpStatus.OK);
        else
            return null;
    }

}
