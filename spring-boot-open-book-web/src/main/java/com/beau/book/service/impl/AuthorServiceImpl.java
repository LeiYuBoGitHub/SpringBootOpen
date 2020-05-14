package com.beau.book.service.impl;

import com.beau.book.common.result.RestResult;
import com.beau.book.common.result.RestResultFactory;
import com.beau.book.entity.Author;
import com.beau.book.mapper.AuthorMapper;
import com.beau.book.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: 野性的呼唤
 * @Date: 2020/5/14 17:28
 * @Description:
 */

@Transactional
@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorMapper authorMapper;

    public RestResult add(Author author) {
        try {
            authorMapper.insert(author);
        } catch (Exception e) {
            e.printStackTrace();
            return RestResultFactory.errorMessage("失败");
        }
        return RestResultFactory.successMessage("成功");
    }

    public RestResult get(Long id) {
        return null;
    }

    public RestResult list() {
        List<Author> authorList = authorMapper.selectList();
        return RestResultFactory.successResult(authorList);
    }
}
