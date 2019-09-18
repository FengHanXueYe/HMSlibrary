package cn.hotel.entity;

import java.io.Serializable;

/**
 * @description:实际库存实体类
 * @author: 汪志雄
 * @date: 2019-09-03 16:09
 */
public class WZXActualStock implements Serializable {
    private Integer asNumber,goodsLocationNumber,materialss;
    private String materialsId,stockNumber;

    public Integer getAsNumber() {
        return asNumber;
    }

    public void setAsNumber(Integer asNumber) {
        this.asNumber = asNumber;
    }

    public Integer getGoodsLocationNumber() {
        return goodsLocationNumber;
    }

    public void setGoodsLocationNumber(Integer goodsLocationNumber) {
        this.goodsLocationNumber = goodsLocationNumber;
    }

    public Integer getMaterialss() {
        return materialss;
    }

    public void setMaterialss(Integer materialss) {
        this.materialss = materialss;
    }


    public String getMaterialsId() {
        return materialsId;
    }

    public void setMaterialsId(String materialsId) {
        this.materialsId = materialsId;
    }

    public String getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(String stockNumber) {
        this.stockNumber = stockNumber;
    }
}
