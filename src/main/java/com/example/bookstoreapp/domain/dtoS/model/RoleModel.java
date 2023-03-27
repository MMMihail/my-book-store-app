package com.example.bookstoreapp.domain.dtoS.model;

import com.example.bookstoreapp.domain.enums.Role;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleModel {

    private Long id;
    private Role userRole;

}
