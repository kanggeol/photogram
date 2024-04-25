package com.dailystudy.dtmsapi.mapper;

import com.dailystudy.dtmsapi.domain.Image;
import org.apache.ibatis.annotations.Mapper;

import java.nio.file.Path;

@Mapper
public interface ImageMapper {
    void saveImage(Image imageEntity);
}
