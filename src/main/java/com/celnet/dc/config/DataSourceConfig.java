package com.celnet.dc.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
//@MapperScan 扫描 Mapper 接口并容器管理
//@Mapper 标志为 Mybatis 的并通过容器管理的 Bean。Mybatis 内部会使用反射机制运行去解析相应 SQL
//sqlSessionFactoryRef 表示定义了 key ，表示一个唯一 SqlSessionFactory 实例
@MapperScan(basePackages = DataSourceConfig.PACKAGE, sqlSessionFactoryRef = "SqlSessionFactory")
public class DataSourceConfig {

    // 精确到 master 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.celnet.dc.dao";
    static final String MAPPER_LOCATION = "classpath:mapper/*.xml";

    //@Value 获取全局配置文件 application.properties 的 kv 配置,并自动装配
    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String user;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driverClassName}")
    private String driverClass;

    @Bean(name = "DataSource")
    @Primary//@Primary 标志这个 Bean 如果在多个同类 Bean 候选时，该 Bean 优先被考虑。「多数据源配置的时候注意，必须要有一个主数据源，用 @Primary 标志该 Bean」
    public DataSource DataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "TransactionManager")
    @Primary
    public DataSourceTransactionManager TransactionManager() {
        return new DataSourceTransactionManager(DataSource());
    }

    @Bean(name = "SqlSessionFactory")
    @Primary
    public SqlSessionFactory SqlSessionFactory(@Qualifier("DataSource") DataSource masterDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(masterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(DataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
    
    @Bean(name = "TransactionManager")
    @Primary
    public PlatformTransactionManager  TransactionManager(@Qualifier("DataSource") DataSource masterDataSource) {
    	return new DataSourceTransactionManager(masterDataSource);
    }
}