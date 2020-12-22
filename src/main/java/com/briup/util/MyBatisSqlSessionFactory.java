package com.briup.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisSqlSessionFactory {
	
	public static SqlSessionFactory getSqlSessionFactory()
	{
		String resource="mybatis-config.xml";
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
			return factory;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static SqlSession openSession()
	{
		return getSqlSessionFactory().openSession(false);
	}
	public static SqlSession openSession(boolean auto)
	{
		return getSqlSessionFactory().openSession(auto);
	}

}
