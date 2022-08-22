package com.Shirai_Kuroko;

import com.Shirai_Kuroko.model.OperationLog;
import com.alibaba.fastjson.JSON;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

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
        //ToDo:修改初始化数据库链接
        try {
            HotelLogger.GetInstance().init("jdbc:mysql://localhost:3306/hotel?serverTimezone=GMT","root","114514");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        SpringApplication.run(LoggerApplication.class, args);
    }
}
