package com.beau.book.entity;

/**
 * @Auther: 野性的呼唤
 * @Date: 2020/5/14 17:08
 * @Description:
 */
public class Author {

    private Long id;

    private String authorName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
