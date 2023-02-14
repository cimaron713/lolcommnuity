package com.springboot.lolcommunity.board.dto;

import com.springboot.lolcommunity.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostListDto {
    private long pno;
    private String writer;
    private String title;
    private LocalDateTime regDate;
}
