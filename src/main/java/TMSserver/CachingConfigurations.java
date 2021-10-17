package TMSserver;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CachingConfigurations /*extends CachingConfigurerSupport*/ {

    @Bean
//    @Primary
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("tanks","materials","drivers","clients","truckTrailers","truckContainers","stations","transactions","computers","users");
    }

//    @Bean
////    @Qualifier("materials")
//    public CacheManager cacheManagerMaterial() {
//        return new ConcurrentMapCacheManager("materials");
//    }























}
