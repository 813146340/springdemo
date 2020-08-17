package cn.kgc.springdemo.annotation.dao;

public interface UserDao {
    /**
     * 模拟真实业务逻辑中的存储业务
     * @param data
     */
    public void saveUser(String data);
}
