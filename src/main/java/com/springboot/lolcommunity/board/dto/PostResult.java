package com.springboot.lolcommunity.board.dto;


import com.springboot.lolcommunity.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostResult {
    private String writer;
    private String title;
    private String content;
}
