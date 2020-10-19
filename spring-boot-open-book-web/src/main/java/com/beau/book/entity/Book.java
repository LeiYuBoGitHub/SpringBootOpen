package com.beau.book.entity;

/**
 * @Auther: 野性的呼唤
 * @Date: 2019/8/7 16:58
 * @Description:
 */
public class Book {

    private Long id;

    private Long authorId;

    private String bookName;

    private Author author;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
