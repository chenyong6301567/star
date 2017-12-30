package com.hotyum.stars.biz.config.cache;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 
 * @author Croky.Zheng 2017年3月8日
 */
@Configuration
// 标注启动了缓存
@EnableCaching
@PropertySource("classpath:application.properties")
public class CacheConfiguration extends CachingConfigurerSupport {
	   Logger log = LoggerFactory.getLogger(CacheConfiguration.class);
//
//	    @Value("${spring.redis.host}")
//	    private String host;
//
//	    @Value("${spring.redis.port}")
//	    private int port;
//
//	    @Value("${spring.redis.timeout}")
//	    private int timeout;
//
//	    @Value("${spring.redis.pool.max-idle}")
//	    private int maxIdle;
//
//	    @Value("${spring.redis.pool.max-wait}")
//	    private long maxWaitMillis;
//
//	    @Value("${spring.redis.password}")
//	    private String password;
	    
//	    @Bean
//	    public JedisPool redisPoolFactory() {
//	        JedisPool jedisPool = new JedisPool(this.getJedisPoolConfig(), host, port, timeout, password);
//	        return jedisPool;
//	    }

	/*
	 * ehcache 主要的管理器
	 */
	@Bean(name="localCacheCacheManager")
	public EhCacheCacheManager ehCacheCacheManager(EhCacheManagerFactoryBean bean){
		log.debug("create EhCacheCacheManager");
		return new EhCacheCacheManager(bean.getObject());
	}

	/*
	 * 据shared与否的设置,Spring分别通过CacheManager.create()或new CacheManager()方式来创建一个ehcache基地.
	 */
	@Bean
	public EhCacheManagerFactoryBean ehCacheManagerFactoryBean(){
		log.debug("create ehCacheManagerFactoryBean");
		EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean ();
		cacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
		cacheManagerFactoryBean.setShared(true);
		return cacheManagerFactoryBean;
	}
	
//	@Bean
//	public JedisConnectionFactory redisConnectionFactory() {
//		log.debug("create redisConnectionFactory");
//		JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();
//		redisConnectionFactory.setHostName(host);
//		redisConnectionFactory.setPassword(password);
//		redisConnectionFactory.setPort(port);
//		redisConnectionFactory.setPoolConfig(this.getJedisPoolConfig());
//		redisConnectionFactory.setUsePool(true);
//		return redisConnectionFactory;
//	}
	
//	@Bean
//	public CacheManager cacheManager(RedisTemplate<?, ?> redisTemplate) {
//		CacheManager cacheManager = new RedisCacheManager(redisTemplate);
//		return cacheManager;
//	}

	@Bean
	public RedisCacheManager redisCacheManager(RedisTemplate<String, String> redisTemplate) {
		log.debug("create redisCacheManager");
		RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
		Map<String,Long> map=new HashMap<String,Long>();
        map.put("remote-item",60L);
        cacheManager.setExpires(map);

		// Number of seconds before expiration. Defaults to unlimited (0)
		cacheManager.setDefaultExpiration(100L); // Sets the default expire time (in seconds)
		return cacheManager;
	}
	
	@Bean
	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
		log.debug("create redisTemplate");
		RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
		redisTemplate.setConnectionFactory(factory);
		// key序列化方式;（不然会出现乱码;）,但是如果方法上有Long等非String类型的话，会报类型转换错误；
		// 所以在没有自己定义key生成策略的时候，以下这个代码建议不要这么写，可以不配置或者自己实现ObjectRedisSerializer
		// 或者JdkSerializationRedisSerializer序列化方式;
//		RedisSerializer<String>redisSerializer = new StringRedisSerializer();//Long类型不可以会出现异常信息;
//		redisTemplate.setKeySerializer(redisSerializer);
//		redisTemplate.setHashKeySerializer(redisSerializer);
		return redisTemplate;
	}
	
	@Bean
	@Primary
	public CacheManager cacheManager(RedisCacheManager redisCacheManager,EhCacheCacheManager localCacheCacheManager) {
		MulCacheManager cacheManager = new MulCacheManager();
		cacheManager.setRemoteCacheManager(redisCacheManager);
		cacheManager.setLocalCacheManager(localCacheCacheManager);
		return cacheManager;
	}

//	@Override
//	public KeyGenerator keyGenerator() {
//		return new KeyGenerator() {
//			@Override
//			public Object generate(Object target, Method method, Object... params) {
//				StringBuffer sb = new StringBuffer();
//				sb.append(target.getClass().getName());
//				sb.append(method.getName());
//				for (Object obj : params) {
//					sb.append(obj.toString());
//				}
//				return sb.toString();
//			}
//		};
//	}



//    private JedisPoolConfig getJedisPoolConfig() {
//        JedisPoolConfig jedisConfig = new JedisPoolConfig();
//        jedisConfig.setMaxTotal(this.maxIdle);
//        jedisConfig.setMaxIdle(1);
//        jedisConfig.setMaxWaitMillis(this.maxWaitMillis);
//        jedisConfig.setTestOnBorrow(true);
//        return jedisConfig;
//    }
	
	/**
	 * 多缓存设计
	 * @author Croky.Zheng
	 * 2017年3月8日
	 */
	public static class MulCacheManager implements CacheManager {
		private CacheManager remoteCacheManager;  
		private CacheManager localCacheManager; 
		
		@Override
		public Cache getCache(String name) {
			if (name.startsWith("remote-")) {
				return remoteCacheManager.getCache(name);
			}
			return localCacheManager.getCache(name);
		}

		@Override
		public Collection<String> getCacheNames() {
			//new java.util.concurrent.ConcurrentSkipListSet<>();
			Collection<String> cacheNames = new HashSet<String>();  
	        if (null != localCacheManager) {  
	            cacheNames.addAll(localCacheManager.getCacheNames());
	        }
	        
	        if (null != remoteCacheManager) {  
	            cacheNames.addAll(remoteCacheManager.getCacheNames());
	        }
	        return cacheNames;
		}

		public CacheManager getRemoteCacheManager() {
			return remoteCacheManager;
		}

		public void setRemoteCacheManager(CacheManager remoteCacheManager) {
			this.remoteCacheManager = remoteCacheManager;
		}

		public CacheManager getLocalCacheManager() {
			return localCacheManager;
		}

		public void setLocalCacheManager(CacheManager localCacheManager) {
			this.localCacheManager = localCacheManager;
		}
	}
}
