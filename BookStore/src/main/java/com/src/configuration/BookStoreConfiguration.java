package com.src.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.src.entity.Book;
import com.src.entity.User;
import com.src.model.BookDAOImp;
import com.src.model.UserDAOImp;

@Configuration
@ComponentScan(basePackages = "com.src.*") // instead of <context:component-scan
											// base-package="com.src"/>
@EnableWebMvc
@EnableTransactionManagement(proxyTargetClass = true)
public class BookStoreConfiguration extends WebMvcConfigurerAdapter {
	
	

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		super.addResourceHandlers(registry);
		registry.addResourceHandler("/resources/**").
		addResourceLocations("/resources/theme/");
	}

	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setOrder(1);
		return resolver;
	}

	@Bean
	public TilesViewResolver getTilesViewResolver() {
		TilesViewResolver view = new TilesViewResolver();

		view.setViewClass(TilesView.class);
		view.setOrder(0);
		return view;
	}

	@Bean
	public UserDAOImp getUserDAOImp(){
		UserDAOImp userDAOImp = new UserDAOImp();
		return userDAOImp;
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
		dataSource.setPassword("123");

		return dataSource;
	}

	@Autowired
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionFactory = 
				new LocalSessionFactoryBuilder(dataSource);
		sessionFactory.addProperties(getHibernateProperties());
		sessionFactory.addAnnotatedClasses(Book.class);
		sessionFactory.addAnnotatedClasses(User.class);
		
		return sessionFactory.buildSessionFactory();
	}
	
/*	@Autowired
	@Bean
	@Qualifier("sessionFactory2")
	public SessionFactory getSessionFactory2(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionFactory2 = 
				new LocalSessionFactoryBuilder(dataSource);
		sessionFactory2.addProperties(getHibernateProperties());
		sessionFactory2.addAnnotatedClasses(User.class);
		System.out.println("Session2");
		
		return sessionFactory2.buildSessionFactory();
	}
*/
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		// properties.put("hibernate.current_session_context_class", "thread");
		return properties;
	}

	@Autowired
	@Bean
	public HibernateTransactionManager transactionManagement
	(SessionFactory sessionFactory) {
		HibernateTransactionManager tx = new HibernateTransactionManager
				(sessionFactory);
		return tx;
	}

	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tile = new TilesConfigurer();
		tile.setDefinitions(new String[] { "/WEB-INF/tiles/tiles-definitions.xml" });

		return tile;
	}

	/**
	 * 
	 * Multi-language configuration
	 */
	
	@Bean(name = "localeResolver")
	public SessionLocaleResolver getSessionLocalResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		//localeResolver.setDefaultLocale(Locale.ENGLISH);
		System.out.println("getSessionLocalResolver");
		return localeResolver;

	}
	
	/*@Autowired
	LocaleChangeInterceptor localeChangeInterceptor;
	*/
	
	@Bean (name = "localeChangeInterceptor")
	public LocaleChangeInterceptor getLocalChangeIntercerptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("language");
		System.out.println("getLocalChangeIntercerptor");
		return localeChangeInterceptor;
	}
	
	/*@Autowired
	@Bean
	public ControllerClassNameHandlerMapping getControllerClassNameHandleMapping(
			LocaleChangeInterceptor localeChangeInterceptor) {
		ControllerClassNameHandlerMapping controllerClassNameHandlerMapping
							= new ControllerClassNameHandlerMapping();
		
		controllerClassNameHandlerMapping.
		setInterceptors(new LocaleChangeInterceptor[] 
				{ localeChangeInterceptor });
		System.out.println("getControllerClassNameHandleMapping");
		return controllerClassNameHandlerMapping;
	}*/

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(getLocalChangeIntercerptor());
		System.out.println("addInterceptors");
	}

	@Bean(name = "messageSource")
	public ResourceBundleMessageSource getMsgSource() {
		ResourceBundleMessageSource messageSource 
								= new ResourceBundleMessageSource();
		messageSource.setBasename("welcomepage");
		System.out.println("getMsgSource");
		
		return messageSource;
	}
}
