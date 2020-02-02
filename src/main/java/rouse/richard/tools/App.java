package rouse.richard.tools;

import lombok.extern.slf4j.Slf4j;
import rouse.richard.tools.models.Hook;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import rouse.richard.tools.config.HibernateConfig;

@Slf4j
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class
})
@EnableTransactionManagement
public class App implements InitializingBean {

    @Autowired
    private HibernateConfig hibernateConfig;

    @Autowired
    private SessionFactory sessionFactory;

    public static void main(String[] args){

        ApplicationContext ctx = SpringApplication.run(App.class);
        log.debug("fuck");
        log.info("info-fuck");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Hook hook = new Hook();

    }
}
