package com.src.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.src.model.BookDAOImp;

@Configuration 
@ComponentScan (basePackages = "com.src.*") // instead of <context:component-scan base-package="com.src"/>
@EnableWebMvc
public class BookManagementConfiguration extends WebMvcConfigurerAdapter{
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		super.addResourceHandlers(registry);
		
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        System.out.println("It's here");
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
    
    @Bean
    public BookDAOImp getBookDAOImp() {
    	BookDAOImp bookDAOImp = new BookDAOImp();
    	return bookDAOImp;
    }
    
    @Bean
    public DataSource getDataSource() {
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
    	
    	dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/db_book");
		dataSource.setUsername("root");
		dataSource.setPassword("");

    	return dataSource;
    }
    
}
