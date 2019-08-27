package com.shop.Shopaholic.services;

import com.shop.Shopaholic.entities.LoginEntity;
import com.shop.Shopaholic.entities.UserEntity;
import com.shop.Shopaholic.repository.LoginRepository;
import com.shop.Shopaholic.utilities.Password;
import com.shop.Shopaholic.utilities.RoleTypes;
import com.shop.Shopaholic.utilities.Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginRepository login;

    @Override
    public Optional<UserEntity> validateUser(LoginEntity user) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        UserEntity userEntity = login.findByEmailId(user.getUserName());
        return (userEntity!=null && Password.isPasswordValid(user.getPassword(),userEntity.getPassword()))?Optional.of(userEntity):Optional.empty();
    }

    @Override
    public boolean isAdminUser(int roleId) {
        return (roleId==RoleTypes.valueOf("ADMIN").getIndex());
    }



}
