package com.example.bookstoreapp.domain.dtoS.binding;

import com.example.bookstoreapp.validations.checkUserExistence.ValidateLoginForm;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ValidateLoginForm
public class UserLoginModel {

    private String username;
    private String password;
}
