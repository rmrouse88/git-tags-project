package rouse.richard.tools.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Slf4j
@Configuration
public class HibernateConfig implements InitializingBean {
    @Autowired
    private HibernatePropsConfig hibernatePropsConfig;

   @Bean
    public DataSource dataSource(){
       MysqlDataSource sqlDatasource = new MysqlDataSource();

       sqlDatasource.setURL(this.hibernatePropsConfig.getHost());
       sqlDatasource.setPort(this.hibernatePropsConfig.getPort());
       sqlDatasource.setUser(this.hibernatePropsConfig.getUsername());
       sqlDatasource.setPassword(this.hibernatePropsConfig.getPassword());


       return sqlDatasource;
   }

   private Properties hibernateProperties(){
       Properties hibernateProps = new Properties();
       hibernateProps.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
       hibernateProps.put("hibernate.format_sql", true);
       hibernateProps.put("hibernate.use_sql_comments", true);
       hibernateProps.put("hibernate.show_sql", true);
       hibernateProps.put("hibernate.max_fetch_depth", 3);
       hibernateProps.put("hibernate.jdbc.batch_size", 10);
       hibernateProps.put("hibernate.jdbc.fetch_size", 50);
       hibernateProps.put("hibernate.hbm2ddl.auto", "create");

       return hibernateProps;
   }

   @Bean
   public SessionFactory sessionFactory() throws IOException {
       LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
       sessionFactoryBean.setDataSource(this.dataSource());

       // MUST TELL HIBERNATE WHERE TO LOCATE OUR ENTITIES!
       sessionFactoryBean.setPackagesToScan("rouse.richard.tools.entities");
       sessionFactoryBean.setHibernateProperties(this.hibernateProperties());
       sessionFactoryBean.afterPropertiesSet();
       return sessionFactoryBean.getObject();
   }

   @Bean
    public PlatformTransactionManager platformTransactionManager() throws IOException {
       return new HibernateTransactionManager(this.sessionFactory());
   }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info(this.hibernatePropsConfig.toString());
    }
}
