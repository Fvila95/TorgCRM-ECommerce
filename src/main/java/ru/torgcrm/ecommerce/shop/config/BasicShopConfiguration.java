package ru.torgcrm.ecommerce.shop.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.*;
import ru.torgcrm.ecommerce.shop.interceptors.BasicShopInterceptor;
import ru.torgcrm.ecommerce.shop.utils.DataSeeder;

@Configuration
public class BasicShopConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    BasicShopInterceptor basicShopInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(basicShopInterceptor)
                .excludePathPatterns("/static/**").addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/templates/");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**");
        registry.addMapping("/api/admin/**");
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/api/**", config);
        return new CorsFilter(source);
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        super.configureViewResolvers(registry);
    }

    @Bean
    public BasicShopInterceptor basicShopInterceptor() {
        return new BasicShopInterceptor();
    }

    @Bean
    @RequestScope
    public RequestDataHolder requestDataHolder() {
        return new RequestDataHolder();
    }

    @Bean
    public DataSeeder dataSeeder() {
        return new DataSeeder();
    }

    @Bean
    @SessionScope
    public SessionDataHolder sessionDataHolder() {
        return new SessionDataHolder();
    }
}
