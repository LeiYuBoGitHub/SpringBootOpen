package com.yubo.book.mapper;

import com.yubo.book.entity.Book;
import org.apache.ibatis.annotations.Mapper;
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

    Book select(Book book);

    @Select("select * from book")
    List<Book> selectList();

}
