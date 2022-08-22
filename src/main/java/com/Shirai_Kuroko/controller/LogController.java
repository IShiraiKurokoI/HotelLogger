package com.Shirai_Kuroko.controller;

import com.Shirai_Kuroko.HotelLogger;
import com.Shirai_Kuroko.model.OperationLog;
import com.Shirai_Kuroko.model.Response;
import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.util.List;

/**
 * @author Shirai_Kuroko
 * @version 1.0.0
 * @ClassName LogController.java
 * @Description TODO
 * @createTime 2022年08月22日 16:14
 */

@CrossOrigin
@RestController
@RequestMapping("/log")
public class LogController {

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    @ResponseBody
    public String query(@RequestBody String Msg) {
        try {
            return JSON.toJSONString(new Response(0,"Success",HotelLogger.GetInstance().query()));
        } catch (Exception e) {
            return JSON.toJSONString(new Response(-1,e.toString(),null));
        }
    }

    @RequestMapping(value = "/newlog", method = RequestMethod.POST)
    @ResponseBody
    public String write(@RequestBody String Msg) {
        String PostBody = URLDecoder.decode(Msg);
        try {
            List<OperationLog> list = JSON.parseArray(PostBody, OperationLog.class);
            System.out.println(JSON.toJSONString(list));
            HotelLogger.GetInstance().insert(list);
            return JSON.toJSONString(new Response(0,"Success",null));
        } catch (Exception e) {
            System.out.println(e.toString());
            return JSON.toJSONString(new Response(-1,e.toString(),null));
        }
    }
}
