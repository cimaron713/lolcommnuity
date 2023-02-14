package com.springboot.lolcommunity.board.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name="image")
@NoArgsConstructor
public class Image extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_num", nullable=false)
    private long ino;

    @Column(name = "image_name", nullable = false)
    private String iname;

    @Column(name = "image_url", nullable = false)
    private String iurl;
}
