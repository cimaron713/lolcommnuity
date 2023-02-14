package com.springboot.lolcommunity.user.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserUpdateDto {
    private String email;
    private String nickname;
    private String password;
}
