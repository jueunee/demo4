package com.example.demo4.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Slf4j
@Configuration
@MapperScan("com.example.demo4.dao")
public class MySQLConfig {
    @Bean
    // SqlSessionFactory : mysql와 mybatis를 연결해주는 객체
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        // SqlSessionFactoryBean : SqlSessionFactory를 생성해주는 클래스
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        // setDataSource : datasorce 참조
        sessionFactory.setDataSource(dataSource);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        // classpath --> resource 파일을 나타냄
        sessionFactory.setMapperLocations(resolver.getResources("classpath:mappers/*.xml"));

        return sessionFactory.getObject();
    }
}
