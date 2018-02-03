package ru.torgcrm.ecommerce.shop.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import ru.torgcrm.ecommerce.shop.models.Category;
import ru.torgcrm.ecommerce.shop.repository.CategoryRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class BasicShopInterceptor extends HandlerInterceptorAdapter {
    public static final String _categoriesRequestAttribute = "categories";

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String domain = request.getAttribute("domain").toString();
        List<Category> categories = categoryRepository.findAll();
        request.setAttribute(_categoriesRequestAttribute, categories);
        return super.preHandle(request, response, handler);
    }
}
