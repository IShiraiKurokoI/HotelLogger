package com.Shirai_Kuroko;

import com.Shirai_Kuroko.controller.DataBaseController;
import com.Shirai_Kuroko.model.OperationLog;

import java.sql.Connection;
import java.util.List;

public class HotelLogger {

    private static HotelLogger hotelLogger;
    private Connection connection;
    private boolean IsReady = false;

    public static HotelLogger GetInstance() {
        if (hotelLogger == null) {
            hotelLogger = new HotelLogger();
        }
        return hotelLogger;
    }

    public void init(String JDBC, String UserName, String Password) throws Exception {
        connection = DataBaseController.init(JDBC, UserName, Password);
        IsReady = true;
    }

    public void destroy() throws Exception {
        connection.close();
    }

    public List<OperationLog> query() throws Exception {
        if (!IsReady) {
            throw new Exception("数据库链接尚未初始化");
        }
        return DataBaseController.query(connection);
    }

    public boolean insert(List<OperationLog> list) throws Exception {
        if (!IsReady) {
            throw new Exception("数据库链接尚未初始化");
        }
        return DataBaseController.insert(connection, list);
    }
}
