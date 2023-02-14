package com.springboot.lolcommunity.user.dto;


import lombok.*;


public class SingleRequestDto {
    private SingleRequestDto(){}
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class EmailRequestDto{
        private String email;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class NicknameRequestDto{
        private String nickname;
    }

}
