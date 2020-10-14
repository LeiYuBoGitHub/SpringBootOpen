package com.soft.entity.param;

import java.math.BigDecimal;

/**
 * @author 野性的呼唤
 * @Date: 2020/10/10 18:06
 * @Description: 充值送活动接口入参
 */
public class RechargeGiveParam {

    private Long studentId;

    private BigDecimal rechargeMoney;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public BigDecimal getRechargeMoney() {
        return rechargeMoney;
    }

    public void setRechargeMoney(BigDecimal rechargeMoney) {
        this.rechargeMoney = rechargeMoney;
    }
}
