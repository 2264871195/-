package com.briup.service;

import com.briup.bean.Customer;
import com.briup.exception.CustomerException;

//跟客户业务逻辑相关
public interface ICustomerService {
    //注册
    public void  register(Customer customer) throws CustomerException;
    //登录
    public void login(String name,String password)throws CustomerException;
    //修改资料

    //忘记密码

}
