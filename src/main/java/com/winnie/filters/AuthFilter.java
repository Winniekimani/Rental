package com.winnie.filters;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.http.HttpRequest;

@WebFilter(urlPatterns = "/*")
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession httpSession = httpRequest.getSession();
        String servletPath = httpRequest.getServletPath();
        System.out.println("servlet path:" + servletPath);
        System.out.println("context path:" + httpRequest.getContextPath());
        System.out.println("context URI:" + httpRequest.getRequestURI());

        if (httpSession.isNew() || StringUtils.isBlank((String) httpSession.getAttribute("loggedIn"))) {
            httpSession.invalidate();
            if (servletPath.equals("/login") || servletPath.equals("/registerUser") || servletPath.contains("jsp") || servletPath.equals("/user")) {
                chain.doFilter(request, response);
            } else {

                httpResponse.sendRedirect(httpRequest.getContextPath() + "/home");
                response.getWriter().flush();
            }
        } else {
            if (StringUtils.isNotBlank((String) httpSession.getAttribute("loggedIn"))) {
                chain.doFilter(request, response);
            } else {

                httpResponse.sendRedirect(httpRequest.getContextPath() + "/");
                response.getWriter().flush();
            }

        }


    }


    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
