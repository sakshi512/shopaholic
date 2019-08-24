package com.shop.Shopaholic.services;

import com.shop.Shopaholic.utilities.RoleTypes;
import com.shop.Shopaholic.entities.UserEntity;
import com.shop.Shopaholic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import static com.shop.Shopaholic.utilities.Password.encryptThisString;


@Service
public class SignupService
{
    @Autowired
    private UserRepository userRepository;

    public void addUser(UserEntity objUser)
    {
        /* Encrypt password before adding it to database - start */
        String encrptedPassword = encryptThisString(objUser.getPassword());
//        System.out.println("Encrypted password = " +encrptedPassword);
        objUser.setPassword(encrptedPassword);
        /* Encrypt password before adding it to database - end */

        objUser.setRoleId(RoleTypes.valueOf("USERS").ordinal());
        LocalDate now = LocalDate.now();
        objUser.setCreationDate(now);
        objUser.setDob(now);

        userRepository.save(objUser);
    }

}
