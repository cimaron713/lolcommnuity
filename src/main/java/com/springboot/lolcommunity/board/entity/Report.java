package com.springboot.lolcommunity.board.entity;

import com.springboot.lolcommunity.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name="report")
@NoArgsConstructor
public class Report extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_num", nullable=false)
    private long report_num;

    @ManyToOne
    @JoinColumn(name = "report_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "report_post")
    private Post post;

    @Column(name = "report_content", nullable = false)
    private String content;
}
