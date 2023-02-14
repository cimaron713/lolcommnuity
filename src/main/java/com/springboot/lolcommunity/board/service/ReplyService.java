package com.springboot.lolcommunity.board.service;

import com.springboot.lolcommunity.board.dto.*;
import com.springboot.lolcommunity.board.entity.Reply;

import java.util.List;

public interface ReplyService {
    Reply replySave(Long pno, ReplyRequestDto replyRequestDto);
    Boolean replyModify(Long bno, ReplyModifyDto replyModifyDto);
    Boolean replyDelete(Long rno, ReplyDeleteDto replyDeleteDto);
    List<ReplyListDto> replyList();
}
