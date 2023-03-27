package com.example.bookstoreapp.services;

import com.example.bookstoreapp.domain.dtoS.model.RoleModel;
import com.example.bookstoreapp.domain.entities.UserRole;
import com.example.bookstoreapp.domain.enums.Role;
import com.example.bookstoreapp.repositories.RoleRepository;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class RoleService {

    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public RoleService(RoleRepository roleRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    private void postConstruct() {
        if (this.roleRepository.count() == 0) {
            this.roleRepository.saveAllAndFlush(Arrays.stream(Role.values())
                    .map(enumValue -> RoleModel.builder()
                            .userRole(enumValue)
                            .build())
                    .map(roleModel -> this.modelMapper.map(roleModel, UserRole.class))
                    .toList());
        }
    }

    public UserRole findUserRole(Role role) {
        return this.modelMapper.map(this.roleRepository.findByUserRole(role).orElseThrow(), UserRole.class);
    }
}
