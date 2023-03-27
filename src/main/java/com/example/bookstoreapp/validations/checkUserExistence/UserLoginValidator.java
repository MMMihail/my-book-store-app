package com.example.bookstoreapp.validations.checkUserExistence;

import com.example.bookstoreapp.domain.dtoS.binding.UserLoginModel;
import com.example.bookstoreapp.domain.dtoS.model.UserModel;
import com.example.bookstoreapp.services.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;


public class UserLoginValidator implements ConstraintValidator<ValidateLoginForm, UserLoginModel> {

    private final UserService userService;

    @Autowired
    public UserLoginValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(ValidateLoginForm constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserLoginModel userLoginModel, ConstraintValidatorContext constraintValidatorContext) {
        UserModel user = this.userService.findByUsername(userLoginModel.getUsername()) ;

        return user.getId() != null
                && user.getPassword()
                .equals(userLoginModel.getPassword());
    }
}
