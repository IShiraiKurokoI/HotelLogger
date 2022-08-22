package com.Shirai_Kuroko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Shirai_Kuroko
 * @version 1.0.0
 * @ClassName com.Shirai_Kuroko.LoggerApplication.java
 * @Description TODO
 * @createTime 2022年08月22日 15:58
 */
@SpringBootApplication
public class LoggerApplication {
    public static void main(String[] args) {
        //ToDo:初始化数据库链接
        //HotelLogger.GetInstance().init("","","");
        SpringApplication.run(LoggerApplication.class, args);
    }
}
