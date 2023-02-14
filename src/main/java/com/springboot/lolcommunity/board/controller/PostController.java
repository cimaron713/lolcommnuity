package com.springboot.lolcommunity.board.controller;

import com.springboot.lolcommunity.board.dto.*;
import com.springboot.lolcommunity.board.entity.Post;
import com.springboot.lolcommunity.board.service.PostService;
import com.springboot.lolcommunity.user.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class PostController {

    private final PostService postService;
    private final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping(value = "/")
    public List<PostListDto> postList() throws Exception{
        LOGGER.info("[postList] 게시글 목록 조회");
        List<PostListDto> postList = postService.postList();
        LOGGER.info("[postList] 게시글 목록 조회 완료");
        return postList;
    }

    @PostMapping(value = "/write")
    public Post postWrite(@RequestBody PostRequestDto postRequestDto){
        LOGGER.info("[postWrite] 데이터 확인");
        Post post = postService.postSave(postRequestDto);
        LOGGER.info("[postWrite] 게시글 작성 완료");
        return post;
    }

    @GetMapping(value = "/{pno}")
    public PostResult postGet(@PathVariable Long pno){
        PostResult result = postService.postGet(pno);
        LOGGER.info("[postGet] 게시글 조회 완료");
        return result;
    }

    @PutMapping (value = "/modify/{pno}")
    public Boolean postModify(@PathVariable Long pno, @RequestBody PostModifyDto postModifyDto){
        LOGGER.info("[postModify] 게시글 수정");
        boolean check = postService.postModify(pno,postModifyDto);
        if(check){
            LOGGER.info("[postModify] 게시글 수정 완료");
        }
        return check;
    }

    @DeleteMapping(value = "/delete/{pno}")
    public Boolean postDelete(@PathVariable Long pno, @RequestBody PostDeleteDto postDeleteDto){
        LOGGER.info("[postDelete] 게시글 삭제");
        boolean check = postService.postDelete(pno, postDeleteDto);
        if(check){
            LOGGER.info("[postDelete] 게시글 삭제 완료");
        }
        return check;
    }
}
