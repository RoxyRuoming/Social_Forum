package com.rawcoder.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary //higher preference
public class AlphaDaoMybatisSimpl implements AlphaDao {
    @Override
    public String select() {
        return "Mybatis";
    }
}
