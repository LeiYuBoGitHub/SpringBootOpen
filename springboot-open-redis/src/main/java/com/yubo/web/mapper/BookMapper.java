package com.yubo.web.mapper;

import com.yubo.web.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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

    @Update("update book set name = #{name} where 1 = 1 and id = #{id}")
    void update(Book book);

    @Select("select * from book where 1 = 1 and id = #{id}")
    Book selectByBook(Book book);

    @Select("select * from book")
    List<Book> selectList();

}
