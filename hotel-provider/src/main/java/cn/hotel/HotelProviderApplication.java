package cn.hotel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("cn.hotel.hms.mapper")
@SpringBootApplication
public class HotelProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelProviderApplication.class, args);
    }

}
