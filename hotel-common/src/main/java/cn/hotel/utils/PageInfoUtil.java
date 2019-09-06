package cn.hotel.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 分页工具类（峰）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageInfoUtil<T> implements Serializable {

    private Integer pageNumF, pageSizeF, pagesF;
    private List<T> listF;
    private int[] navIgtePageNumbers;

}
