package com.briup.service.impl;

import com.briup.bean.Customer;
import com.briup.dao.ICustomDao;
import com.briup.exception.CustomerException;
import com.briup.service.ICustomerService;
import com.briup.util.MyBatisSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;

public class CustomerServiceImpl implements ICustomerService {
    private SqlSession session;

    public CustomerServiceImpl(){
        session= MyBatisSqlSessionFactory.openSession();
    }
    @Override
    public void register(Customer customer) throws CustomerException {
        //调用dao层的方法
        //映射接口的实现类
        ICustomDao mapper = session.getMapper(ICustomDao.class);

        try {
            Customer nCus = mapper.findCusByName(customer.getName());
            if (nCus!=null){
                throw new Exception("用户名已经被占用,请重新输入");
            }
            mapper.AddCustomer(customer);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
            throw new CustomerException(e.getMessage());
        }

    }

    @Override
    public void login(String name, String password) throws CustomerException {
        //调用dao层中的方法
        ICustomDao mapper = session.getMapper(ICustomDao.class);
        try {
            Customer customer = mapper.findCusByName(name);
            if (customer==null){
                throw new CustomerException("该用户不存在,请重新输入用户名");
            }else {
                if (!password.equals(customer.getPassword())){
                    System.out.println(password);
                    System.out.println(customer.getPassword());
                    throw new CustomerException("密码错误,请重新输入密码");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomerException(e.getMessage());
        }
    }
}
