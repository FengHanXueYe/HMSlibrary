package cn.hotel.dto;

import lombok.Data;

/**
 * @description:
 * @author: 汪志雄
 * @date: 2019-09-17 21:09
 */
@Data
public class UploadResponseData {
    private Integer code;
    private String msg;
    private Object data;

    public UploadResponseData(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

}
