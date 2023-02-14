package com.springboot.lolcommunity.user.repository;

import com.springboot.lolcommunity.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User getByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByNickname(String nickname);
}
