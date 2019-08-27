package com.shop.Shopaholic.services;

import com.shop.Shopaholic.entities.LoginEntity;
import com.shop.Shopaholic.entities.UserEntity;

import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

public interface LoginService {
    public Optional<UserEntity> validateUser(LoginEntity user) throws UnsupportedEncodingException, NoSuchAlgorithmException;
    public boolean isAdminUser(int roleId);
}
