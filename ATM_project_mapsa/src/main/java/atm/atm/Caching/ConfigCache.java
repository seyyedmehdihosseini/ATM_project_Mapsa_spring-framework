package atm.atm.Caching;

/*
@Configuration
@EnableCaching
*/
public class ConfigCache {
/*
    @Bean
    public CacheManager cacheManager(){
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager("allAccountCache");
        caffeineCacheManager.setCaffeine(caffeine());
        return caffeineCacheManager;
    }
    Caffeine<Object,Object> caffeine(){
        return Caffeine.newBuilder().initialCapacity(512)
                .maximumSize(2048)
                .expireAfterWrite(20, TimeUnit.MINUTES)
                .weakKeys()
                .recordStats();
    }
*/

}
