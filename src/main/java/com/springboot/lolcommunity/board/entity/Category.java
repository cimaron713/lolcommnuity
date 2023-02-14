package com.springboot.lolcommunity.board.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name="category")
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_num", nullable=false)
    private long cno;

    @Column(name = "category_name", nullable = false)
    private String cname;

    @ManyToOne
    @JoinColumn(name = "board")
    private Board board;

}
