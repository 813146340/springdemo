package cn.kgc.springdemo.annotation.service.impl;

import cn.kgc.springdemo.annotation.dao.UserDao;
import cn.kgc.springdemo.annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Service("userService") 等价于<bean class="cn.kgc.springdemo.annotation.service.impl.UserServiceImpl" id="userService">
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addData(String data) {
        System.out.println("业务逻辑层...."+new Date());
        userDao.saveUser(data);
        System.out.println("业务逻辑层执行完成!");
    }
}
