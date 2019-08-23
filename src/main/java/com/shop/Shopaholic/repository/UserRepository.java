package com.shop.Shopaholic.repository;

import com.shop.Shopaholic.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer>
{

}
