package cn.hotel.entity;

import java.io.Serializable;

/**
 * @description: 库房实体类
 * @author: 汪志雄
 * @date: 2019-09-03 16:25
 */
public class WZXStockInfo implements Serializable {
    private Integer stockId;
    private String stockName,responsibilityPerson,stockAddress;


    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getResponsibilityPerson() {
        return responsibilityPerson;
    }

    public void setResponsibilityPerson(String responsibilityPerson) {
        this.responsibilityPerson = responsibilityPerson;
    }

    public String getStockAddress() {
        return stockAddress;
    }

    public void setStockAddress(String stockAddress) {
        this.stockAddress = stockAddress;
    }
}
