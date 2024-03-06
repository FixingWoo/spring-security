package com.repository;

import com.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// JpaRepository가 CRUD 함수를 들고 있음
// @Repository 없어도 IoC가 됨 > JpaRepository를 상속했기 때문에
@Repository
public interface UserRepository extends JpaRepository<User, Integer > {
    // findBy 규칙 -> Username 문법
    // select * from user where username= 1?
    // JPA Query Method
    public User findByUsername(String username);

}
