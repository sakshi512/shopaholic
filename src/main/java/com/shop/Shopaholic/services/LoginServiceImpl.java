package com.shop.Shopaholic.services;

import com.shop.Shopaholic.entities.UserEntity;
import com.shop.Shopaholic.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginRepository login;

    @Override
    public boolean validateUser(UserEntity user) {
        UserEntity userEntity = login.findByEmailId(user.getEmail());
        return (userEntity!=null && userEntity.getPassword().equals(user.getPassword()))?true:false;
    }
}
