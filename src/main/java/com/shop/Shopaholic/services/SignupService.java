package com.shop.Shopaholic.services;

import com.shop.Shopaholic.entities.UserEntity;
import com.shop.Shopaholic.repository.UserRepository;
import com.shop.Shopaholic.utilities.RoleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;


@Service
public class SignupService
{
    @Autowired
    private UserRepository userRepository;

    public void addUser(UserEntity objUser) throws ParseException {
        /* Encrypt password before adding it to database - start */
        //String encrptedPassword = encryptThisString(objUser.getPassword());
//        System.out.println("Encrypted password = " +encrptedPassword);
        //objUser.setPassword(encrptedPassword);
        /* Encrypt password before adding it to database - end */

        objUser.setRoleId(RoleTypes.valueOf("USERS").ordinal());
        LocalDate now = LocalDate.now();
        objUser.setCreationDate(now);

//        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
//        String dobStr = format1.format(objUser.getDob());
//        LocalDate parsedDOB = format1.
//        objUser.setDob(parsedDOB);
//        Date date1 = objUser.getDob();
//        LocalDate localDate = Instant.ofEpochMilli(date1.getTime())
//                .atZone(ZoneId.systemDefault())
//                .toLocalDate();
//        System.out.println("DOB = "+localDate);
        objUser.setDob(now);

        userRepository.save(objUser);
    }

}
