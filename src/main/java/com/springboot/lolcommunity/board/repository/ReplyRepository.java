package com.springboot.lolcommunity.board.repository;


import com.springboot.lolcommunity.board.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    Reply getByRno(Long rno);
    void deleteByRno(Long rno);
}
