package cn.hotel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description:
 * @author: 汪志雄
 * @date: 2019-09-17 17:57
 */
@SpringBootTest
@RunWith(SpringRunner.class
)
public class testdemo {

    @Test
    public void xxtest(){
        String relativelyPath=System.getProperty("user.dir");
        System.out.println("relativelyPath:"+relativelyPath);
    }
}
