package com.lyb.mapper;

import com.lyb.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: 野性的呼唤
 * @Date: 2019/8/7 17:04
 * @Description:
 */

@Mapper
@Repository
public interface BookMapper {

    void insert(Book book);

    void update(Book book);

    @Select("select * from book")
    List<Book> selectList();

    @Select("select * from book where 1 = 1 " +
            "and name = #{name}")
    Book select(Book book);

    @Select("select * from book where 1 = 1 " +
            "and id = #{id}")
    Book selectById(@Param("id") Long id);
}
