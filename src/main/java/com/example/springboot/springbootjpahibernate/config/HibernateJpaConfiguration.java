/**
 * 
 */
package com.example.springboot.springbootjpahibernate.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author samasu5
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories (entityManagerFactoryRef="hibernateEntityManagerFactory",
transactionManagerRef="hibernateTransactionManager")
public class HibernateJpaConfiguration {

	@Autowired
	JpaVendorAdapter jpaVendorAdapter;
	
	@Autowired
	DataSource dataSource;
	
	@Bean(name = "hibernateEntityManagerFactory")
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        emf.setJpaVendorAdapter(jpaVendorAdapter);
        emf.setPackagesToScan("com.example.springboot");
        emf.setPersistenceUnitName("default");   // <- giving 'default' as name
        emf.afterPropertiesSet();
        System.out.println("EntityManagerFactory is initiated ################");
        return emf.getObject();
    }
	
	@Bean(name = "hibernateEntityManager")
	@Primary
    public EntityManager entityManager() {
		System.out.println("EntityManager is initiated .................");
        return entityManagerFactory().createEntityManager();
    }
	
	 @Bean(name = "hibernateTransactionManager")
	    public PlatformTransactionManager transactionManager() {
	        JpaTransactionManager tm = new JpaTransactionManager();
	        tm.setEntityManagerFactory(entityManagerFactory());
	        System.out.println("transaction manager is initiated ********************");
	        return tm;
	    }
}
