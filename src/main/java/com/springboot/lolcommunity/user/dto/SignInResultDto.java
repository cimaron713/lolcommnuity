package com.springboot.lolcommunity.user.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class SignInResultDto {
    private String email;
    private String password;
    private String nickname;
}