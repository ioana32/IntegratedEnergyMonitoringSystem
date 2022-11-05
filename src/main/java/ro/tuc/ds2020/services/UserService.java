package ro.tuc.ds2020.services;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.dtos.UserDTO;
import ro.tuc.ds2020.dtos.UserDetailsDTO;
import ro.tuc.ds2020.entities.Device;
import ro.tuc.ds2020.entities.User;
import ro.tuc.ds2020.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsername(String username){
        return userRepository.findByName(username);
    }

    public UserDTO createUser(UserDTO userDTO){
        User user = new User(userDTO);
        user.setRole(false);
        return new UserDTO(userRepository.save(user));
    }

    public UserDTO deleteUser(Long userId) throws NotFoundException {
        User user= userRepository.findById(userId).orElse(null);
        if (user == null) {
            //throw new ResourceNotFoundExeption(String.format("user with id %d not found ", userId));
        }
        userRepository.delete(user);
        return new UserDTO(user);
    }

    public UserDTO updateUser(Long userId, UserDTO userDTO){
        User user=userRepository.findById(userId).orElse(null);
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
        User user = userRepository.findById(userId).orElse(null);
        if(user == null) {
            //  throw new ResourceNotFoundExeption(String.format("user with id %d not found ", userId));
        }
        for (Device device: user.getDevices()) {
            System.out.println(device.getId());
        }
        return new UserDetailsDTO(user);

    }

}
