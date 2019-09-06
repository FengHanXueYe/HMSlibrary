package cn.hotel.entity;

import java.io.Serializable;

/**
 * @description:物品货位实体类
 * 解：在哪个仓库的物品存放位置
 * @author: 汪志雄
 * @date: 2019-09-03 16:20
 */
public class WZXMaterialsLocation implements Serializable {
    private Integer goodsLocationNumber,stockNumber;
    private String locations;

    public Integer getGoodsLocationNumber() {
        return goodsLocationNumber;
    }

    public void setGoodsLocationNumber(Integer goodsLocationNumber) {
        this.goodsLocationNumber = goodsLocationNumber;
    }

    public Integer getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(Integer stockNumber) {
        this.stockNumber = stockNumber;
    }

    public String getLocations() {
        return locations;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }
}
