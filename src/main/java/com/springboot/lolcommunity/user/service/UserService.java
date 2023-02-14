package com.springboot.lolcommunity.user.service;

import com.springboot.lolcommunity.user.dto.SignInResultDto;

import com.springboot.lolcommunity.user.entity.User;

public interface UserService {
    User signUp(String email, String password, String name);
    SignInResultDto signIn(String email, String password) throws RuntimeException;
    boolean findPw(String email) throws Exception;
    boolean emailDuplicateCheck(String email);
    boolean nicknameDuplicateCheck(String nickname);
    void updateUser(String email, String nickname, String password);

}