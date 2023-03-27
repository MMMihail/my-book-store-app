package com.example.bookstoreapp.repositories;

import com.example.bookstoreapp.domain.entities.UserRole;
import com.example.bookstoreapp.domain.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<UserRole, Long> {

    @Transactional
    Optional<UserRole> findByUserRole(Role rolName);
}
