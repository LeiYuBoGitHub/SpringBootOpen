package com.lyb.entity;

import java.io.Serializable;

/**
 * @Auther: 野性的呼唤
 * @Date: 2019/8/7 16:58
 * @Description:
 */
public class Book implements Serializable {

    private static final long serialVersionUID = -6850327454507925890L;

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
