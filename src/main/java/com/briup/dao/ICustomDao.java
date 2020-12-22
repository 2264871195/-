package com.briup.dao;

import com.briup.bean.Customer;

//映射接口
public interface ICustomDao {
    //根据名字查找该Customer
    public Customer findCusByName(String name)throws Exception;
    //添加Customer
    public void AddCustomer(Customer customer);
}
