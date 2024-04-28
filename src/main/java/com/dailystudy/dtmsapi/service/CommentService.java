package com.dailystudy.dtmsapi.service;

import com.dailystudy.dtmsapi.domain.Comment;
import com.dailystudy.dtmsapi.domain.Image;
import com.dailystudy.dtmsapi.domain.User;
import com.dailystudy.dtmsapi.dto.CommentDto;
import com.dailystudy.dtmsapi.exception.CustomValidationApiException;
import com.dailystudy.dtmsapi.mapper.CommentMapper;
import com.dailystudy.dtmsapi.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService {
    Logger log = LoggerFactory.getLogger(CommentService.class);
    private final CommentMapper commentMapper;
    private final UserMapper userMapper;

    public Comment commentSave(String content, int imageId, int userId) {

//        return commentMapper.commentSave(content, imageId, userId); xml코드에 parameterType="Comment" 하려면 entity 만들어서 넘겨야함, int만 넘긴다면 왼쪽코드처럼 사용해도 됨.
        Comment commentEntity = new Comment();
        commentEntity.setContent(content);

//        comment에 property가 image이므로. image객체 생성해서 imageId전달
        Image image = new Image();
        image.setId(imageId);

        User user = userMapper.selectUser(userId)
                .orElseThrow(() -> {
                    return new CustomValidationApiException("찾을 수 없는 id입니다.");
                });
        user.setId(userId);

        commentEntity.setImage(image);
        commentEntity.setUser(user);

        // 댓글 저장
        commentMapper.commentSave(commentEntity);
//        log.info("=================commentEntity:{}", commentEntity);
        return commentMapper.commentInfo(commentEntity.getId());
    }

    public void commentDelete(int id) {
        commentMapper.commentDelete(id);
    }
}
