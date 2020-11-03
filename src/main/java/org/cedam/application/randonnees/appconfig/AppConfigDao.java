package org.cedam.application.randonnees.appconfig;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
@Import(AppConfigEntity.class)
@EnableJpaRepositories(basePackages = {"org.cedam.application.randonnees.dao"})
@ComponentScan(basePackages = {"org.cedam.application.randonnees.dao"})
public class AppConfigDao {
	
	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {
		LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
		//factoryBean.setPersistenceUnitName("TestDB");
		factoryBean.setPersistenceUnitName("BddRandonnee");
		return factoryBean;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);		
		return transactionManager;
	}	
}
