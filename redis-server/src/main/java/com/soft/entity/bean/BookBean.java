package com.soft.entity.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * @Auther: 野性的呼唤
 * @Date: 2019/8/7 16:58
 * @Description:
 */
@TableName(value = "book")
public class BookBean implements Serializable {

    private static final long serialVersionUID = 3757955829533440326L;

    /**
     * 主键
     * 指定自增策略
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    @TableField(value = "book_name")
    private String bookName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
