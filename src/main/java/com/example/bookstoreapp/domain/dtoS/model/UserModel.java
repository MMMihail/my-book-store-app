package com.example.bookstoreapp.domain.dtoS.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class UserModel {

    private Long id;
    private String username;
    private String password;
    private String email;
//    private List<RoleModel> userRoles;
//    private List<OrderModel> orders;
//    private CartModel cart;

}

