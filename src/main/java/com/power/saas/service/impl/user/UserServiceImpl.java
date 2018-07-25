package com.power.saas.service.impl.user;

import com.power.saas.dao.user.UserDao;
import com.power.saas.entity.user.User;
import com.power.saas.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
*
* <br>
* <b>功能：</b>用户表 UserServiceImpl<br>
* <b>作者：</b>code generator<br>
* <b>日期：</b> 2018-01-17 <br>
*/
@Service
public class UserServiceImpl implements UserService {

public final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao dao;

    @Transactional(value = "mysql",rollbackFor = Exception.class)
    public int insert(User record) {
        return dao.insert(record);
    }

    @Transactional(value = "mysql",rollbackFor = Exception.class)
    public int updateByPrimaryKey(User record) {
        return dao.updateByPrimaryKey(record);
    }

    @Transactional(value = "mysql",rollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(User record) {
        return dao.updateByPrimaryKeySelective(record);
    }

    public User selectByPrimaryKey(Long id) {
        return dao.selectByPrimaryKey(id);
    }

    @Transactional(value = "mysql",rollbackFor = Exception.class)
    public int deleteByPrimaryKey(Long id) {
        return dao.deleteByPrimaryKey(id);
    }

    public int queryByCount(User record) {
        return dao.queryByCount(record);
    }

    public List<User> queryByList(User record) {
        return dao.queryByList(record);
    }
}
