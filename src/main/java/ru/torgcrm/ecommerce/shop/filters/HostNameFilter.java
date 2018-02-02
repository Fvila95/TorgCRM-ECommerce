package ru.torgcrm.ecommerce.shop.filters;

import com.google.common.net.InternetDomainName;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URL;

@Component
public class HostNameFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String urlRequest = httpServletRequest.getRequestURL().toString();

        String domainName = InternetDomainName
                .from(new URL(urlRequest).getHost()).toString();

        request.setAttribute("domain", domainName);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() { }
}
