package com.shop.Shopaholic.services;

import com.shop.Shopaholic.entities.LoginEntity;
import com.shop.Shopaholic.entities.UserEntity;
import com.shop.Shopaholic.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginRepository login;

    @Override
    public Optional<UserEntity> validateUser(LoginEntity user) {
        UserEntity userEntity = login.findByEmailId(user.getUserName());
        return (userEntity!=null && userEntity.getPassword().equals(user.getPassword()))?Optional.of(userEntity):Optional.empty();
    }

}
