package com.briup.dao;

import com.briup.bean.Customer;
import com.briup.util.MyBatisSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

public class test {
    @Test
    public void test1(){
        SqlSession session = null;
        try {
            session = MyBatisSqlSessionFactory.openSession();

            ICustomDao mapper = session.getMapper(ICustomDao.class);

            Customer ws = mapper.findCusByName("王啸");

            System.out.println(ws);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(session!=null)session.close();
        }
    }
    @Test
    public void test2(){
        SqlSession session = null;
        try {
            session = MyBatisSqlSessionFactory.openSession();

            ICustomDao mapper = session.getMapper(ICustomDao.class);

           Customer customer=new Customer();

           customer.setName("啸哥");
           customer.setPassword("bbbb");
           customer.setEmail("www");
           customer.setTelephone("123445");
           customer.setZipCode("12345");
           customer.setAddress("湘潭县");

          mapper.AddCustomer(customer);
          session.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(session!=null)session.close();
        }
    }
}
