package ru.torgcrm.ecommerce.shop.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import ru.torgcrm.ecommerce.shop.interceptors.BasicShopInterceptor;
import ru.torgcrm.ecommerce.shop.session.CartHolder;
import ru.torgcrm.ecommerce.shop.utils.DataSeeder;

@Configuration
public class BasicShopConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    BasicShopInterceptor basicShopInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(basicShopInterceptor)
                .excludePathPatterns(
                        "/static/**")
                .addPathPatterns(
                        "/**");
        super.addInterceptors(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/templates/");
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

    @Bean @SessionScope
    public CartHolder cartHolder() {
        return new CartHolder();
    }
}
