package com.dailystudy.dtmsapi.mapper;

import com.dailystudy.dtmsapi.domain.Comment;
import com.dailystudy.dtmsapi.domain.Image;
import com.dailystudy.dtmsapi.domain.Likes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ImageMapper {
    void saveImage(Image imageEntity);

    List<Image> imageStory(Map parameters);

    List<Image> popular();

    List<Image> imageLikesCount(int imageId);

    List<Likes> imageLikes(int imageId);

    List<Comment> imageComments(int imageId);

}
