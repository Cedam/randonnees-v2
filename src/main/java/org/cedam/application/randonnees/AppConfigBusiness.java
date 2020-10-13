package org.cedam.application.randonnees;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("org.cedam.application.randonnees"), 
		@ComponentScan("org.cedam.application.randonnees.dao"), 
		@ComponentScan("org.cedam.application.randonnees.business")})
public class AppConfigBusiness {

//	   @Bean
//	   public LocalEntityManagerFactoryBean geEntityManagerFactoryBean() {
//	      LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
//	      factoryBean.setPersistenceUnitName("LOCAL_PERSISTENCE");
//	      return factoryBean;
//	   }
//
//	   @Bean
//	   public JpaTransactionManager geJpaTransactionManager() {
//	      JpaTransactionManager transactionManager = new JpaTransactionManager();
//	      transactionManager.setEntityManagerFactory(geEntityManagerFactoryBean().getObject());
//	      return transactionManager;
//	   }
}
