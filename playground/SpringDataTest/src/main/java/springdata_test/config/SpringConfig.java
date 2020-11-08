package springdata_test.config;

//import org.hibernate.jpa.HibernatePersistenceProvider;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"springdata_test"})
@EnableJpaRepositories(basePackages =  {"springdata_test.repo"})
public class SpringConfig {
//
//    @Value("jdbc:postgresql://localhost:5432/test")
//    private String url;
//
//    @Value("org.postgresql.Driver")
//    private String driver;
//
//    @Value("postgres")
//    private String user;
//
//    @Value("qwerty")
//    private String password;
//
//    @Value("org.hibernate.dialect.PostgreSQL94Dialect")
//    private String dialect;
//
//    @Value("springdata_test.entity")
//    private String packageToScan;
//
//    @Bean
//    private DataSource dataSource(){
//        DriverManagerDataSource datasource = new DriverManagerDataSource();
//        datasource.setDriverClassName(driver);
//        datasource.setUrl(url);
//        datasource.setUsername(user);
//        datasource.setPassword(password);
//        return datasource;
//    }
//
//    @Bean
//    private Properties hibernateProperties () {
//        Properties hibernateProp = new Properties();
//        hibernateProp.put("hibernate.dialect",dialect);
//        hibernateProp.put("hibernate.show_sql", true);
//        hibernateProp.put("hibernate.hbm2ddl.auto", "create");
//        return hibernateProp;
//    }
//
//    @Bean
//    private EntityManagerFactory entityManagerFactory(){
//        LocalContainerEntityManagerFactoryBean emFactory = new LocalContainerEntityManagerFactoryBean();
//        emFactory.setDataSource(dataSource());
//        emFactory.setJpaProperties(hibernateProperties());
////        emFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
////        emFactory.setJpaVendorAdapter(jpaVendorAdapter());
//        emFactory.setPackagesToScan(packageToScan);
//
//        emFactory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
//
//        emFactory.afterPropertiesSet();;
////        System.out.println(packageToScan);
//        return emFactory.getNativeEntityManagerFactory();
//    }
//
//    @Bean
//    public JpaTransactionManager transactionManager() throws IOException{
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory());
////        transactionManager.setDataSource(dataSource());
//        return transactionManager;
//    }
//
//    @Bean
//    public JpaVendorAdapter jpaVendorAdapter(){
//        return new HibernateJpaVendorAdapter();
//    }

    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory() {
        LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
        factoryBean.setPersistenceUnitName("persistenceUnit");

        return factoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);

        return transactionManager;
    }
}
