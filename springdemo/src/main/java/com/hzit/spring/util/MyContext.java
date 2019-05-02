package com.hzit.spring.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Component
public class MyContext {
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.maxactive}")
    private int maxactive;
    @Value("${jdbc.MaxIdle}")
    private  int MaxIdle;
    @Value("${jdbc.InitialSize}")
    private int InitialSize;
    @Value("${jdbc.password}")
    private String password;

    @Bean
    public DataSource dbcp(){
        BasicDataSource bds = new BasicDataSource();
        bds.setDriverClassName(driver);
        bds.setMaxActive(maxactive);
        bds.setMaxIdle(MaxIdle);
        bds.setUrl(url);
        bds.setUsername(username);
        bds.setPassword(password);
        bds.setInitialSize(InitialSize);
        return bds;
    }

    @Bean
    public DataSource c3p0(){
        ComboPooledDataSource cpd = new ComboPooledDataSource();
        try {
            cpd.setDriverClass(driver);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        cpd.setJdbcUrl(url);
        cpd.setPassword(password);
        cpd.setUser(username);
        cpd.setMaxPoolSize(maxactive);
        cpd.setMinPoolSize(InitialSize);
        return cpd;
    }
}
