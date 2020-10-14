package com.soft.entity.param;

import java.math.BigDecimal;

/**
 * @author 野性的呼唤
 * @Date: 2020/10/12 18:09
 * @Description:
 */
public class MoneyParam {

    private Long studentId;

    private BigDecimal money;

    private BigDecimal virtualMoney;

    private Integer type;

    private Integer changeType;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getVirtualMoney() {
        return virtualMoney;
    }

    public void setVirtualMoney(BigDecimal virtualMoney) {
        this.virtualMoney = virtualMoney;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getChangeType() {
        return changeType;
    }

    public void setChangeType(Integer changeType) {
        this.changeType = changeType;
    }
}
