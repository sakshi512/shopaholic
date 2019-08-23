package com.shop.Shopaholic.services;

import com.shop.Shopaholic.entities.UserEntity;

public interface LoginService {
    public boolean validateUser(UserEntity user);
}
