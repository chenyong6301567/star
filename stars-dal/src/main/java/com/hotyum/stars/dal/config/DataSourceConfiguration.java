package com.hotyum.stars.dal.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class DataSourceConfiguration {
	private static final Logger log = LoggerFactory.getLogger(DataSourceConfiguration.class);

    @Value("${jdbc.driverClass}")
    private String driverClass;
    
    @Value("${jdbc.url}")
    private String url;
    
    @Value("${jdbc.userName}")
    private String userName;
    
    @Value("${jdbc.password}")
    private String password;
    
    @Value("${jdbc.maxActive}")
    private int maxActive;
    
    @Value("${jdbc.maxIdel}")
    private int maxIdel;
    
    @Value("${jdbc.maxWait}")
    private long maxWait;
    
    @Value("${jdbc.removeAbandoned}")
    private boolean removeAbandoned = true;
    
    @Value("${jdbc.removeAbandonedTimeout}")
    private int removeAbandonedTimeout = 180;
    
    @Value("${jdbc.logAbandoned}")
    private boolean logAbandoned = true;
    
    @Value("${jdbc.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis = 3600000;
    
    @Value("${jdbc.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis = 3600000;
    
    @Value("${jdbc.defaultAutoCommit}")
    private boolean defaultAutoCommit = true;
    
    @Value("${jdbc.validationQuery}")
    private String validationQuery = "SELECT 1";
    
    @Value("${jdbc.testOnBorrow}")
    private boolean testOnBorrow = true;
    
    @Value("${spring.profiles.active}")
    private String activeProfile = null;
    
    private void reloadProperties() {
    	if (null != activeProfile) {
    		activeProfile = activeProfile.trim();
    		String path = "application-" + activeProfile + ".properties";
    		Properties prop = new Properties();
    		try (InputStream is = this.getClass().getClassLoader().getResourceAsStream(path)) {
				prop.load(is);
				if (null != prop.getProperty("jdbc.url")) {
					this.url = prop.getProperty("jdbc.url");
				}
				if (null != prop.getProperty("jdbc.userName")) {
					this.userName = prop.getProperty("jdbc.userName");
				}
				if (null != prop.getProperty("jdbc.password")) {
					this.password = prop.getProperty("jdbc.password");
				}
				if (null != prop.getProperty("jdbc.driverClass")) {
					this.driverClass = prop.getProperty("jdbc.driverClass");
				}
				try {
					if (null != prop.getProperty("jdbc.maxActive")) {
						this.maxActive = Integer.parseInt(prop.getProperty("jdbc.maxActive"));
					}
					if (null != prop.getProperty("jdbc.maxIdel")) {
						this.maxIdel = Integer.parseInt(prop.getProperty("jdbc.maxIdel"));
					}
					if (null != prop.getProperty("jdbc.maxWait")) {
						this.maxWait = Long.parseLong(prop.getProperty("jdbc.maxWait"));
					}
				} catch (NumberFormatException e) {
					log.error("load properties from file:" + path + " failed!" + e.getMessage());
				}
			} catch (IOException e) {
				log.error("load properties from file:" + path + " failed!" + e.getMessage());
			} 
    	}
    }
    
    @Bean
    public BasicDataSource dataSource(){
    	log.debug("get datasource()");
    	reloadProperties();
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setMaxActive(maxActive);
        dataSource.setMaxIdle(maxIdel);
        dataSource.setMaxWait(maxWait);
        dataSource.setRemoveAbandoned(removeAbandoned);
        dataSource.setRemoveAbandonedTimeout(removeAbandonedTimeout);
        dataSource.setLogAbandoned(logAbandoned);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setDefaultAutoCommit(defaultAutoCommit);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setTestOnBorrow(testOnBorrow);
        return dataSource;
    }
}
