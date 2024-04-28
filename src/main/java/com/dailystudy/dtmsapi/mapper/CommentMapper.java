package com.dailystudy.dtmsapi.mapper;

import com.dailystudy.dtmsapi.domain.Comment;
import com.dailystudy.dtmsapi.dto.CommentDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {

    int commentSave(Comment comment);

    Comment commentInfo(int id);

    void commentDelete(int id);
}
