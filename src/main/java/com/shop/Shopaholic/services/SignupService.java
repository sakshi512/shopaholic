package com.shop.Shopaholic.services;
import com.shop.Shopaholic.entities.UserEntity;
import com.shop.Shopaholic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class SignupService
{
    @Autowired
    UserRepository userRepository;

    public void addUser(UserEntity objUser)
    {
        objUser.setRoleId(1);
        LocalDate now = LocalDate.now();
        objUser.setCreationDate(now);
        objUser.setDob(now);
        userRepository.save(objUser);
    }

}
