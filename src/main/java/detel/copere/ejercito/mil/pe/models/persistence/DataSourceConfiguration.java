package detel.copere.ejercito.mil.pe.models.persistence;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("detel.copere.ejercito.mil.pe.models.dao")
@ComponentScan("detel.copere.ejercito.mil.pe*")

public class DataSourceConfiguration {
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		HibernateJpaVendorAdapter jpaAdapter = new HibernateJpaVendorAdapter();
		// jpaAdapter.setShowSql(Boolean.TRUE);
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(jpaAdapter);
		factory.setPackagesToScan(new String[] { "detel.copere.ejercito.mil.pe.models.entity" });
		factory.setDataSource(dataSource());
		factory.setJpaProperties(addProperties());
		factory.afterPropertiesSet();
		factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
		return factory.getObject();
	}

	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource driver = new DriverManagerDataSource();
		driver.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		driver.setUrl("jdbc:oracle:thin:@prod-scan.ep.mil.pe:1521/BDCOPERE");
		// driver.setUsername("PARTEDIARIO");
		// driver.setPassword("SPAD2020COPERED3T3L");
//		driver.setUsername("appusrservicios");
//		driver.setPassword("apu35gegm");
//		driver.setUsername("EXTRANET21");
//		driver.setPassword("123456");
		driver.setUsername("SITRAD");
		driver.setPassword("SITRAD21");

		return driver;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		EntityManagerFactory emf = entityManagerFactory();
		return new JpaTransactionManager(emf);
	}

	@Bean
	public HibernateExceptionTranslator hibernateExceptionTranslator() {
		return new HibernateExceptionTranslator();
	}

	Properties addProperties() {

		Properties propiedad = new Properties();
		propiedad.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		propiedad.setProperty("hibernate.hbm2ddl.auto", "update");
		propiedad.setProperty("hibernate.show_sql", "true");
		propiedad.setProperty("hibernate.format_sql", "true");
		return propiedad;
	}
}
