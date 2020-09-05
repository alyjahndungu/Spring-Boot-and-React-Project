package com.services;


import com.entities_auth.User;
import com.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void UserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        return userRepository.save(user);
    }


    public List<User> getUsers(){
        return userRepository.findAll();
    }


    public Optional<User> findByUserId (Long userId){
        return userRepository.findById(userId);
    }

    public  void deleteUser (Long userId){
        userRepository.deleteById(userId);
    }

    public User updateUser(User user){
       User userUpdate = userRepository.findById((long) user.getId()).orElse(null);
       userUpdate.setUsername(user.getUsername());
       userUpdate.setCreatedBy(user.getCreatedBy());
       userUpdate.setUpdatedBy(user.getUpdatedBy());
       userUpdate.setPassword(user.getPassword());
       userUpdate.setUpdatedAt(new Date());

       return userRepository.save(userUpdate);
    }


}
