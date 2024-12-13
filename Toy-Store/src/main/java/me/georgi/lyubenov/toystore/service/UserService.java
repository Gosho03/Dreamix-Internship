package me.georgi.lyubenov.toystore.service;

import jakarta.persistence.EntityNotFoundException;
import me.georgi.lyubenov.toystore.dto.UserDTO;
import me.georgi.lyubenov.toystore.model.User;
import me.georgi.lyubenov.toystore.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO convertToDTO(User user){
        UserDTO userDTO = new UserDTO(user.getFirstName(),user.getLastName(),user.getAge());
        return userDTO;
    }
    public User convertToEntity(UserDTO userDTO){
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setAge(userDTO.getAge());
        return user;
    }
    //Add user
    public UserDTO addUser(UserDTO userDTO){
        User user = convertToEntity(userDTO);
        userRepository.save(user);
        return userDTO;
    }
    public List<UserDTO> findAllUsers(){
        return userRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    //Delete
    public void deleteUserById(int id){
         userRepository.deleteById(id);
    }
    //Update
    public UserDTO updateUser(int id,UserDTO dto){
        Optional<User> existingUser = userRepository.findById(id);
        if(existingUser.isPresent()){
            User user = existingUser.get();
            user.setFirstName(dto.getFirstName());
            user.setLastName(dto.getLastName());
            user.setAge(dto.getAge());
            userRepository.save(user);
            return convertToDTO(user);
        }else{
            throw new EntityNotFoundException();
        }
    }

    //Find by id
    public UserDTO getUserById(int id){
        return userRepository.findById(id).map(this::convertToDTO).orElse(null);
    }
}
