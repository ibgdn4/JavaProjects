package com.springbootwx.sell;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 日志测试类
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

//    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test1() {
        // 声明 logger
//        logger.debug("debug...");
//        logger.info("info...");
//        logger.error("error...");

        // @Slf4j 注解
        log.debug("debug....");
        log.info("info....");
        log.error("error....");

        String name = "wx";
        int password = 1234;
        log.debug("debug - name:{}, password:{}", name, password);
        log.info("info - name:" + name + ", password:" + password);
        log.error("error - name:{}, password:{}", name, password);
    }

/*  输出：
        2018-10-14 19:35:10.290  INFO 15712 --- [           main] test.LoggerTest         : info...
        2018-10-14 19:35:10.290 ERROR 15712 --- [           main] test.LoggerTest         : error...
    没有输出 debug 是因为设置日志的级别（org.slf4j.event.Level.java），
    info 的级别高于 debug，默认为 info 所以 debug 级别的日志不输出。
*/
}
