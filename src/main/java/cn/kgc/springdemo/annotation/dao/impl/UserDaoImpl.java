package cn.kgc.springdemo.annotation.dao.impl;

import cn.kgc.springdemo.annotation.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @Repository("userDao") 等价于<bean class="cn.kgc.springdemo.annotation.dao.impl.UserDaoImpl" id="userDao"/>
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser(String data) {
        System.out.println("数据存入数据库！"+data);
    }
}
