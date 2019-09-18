package cn.hotel.vo;

import cn.hotel.entity.DataStatus;
import cn.hotel.entity.WZXSupplierInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: 汪志雄
 * @date: 2019-09-08 16:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialsInfoVO implements Serializable {
    private Integer materialsId,isStockAlam,materialsDisable,materialsStatus;
    private String materialsBarCode,materialsName,materialsStandard,materialsModel,materialsProducts,typeCode,materialsNumber;
    private Double materialsUnitPrice,materialsPrices;
    private Date materialsStartDate,materialsEndDate;
    private WZXSupplierInfo wzxSupplierInfo;

    private List<DataStatus> statusList;
}
