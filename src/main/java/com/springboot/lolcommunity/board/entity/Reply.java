package com.springboot.lolcommunity.board.entity;

import com.springboot.lolcommunity.user.entity.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@Entity
@Table(name="reply")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reply extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_num", nullable=false)
    private long rno;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "uno")
    private User writer;

    @Column(nullable = false)
    private String content;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "post")
    private Post post;
}
