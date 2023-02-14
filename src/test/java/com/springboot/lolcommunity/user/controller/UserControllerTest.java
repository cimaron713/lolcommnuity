package com.springboot.lolcommunity.user.controller;

import com.springboot.lolcommunity.user.dto.SignInRequestDto;
import com.springboot.lolcommunity.user.dto.SignInResultDto;
import com.springboot.lolcommunity.user.dto.SignUpRequestDto;
import com.springboot.lolcommunity.user.dto.UserUpdateDto;
import com.springboot.lolcommunity.user.entity.User;
import com.springboot.lolcommunity.user.repository.UserRepository;
import com.springboot.lolcommunity.user.service.UserService;
import com.springboot.lolcommunity.user.service.impl.UserServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserControllerTest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @Autowired
    UserControllerTest(UserService userService, UserRepository userRepository){
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @Test
    @DisplayName("회원가입 테스트")
    public void signUp() {
        SignUpRequestDto user1;
        user1 = SignUpRequestDto.builder()
                .email("test1@email.com")
                .nickname("test1")
                .password("testpw")
                .build();

        User savedUser = userService.signUp(user1.getEmail(), user1.getPassword(), user1.getNickname());

        assertNotNull(savedUser);
    }

    @Test
    @DisplayName("로그인 테스트")
    public void signIn() {
        SignUpRequestDto user1;
        user1 = SignUpRequestDto.builder()
                .email("test1@email.com")
                .nickname("test1")
                .password("testpw")
                .build();
        User savedUser = userService.signUp(user1.getEmail(), user1.getPassword(), user1.getNickname());
        SignInRequestDto user;
        user = SignInRequestDto.builder()
                .email("test1@email.com")
                .password("testpw")
                .build();

        SignInResultDto result = userService.signIn(user.getEmail(), user.getPassword());

        assertNotNull(result);
    }
    @Test
    public void emailDuplicateCheck() {
        SignUpRequestDto user1;
        user1 = SignUpRequestDto.builder()
                .email("test1@email.com")
                .nickname("test1")
                .password("testpw")
                .build();
        User savedUser = userService.signUp(user1.getEmail(), user1.getPassword(), user1.getNickname());

        boolean result = userService.emailDuplicateCheck(savedUser.getEmail());

        assertEquals(result, 1);

    }

    @Test
    public void nicknameDuplicateCheck() {
        SignUpRequestDto user1;
        user1 = SignUpRequestDto.builder()
                .email("test1@email.com")
                .nickname("test1")
                .password("testpw")
                .build();
        User savedUser = userService.signUp(user1.getEmail(), user1.getPassword(), user1.getNickname());

        boolean result1 = userService.nicknameDuplicateCheck("testtest");
        boolean result2 = userService.nicknameDuplicateCheck(savedUser.getNickname());

        assertEquals(result1, "true");
        assertEquals(result2, "true");
    }



    @Test
    public void userUpdate() {
        SignUpRequestDto user1;
        user1 = SignUpRequestDto.builder()
                .email("test1@email.com")
                .nickname("test1")
                .password("testpw")
                .build();
        User savedUser = userService.signUp(user1.getEmail(), user1.getPassword(), user1.getNickname());
        UserUpdateDto user = UserUpdateDto.builder()
                .email("test1@email.com")
                .nickname("change")
                .password("testpwchange")
                .build();

        userService.updateUser(user.getEmail(),user.getNickname(),user.getPassword());
        String nickname = userRepository.getByEmail("test1@email.com").getNickname();
        assertEquals(nickname, "change");
    }


}