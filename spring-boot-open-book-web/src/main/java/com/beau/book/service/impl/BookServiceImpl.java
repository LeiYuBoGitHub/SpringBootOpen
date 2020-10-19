package com.beau.book.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.beau.book.common.result.RestResult;
import com.beau.book.common.result.RestResultFactory;
import com.beau.book.entity.Author;
import com.beau.book.entity.Book;
import com.beau.book.mapper.AuthorMapper;
import com.beau.book.mapper.BookMapper;
import com.beau.book.service.BookService;
import com.sun.deploy.net.URLEncoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.apache.tomcat.util.http.fileupload.util.mime.MimeUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * @Auther: 野性的呼唤
 * @Date: 2019/8/7 18:11
 * @Description:
 */

@Service
public class BookServiceImpl implements BookService {

    private static Logger logger = LogManager.getLogger(BookServiceImpl.class);

    @Autowired
    BookMapper bookMapper;

    @Autowired
    AuthorMapper authorMapper;

    public RestResult add(Book book) {
        try {
            if (checkAddBook(book)) {
                bookMapper.insert(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return RestResultFactory.errorMessage("失败");
        }
        return RestResultFactory.successMessage("成功");
    }

    public RestResult update(Book book) {
        try {
            bookMapper.update(book);
        } catch (Exception e) {
            e.printStackTrace();
            return RestResultFactory.errorMessage("失败");
        }
        return RestResultFactory.successMessage("成功");
    }

    public RestResult get(Long id) {
        Book book = new Book();
        book.setId(id);
        book = bookMapper.select(book);
        if (book == null) {
            return RestResultFactory.successResult(new Book());
        }
        toAuthorView(book);
        return RestResultFactory.successResult(book);
    }

    public RestResult list() {
        List<Book> bookList = bookMapper.selectList();
        toView(bookList);
        return RestResultFactory.successResult(bookList);
    }

    /**
     * 下载
     */
    public void download(Long id, HttpServletRequest request, HttpServletResponse response) {
        try {
            InputStream inputStream = new FileInputStream(new File("C:\\Users\\野性的呼唤\\Desktop\\鬼吹灯1全本.txt"));
            OutputStream outputStream = response.getOutputStream();
            response.setContentType("application/x-download");
            response.setHeader("Content-Disposition", URLEncoder.encode("attachment;filename=鬼吹灯1全本.txt","UTF-8"));
            IOUtils.copy(inputStream, outputStream);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean checkAddBook(Book book) {
        book = bookMapper.select(book);
        return book == null;
    }

    private void toView(List<Book> bookList) {
        bookList.forEach(this::toAuthorView);
    }

    private void toAuthorView(Book book) {
        Author author = new Author();
        if (book.getAuthorId() != null) {
            author.setId(book.getAuthorId());
            author = authorMapper.select(author);
            if (author == null) {
                new Author();
            }
        }
        book.setAuthor(author);
    }
}
