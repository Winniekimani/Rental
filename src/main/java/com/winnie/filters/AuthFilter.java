package com.winnie.filters;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.text.DateFormat;

/*@WebFilter(urlPatterns = "/*")*/
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        HttpSession httpSession = httpRequest.getSession();

        String servletPath = httpRequest.getServletPath();

        if (httpSession.isNew() || StringUtils.isBlank((String) httpSession.getAttribute("loggedInId"))) {
            httpSession.invalidate();

            if (servletPath.equals("/login") || servletPath.equals("/changepwd")
                    || servletPath.contains("/rest") || servletPath.equals("/user") || servletPath.contains(".jsp")) {
                filterChain.doFilter(servletRequest, servletResponse);

            } else {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/");
                servletResponse.getWriter().flush();

            }

        } else {
            if (StringUtils.isNotBlank((String) httpSession.getAttribute("loggedInId"))) {
                filterChain.doFilter(servletRequest, servletResponse);
            }else {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/");
                servletResponse.getWriter().flush();

            }
        }


    }



    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
