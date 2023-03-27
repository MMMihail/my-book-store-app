package com.example.bookstoreapp.services;

import com.example.bookstoreapp.domain.dtoS.model.UserModel;
import com.example.bookstoreapp.domain.entities.User;
import com.example.bookstoreapp.domain.helpers.LoggedUser;
import com.example.bookstoreapp.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper modelMapper, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
    }

    public UserModel findByUsername(String username) {
        return this.modelMapper.map(this.userRepository.findByUsername(username).orElse(new User()), UserModel.class);
    }

    public String getLoggedUser() {
        UserModel userModel = this.modelMapper.map(this.userRepository.findById(loggedUser.getId()), UserModel.class);
        return userModel.getUsername();
    }
}
