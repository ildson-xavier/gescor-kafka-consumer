package br.com.gescor.gescorkafka.config;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.gescor.gescorkafkaconsumer.model.Parameter;


@Component
@Configuration
@ComponentScan(basePackages = { "br.com.gescor.gescorkafka.*" })
@EnableTransactionManagement
@PropertySource({ "classpath:parameters.properties" })
public class BeanConfig {

	@Autowired
	private Environment env;
	
	@Bean
	public Parameter setParameters() {
		Parameter parameter = new Parameter();
		parameter.setPathDB(env.getProperty("DIR_BD"));
		parameter.setUrlAddConf(env.getProperty("URL_ADD_CONF"));
		parameter.setUrlAddSeg(env.getProperty("URL_ADD_SEG"));
		parameter.setUrlConsConf(env.getProperty("URL_CONS_CONF"));
		return parameter;
	}
	
}
