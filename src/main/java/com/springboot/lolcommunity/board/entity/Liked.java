package com.springboot.lolcommunity.board.entity;

import com.springboot.lolcommunity.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name="liked")
@NoArgsConstructor
public class Liked extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "liked_num", nullable=false)
    private long lno;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post")
    private Post post;
}
