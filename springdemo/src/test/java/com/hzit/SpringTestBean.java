package com.hzit;

import com.hzit.spring.services.Computer;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestBeans.class)
@ComponentScan("com.hzit")
@PropertySource("application.properties")
public class SpringTestBean {
    @Autowired
    ApplicationContext ac;
    @Test
    public void t1(){
        Computer bean = ac.getBean(Computer.class);
        bean.ranTime();
    }
    @Test
    public void t2(){
        for (String s : ac.getBeanDefinitionNames()) {
            System.out.println("对象名："+s);
        }
        BasicDataSource dbcp = (BasicDataSource)ac.getBean("dbcp");
        try {
            System.out.println("DBCP连接对象"+dbcp.getConnection());
            System.out.println("最大连接数"+dbcp.getMaxActive());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void t3(){
        ComboPooledDataSource c3p0 = (ComboPooledDataSource)ac.getBean("c3p0");
        try {
            System.out.println("C3P0连接对象"+c3p0.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
