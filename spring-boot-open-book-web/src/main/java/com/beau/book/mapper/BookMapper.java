package com.beau.book.mapper;

import com.beau.book.entity.Book;
import org.apache.ibatis.annotations.Mapper;
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

    Book select(Book book);

    List<Book> selectList();

}
