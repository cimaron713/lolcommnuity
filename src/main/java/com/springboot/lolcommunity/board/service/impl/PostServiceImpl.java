package com.springboot.lolcommunity.board.service.impl;

import com.springboot.lolcommunity.board.dto.*;
import com.springboot.lolcommunity.board.entity.Board;
import com.springboot.lolcommunity.board.entity.Post;
import com.springboot.lolcommunity.board.repository.BoardRepository;
import com.springboot.lolcommunity.board.repository.PostRepository;
import com.springboot.lolcommunity.board.service.PostService;
import com.springboot.lolcommunity.user.entity.User;
import com.springboot.lolcommunity.user.repository.UserRepository;
import com.springboot.lolcommunity.user.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository, BoardRepository boardRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.boardRepository = boardRepository;
    }
    private final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);


    public PostDto.PostResult postSave(PostDto.PostRequestDto postRequestDto){
        User user = userRepository.getByEmail(postRequestDto.getWriter());
        Board board = boardRepository.getByBno(1L);
        Post post = Post.builder()
                .title(postRequestDto.getTitle())
                .writer(user)
                .content(postRequestDto.getContent())
                .board(board)
                .build();
        postRepository.save(post);
        PostDto.PostResult result = PostDto.PostResult.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .writer(post.getWriter().getNickname())
                .build();
        return result;
    }

    public PostDto.PostResult postGet(Long pno){
        Post post = postRepository.getByPno(pno);
        PostDto.PostResult result = PostDto.PostResult.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .writer(post.getWriter().getNickname())
                .build();
        return result;
    }
    public Boolean postModify(Long pno, PostDto.PostModifyDto postModifyDto){
        Post post = postRepository.getByPno(pno);
        if(postModifyDto.getWriter().equals(post.getWriter().getEmail())){
            post.setTitle(postModifyDto.getTitle());
            post.setContent(postModifyDto.getContent());
            postRepository.save(post);
            return true;
        }
        else{
            LOGGER.info("[postModify] 회원 정보가 일치하지 않음");
            return false;
        }
    }

    public Boolean postDelete(Long pno, PostDto.PostDeleteDto postDeleteDto){
        Post post = postRepository.getByPno(pno);
        if(postDeleteDto.getWriter().equals(post.getWriter().getEmail())){
            postRepository.deleteByPno(pno);
            return true;
        }
        else{
            LOGGER.info("[postModify] 회원 정보가 일치하지 않음");
            return false;
        }

    }

    public List<PostDto.PostListDto> postList(){
        List<Post> posts = postRepository.findAll(Sort.by(Sort.Direction.DESC, "pno"));
        List<PostDto.PostListDto> postList = new ArrayList<>();
        for(Post post : posts){
            PostDto.PostListDto postListDto = PostDto.PostListDto.builder()
                    .pno(post.getPno())
                    .title(post.getTitle())
                    .writer(post.getWriter().getNickname())
                    .regDate(post.getRegDate())
                    .build();
            postList.add(postListDto);
        }
        return postList;
    }
}
