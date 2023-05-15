package org.ua.javaPro.berezhnoy.hillelHomeWork25Hibernate;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@ComponentScan({"org.ua.javaPro.berezhnoy.hillelHomeWork24SpringCore",
        "org.ua.javaPro.berezhnoy.hillelHomeWork25Hibernate"})
public class HibernateSession {
    @Bean
    public LocalSessionFactoryBean sessionFactory(@Autowired DataSource dataSource) {
        var sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan("org.ua.javaPro.berezhnoy.hillelHomeWork25Hibernate");

        return sessionFactory;
    }
}
