package com.Shirai_Kuroko.controller;

import com.Shirai_Kuroko.model.OperationLog;
import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DataBaseController {
    public static Connection init(String JDBC,String UserName,String Password) throws Exception
    {
        Driver driver = new Driver();
        Properties properties = new Properties();
        properties.setProperty("user", UserName);
        properties.setProperty("password", Password);
        return driver.connect(JDBC, properties);
    }

    public static boolean insert(Connection connection,List<OperationLog> list) throws Exception
    {
        Statement statement = connection.createStatement();
        StringBuilder sql = new StringBuilder("insert insert into log(name,pwd) values");
        for (OperationLog operationLog:list)
        {
            sql.append("('").append(operationLog.getTime()).append("','").append(operationLog.getOperation()).append("'),");
        }
        return statement.execute(sql.substring(0,sql.toString().length()-1)+"");
    }

    public static List<OperationLog> query(Connection connection) throws Exception
    {
        List<OperationLog> operationLogList = new ArrayList<>();
        Statement statement = connection.createStatement();
        String sql = "select time,operation from log";
        ResultSet rs = statement.executeQuery(sql);
        while(rs.next()){
            operationLogList.add(new OperationLog(rs.getDate("time"),rs.getString("operation")));
        }
        rs.close();
        statement.close();
        return operationLogList;
    }
}
