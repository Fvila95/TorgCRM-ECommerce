package ru.torgcrm.ecommerce.shop.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import ru.torgcrm.ecommerce.shop.interceptors.BasicShopInterceptor;
import ru.torgcrm.ecommerce.shop.utils.DataSeeder;

@Configuration
public class BasicShopConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    BasicShopInterceptor basicShopInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(basicShopInterceptor)
                .excludePathPatterns(
                        "/js/**",
                        "/css/**")
                .addPathPatterns(
                        "/**");
        super.addInterceptors(registry);
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
}
