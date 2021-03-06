package com.yubo.web.entity;

import java.io.Serializable;

/**
 * @Auther: 野性的呼唤
 * @Date: 2019/8/7 16:58
 * @Description:
 */
public class Book implements Serializable {

    private static final long serialVersionUID = 5827051496481728193L;

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
