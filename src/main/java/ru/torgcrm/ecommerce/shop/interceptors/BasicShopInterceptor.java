package ru.torgcrm.ecommerce.shop.interceptors;

import com.google.common.net.InternetDomainName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import ru.torgcrm.ecommerce.shop.config.RequestDataHolder;
import ru.torgcrm.ecommerce.shop.models.Category;
import ru.torgcrm.ecommerce.shop.models.Menu;
import ru.torgcrm.ecommerce.shop.repository.CategoryRepository;
import ru.torgcrm.ecommerce.shop.repository.MenuItemRepository;
import ru.torgcrm.ecommerce.shop.repository.MenuRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasicShopInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    RequestDataHolder requestDataHolder;
    @Autowired
    MenuRepository menuRepository;
    @Autowired
    MenuItemRepository menuItemRepository;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String urlRequest = httpServletRequest.getRequestURL().toString();

        String domain = InternetDomainName
                .from(new URL(urlRequest).getHost()).toString();

        request.setAttribute("domain", domain);

        List<Category> categories = categoryRepository.findAll();
        List<Menu> menu = menuRepository.findAll();
        Map<String, Menu> menuMap = new HashMap<>();
        menu.forEach((Menu m) -> menuMap.put(m.getCode(), m));
        requestDataHolder.setMenu(menuMap);
        requestDataHolder.setDomain(domain);
        requestDataHolder.setCategories(categories);
        if ("localhost".equals(requestDataHolder.getDomain())) {
            requestDataHolder.setTemplate("default");
        }
        request.setAttribute("template", requestDataHolder.getTemplate());
        return super.preHandle(request, response, handler);
    }
}
