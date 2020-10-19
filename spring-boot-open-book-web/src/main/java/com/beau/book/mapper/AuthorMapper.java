package com.beau.book.mapper;

import com.beau.book.entity.Author;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: 野性的呼唤
 * @Date: 2020/5/13 19:18
 * @Description: 作者
 */

@Mapper
@Repository
public interface AuthorMapper {

    void insert(Author author);

    Author select(Author author);

    List<Author> selectList();
}
