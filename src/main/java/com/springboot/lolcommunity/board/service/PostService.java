package com.springboot.lolcommunity.board.service;

import com.springboot.lolcommunity.board.dto.*;
import com.springboot.lolcommunity.board.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {
    Post postSave(PostRequestDto postRequestDto);
    PostResult postGet(Long pno);
    List<PostListDto> postList();
    Boolean postModify(Long pno, PostModifyDto postModifyDto);
    Boolean postDelete(Long pno, PostDeleteDto postDeleteDto);
}
