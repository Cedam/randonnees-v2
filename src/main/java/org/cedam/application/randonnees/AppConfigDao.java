package org.cedam.application.randonnees;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
//@Import(value = { org.cedam.application.randonnees.entity.config.AppConfig.class })
//@ContextConfiguration(classes = org.cedam.application.randonnees.entity.config.AppConfig.class)
@EnableJpaRepositories(basePackages = {"org.cedam.application.randonnees"})
@ComponentScan(basePackages = {"org.cedam.application.randonnees"})
//@ComponentScan(basePackages = {"org.cedam.application.randonnees.dao", "org.cedam.application.randonnees.entity"})
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
