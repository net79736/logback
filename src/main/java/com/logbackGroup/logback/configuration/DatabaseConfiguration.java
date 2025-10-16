package com.logbackGroup.logback.configuration;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@ComponentScan("com.logbackGroup.logback")
@MapperScan
@EnableTransactionManagement //트랜잭션을 활성화
public class DatabaseConfiguration {

  /**
   * TRACE < DEBUG < INFO < WARN < ERROR
   */
  public DatabaseConfiguration(ApplicationContext applicationContext) {
    log.info("DatabaseConfiguration 생성자 메소드 출력(info)");
    log.debug("DatabaseConfiguration 생성자 메소드 출력(debug)");
    log.warn("DatabaseConfiguration 생성자 메소드 출력(warn)");
    log.error("DatabaseConfiguration 생성자 메소드 출력(error)");
  }

  @Bean
  @ConfigurationProperties(prefix = "spring.datasource.hikari")
  public HikariConfig hikariConfig() {
    return new HikariConfig();
  }

  @Bean
  public DataSource dataSource() {
    return new HikariDataSource(hikariConfig());
  }

  @Bean
  public SqlSessionFactory sqlSesstionFactory(DataSource dataSource)
    throws Exception {
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(dataSource);
    // sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mybatis/mapper/**/*.xml"));
//    sqlSessionFactoryBean.setMapperLocations(
//      applicationContext.getResources("classpath:/mybatis/mapper/*.xml")
//    );
    //sqlSessionFactoryBean.setConfiguration(applicationContext.getResource("classpath:/"));
    return sqlSessionFactoryBean.getObject();
  }

  @Bean
  public SqlSessionTemplate sessionTemplate(
    SqlSessionFactory sqlSessionFactory
  ) throws Exception {
    return new SqlSessionTemplate(sqlSessionFactory);
  }

  @Bean
  public PlatformTransactionManager transactionManager() {
    return new DataSourceTransactionManager(dataSource());
  }
}
