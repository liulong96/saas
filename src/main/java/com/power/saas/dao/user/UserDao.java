package com.power.saas.dao.user;

import com.power.saas.entity.user.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 
 * <br>
 * <b>功能：</b>用户表 UserDao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-01-17 <br>
 */
public interface UserDao {

    int insert(User record);

    int updateByPrimaryKey(User record);

    int updateByPrimaryKeySelective(User record);

    User selectByPrimaryKey(@Param(value = "id") Long id);

    int deleteByPrimaryKey(@Param(value = "id") Long id);

    int queryByCount(User record);

    List<User> queryByList(User record);

}
