package org.cedam.application.randonnees.appconfig;

import java.io.IOException;

import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@Import(AppConfigBusiness.class)
@ComponentScans(value = { @ComponentScan("org.cedam.application.randonnees.controller"),
		@ComponentScan("org.cedam.application.randonnees.utils") })
public class AppConfigController {

	@Bean(name = "dozerBean")
	public DozerBeanMapperFactoryBean configDozer() throws IOException {
		DozerBeanMapperFactoryBean mapper = new DozerBeanMapperFactoryBean();
		var pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
		var resources = pathMatchingResourcePatternResolver.getResources("classpath*:dozer-bean-mappings.xml");
		mapper.setMappingFiles(resources);
		return mapper;
	}

}
