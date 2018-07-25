package com.power.saas.controller.user;

import com.power.saas.common.ApiResult;
import com.power.saas.entity.user.User;
import com.power.saas.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Yan on 2018/1/17.
 */
@Controller
@RequestMapping(value="/api")
public class UserController {

    public final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{version}/{tenantCode}/user/find", method = RequestMethod.GET)
    @ResponseBody
    public ApiResult find(String id){
        ApiResult apiResult = new ApiResult();
        try {
            User user = userService.selectByPrimaryKey(Long.parseLong(id));
            apiResult.setData(user);
            apiResult.setErrorCode(0);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e + "");
            apiResult.setErrorCode(-1);
        }
        return apiResult;
    }
}
