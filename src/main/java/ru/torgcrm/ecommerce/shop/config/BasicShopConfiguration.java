package ru.torgcrm.ecommerce.shop.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import ru.torgcrm.ecommerce.shop.interceptors.BasicShopInterceptor;

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
}
