package com.rawcoder.community.dao;

import com.rawcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    // @Param - name the parameters,
    // if there is only one parameter and it has to be used in <if>, then we have to use the @Param
    int selectDiscussPostRows(@Param("userId") int userId);

}