package com.power.saas.controller.socket;

import com.power.socket.NoticeWebStocket;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by Long on 2018/7/31.
 */
@Controller
@RequestMapping("/api")
public class socketController {

    @RequestMapping(value = "/free/sendMessage", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> sendMessage(@RequestParam(value = "userId") String userId,
                                            @RequestParam(value = "content") String content) {
        Map<String, Object> map = new HashMap<String, Object>();

        ConcurrentMap<String, NoticeWebStocket> noticeWebStockets = NoticeWebStocket.getWebStocketSet();
        try {
            map.put("status", 0);
            NoticeWebStocket noticeWebStocket = noticeWebStockets.get(userId);
            if (null != noticeWebStocket) {
                noticeWebStocket.sendMessage(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
            map.put("status", -1);
        }
        return map;
    }

}
