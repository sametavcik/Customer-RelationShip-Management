package com.samet.springboot.thymeleafdemo.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration  // config olduğunu belirtiyoruz
@EnableJpaRepositories(basePackages={"${spring.data.jpa.repository.packages}"}) // birden fazla DataSource implemente edildiğini söyleyen annotation
public class DemoDataSourceConfig {
	
	@Primary  // mevcut @repository anatasyonu bu datasource ile bağlanıyor
	@Bean  
	@ConfigurationProperties(prefix="app.datasource")  // app properties dosyasındaki app.datasource ile başlayan bütün propertylerin bu data source'a ait olduğu belirtiliyor ve jdbc connection oluyor
	public DataSource appDataSource() {
		return DataSourceBuilder.create().build();
	}


	@Bean
	@ConfigurationProperties(prefix="security.datasource") // security.datasource bağlanıyor ve  jdbc connection oluyor
	public DataSource securityDataSource() {
		return DataSourceBuilder.create().build();
	}
}
