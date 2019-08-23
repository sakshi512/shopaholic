package com.shop.Shopaholic.repository;

import com.shop.Shopaholic.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public interface LoginRepository extends JpaRepository<UserEntity,Integer>{

    @Query("FROM UserEntity WHERE email = ?1")
    UserEntity findByEmailId(String emailId);
}
