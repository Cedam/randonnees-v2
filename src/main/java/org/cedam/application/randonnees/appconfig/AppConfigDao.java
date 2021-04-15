package org.cedam.application.randonnees.appconfig;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
@PropertySource(value = "classpath:application.properties")
@Import(AppConfigEntity.class)
@EnableJpaRepositories(basePackages = { "org.cedam.application.randonnees.dao" })
@ComponentScan(basePackages = { "org.cedam.application.randonnees.dao" })
public class AppConfigDao {

	@Value("${jdbc.dialect}")
    private String jdbcDialect;
	
	@Value("${jdbc.url}")
    private String jdbcUrl;
	
	@Value("${jdbc.user}")
    private String jdbcUser;
	
	@Value("${jdbc.password}")
    private String jdbcPassword;
	
	@Value("${jdbc.driver}")
    private String jdbcDriver;
	
	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {
		LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
		//factoryBean.setPersistenceUnitName("BddRandonnee");
		Properties props = new Properties();
		props.put("hibernate.dialect", jdbcDialect);
		props.put("javax.persistence.jdbc.url", jdbcUrl);
		props.put("javax.persistence.jdbc.user", jdbcUser);
		props.put("javax.persistence.jdbc.password", jdbcPassword);
		props.put("javax.persistence.jdbc.driver", jdbcDriver);
		factoryBean.setJpaProperties(props);
		return factoryBean;
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}
}
