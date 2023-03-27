package com.example.bookstoreapp.services;

import com.example.bookstoreapp.domain.dtoS.binding.UserLoginModel;
import com.example.bookstoreapp.domain.dtoS.binding.UserRegisterModel;
import com.example.bookstoreapp.domain.entities.Cart;
import com.example.bookstoreapp.domain.entities.User;
import com.example.bookstoreapp.domain.enums.Role;
import com.example.bookstoreapp.domain.helpers.LoggedUser;
import com.example.bookstoreapp.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;
    private final RoleService roleService;

    @Autowired
    public AuthService(UserRepository userRepository, ModelMapper modelMapper, LoggedUser loggedUser, RoleService roleService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
        this.roleService = roleService;
    }

    public void registerUser(UserRegisterModel userRegisterModel) {

        User user = this.modelMapper.map(userRegisterModel, User.class);
        user.setOrders(new ArrayList<>());
        user.setUserRoles( new ArrayList<>());
        user.getUserRoles().add(this.roleService.findUserRole(Role.USER));

        this.userRepository.saveAndFlush(user);
    }

    public void loginUser(UserLoginModel userLoginModel) {
        User userByUsername = this.userRepository.findByUsername(userLoginModel.getUsername()).get();

        this.loggedUser.setId(userByUsername.getId());
    }

    public void logoutUser() {
        this.loggedUser.clearUser();
    }

}
