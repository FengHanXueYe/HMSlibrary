package cn.hotel.dto;

import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: 汪志雄
 * @date: 2019-09-17 21:06
 */
@Data
public class Img {
    private String name;
    private String path;
    private Date date;
    public Img() {
    }

    public Img(String path, Date date) {
        this.path = path;
        this.date = date;
    }

    public Img(String name, String path, Date date) {
        this.name = name;
        this.path = path;
        this.date = date;
    }


    @Override
    public String toString() {
        return "Img{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", date=" + date +
                '}';
    }
}
