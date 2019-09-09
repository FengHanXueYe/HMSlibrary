package cn.hotel.hms.mapper;

/**
 * @description:
 * @author: 汪志雄
 * @date: 2019-09-08 14:58
 */
public interface MaterialsLocationMapper {
    /**
     * 删除货位
     * @param goodsLocationNumber
     * @return
     */
    Integer delMaterialsLocation(Integer goodsLocationNumber);
}
