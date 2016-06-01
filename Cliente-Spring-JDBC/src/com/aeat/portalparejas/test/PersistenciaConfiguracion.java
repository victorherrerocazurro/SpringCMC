package com.aeat.portalparejas.test;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;

import com.aeat.portalparejas.modelo.entidades.Persona;

@Configuration
public class PersistenciaConfiguracion {

	@Bean
	public AnnotationSessionFactoryBean sf(){
		AnnotationSessionFactoryBean sessionFactory =  new AnnotationSessionFactoryBean();
		
		Properties properties = new Properties();
		
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.DerbyDialect");
		properties.setProperty("hibernate.show_sql", "false");
		properties.setProperty("hibernate.format_sql", "true");
		properties.setProperty("hibernate.current_session_context_class", "thread");
		properties.setProperty("hibernate.hbm2ddl.auto", "create");
		properties.setProperty("hibernate.default_schema", "PORTALPAREJAS");
		
		sessionFactory.setHibernateProperties(properties);
		sessionFactory.setDataSource(Configuracion.ds());
		sessionFactory.setAnnotatedClasses(new Class[]{Persona.class});
		
		return sessionFactory;
	}
	
}
