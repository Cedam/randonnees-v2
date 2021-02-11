package org.cedam.application.randonnees.appconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@Import(AppConfigDao.class)
@ComponentScans(value = { @ComponentScan("org.cedam.application.randonnees.service") })
public class AppConfigService {

}
