package ro.tuc.ds2020.services;

import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.dtos.PersonDetailsDTO;
import ro.tuc.ds2020.dtos.UserDTO;
import ro.tuc.ds2020.dtos.UserDetailsDTO;
import ro.tuc.ds2020.dtos.builders.PersonBuilder;
import ro.tuc.ds2020.entities.Device;
import ro.tuc.ds2020.entities.Person;
import ro.tuc.ds2020.entities.Users;
import ro.tuc.ds2020.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users findByUsername(String username){
        return userRepository.findByName(username);
    }

    public UserDTO createUser(UserDTO userDTO){
        Users user = new Users(userDTO);
        user.setRole(false);
        return new UserDTO(userRepository.save(user));
    }

    public UserDTO deleteUser(Long userId) throws NotFoundException {
        Users user= userRepository.findById(userId).orElse(null);
        if (user == null) {
            //throw new ResourceNotFoundExeption(String.format("user with id %d not found ", userId));
        }
        userRepository.delete(user);
        return new UserDTO(user);
    }

    public UserDTO updateUser(Long userId, UserDTO userDTO){
        Users user=userRepository.findById(userId).orElse(null);
        if(user == null){
            //throw new ResourceNotFoundExeption(String.format("user with id %d not found ", userId));
        } else {
            user.setName(userDTO.getName());
            user.setPassword(userDTO.getPassword());
            user.setRole(userDTO.isRole());
        }
        return new UserDTO(userRepository.save(user));
    }

    public UserDetailsDTO getUser(Long userId){
        Users user = userRepository.findById(userId).orElse(null);
        if(user == null) {
            //  throw new ResourceNotFoundExeption(String.format("user with id %d not found ", userId));
        }
//        for (Device device: user.getDevices()) {
//            System.out.println(device.getId());
//        }
        return new UserDetailsDTO(user);

    }

    public List<UserDetailsDTO> getClients(){
        List<Users> clients=userRepository.findAllByRoleIsFalse();
        List<UserDetailsDTO> clientsN = new ArrayList<>();
        for(Users user:clients){
            clientsN.add(new UserDetailsDTO(user));
        }
        return clientsN;
    }

}
