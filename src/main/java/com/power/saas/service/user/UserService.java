package com.power.saas.service.user;

import com.power.saas.entity.user.User;

import java.util.List;
/**
 * 
 * <br>
 * <b>功能：</b>用户表 UserService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-01-17 <br>
 */
public interface UserService{

    int insert(User record);

    int updateByPrimaryKey(User record);

    int updateByPrimaryKeySelective(User record);

    User selectByPrimaryKey(Long id);

    int deleteByPrimaryKey(Long id);

    int queryByCount(User user);

    List<User> queryByList(User user);

}
