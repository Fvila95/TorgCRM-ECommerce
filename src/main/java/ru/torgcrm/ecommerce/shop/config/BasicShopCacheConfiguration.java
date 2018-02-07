package ru.torgcrm.ecommerce.shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.jcache.config.JCacheConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
@EnableCaching
public class BasicShopCacheConfiguration extends JCacheConfigurerSupport {

    public static final String CACHE_CATEGORY_BY_SLUG = "categoryBySlug";
    public static final String CACHE_ITEMS_BY_SLUG = "itemsBySlug";

    @Autowired
    private net.sf.ehcache.CacheManager ehCacheManager;

    @Bean(destroyMethod = "shutdown")
    public net.sf.ehcache.CacheManager ehCacheManager() {
        net.sf.ehcache.config.Configuration configuration = new net.sf.ehcache.config.Configuration();
        configuration.addCache(addCache(CACHE_CATEGORY_BY_SLUG, 200));
        configuration.addCache(addCache(CACHE_ITEMS_BY_SLUG, 500));
        return net.sf.ehcache.CacheManager.newInstance(configuration);
    }

    private net.sf.ehcache.config.CacheConfiguration addCache(String name, long maxEntries) {
        net.sf.ehcache.config.CacheConfiguration config = new net.sf.ehcache.config.CacheConfiguration();
        config.setName(name);
        config.setMaxEntriesLocalHeap(maxEntries);
        config.setMemoryStoreEvictionPolicy("LRU");
        return config;
    }

    @Bean
    @DependsOn("ehCacheManager")
    @Override
    public CacheManager cacheManager() {
        return new EhCacheCacheManager(ehCacheManager);
    }
}
