package rouse.richard.tools.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "sql")
public class HibernatePropsConfig {

    private String username;

    private String password;

    private String db;

    private String host;

    private int port;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "HibernatePropsConfig{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", db='" + db + '\'' +
                ", host='" + host + '\'' +
                ", port=" + port +
                '}';
    }
}
