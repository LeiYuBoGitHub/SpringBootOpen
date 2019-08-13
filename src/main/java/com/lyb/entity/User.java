package com.lyb.entity;

import java.io.Serializable;

/**
 * @Auther: 野性的呼唤
 * @Date: 2019/8/8 16:32
 * @Description:
 */
public class User implements Serializable {

    private static final long serialVersionUID = -6286792623510071724L;

    private Long id;

    private String account;

    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
