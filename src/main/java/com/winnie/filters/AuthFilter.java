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

        System.out.println("Printing from session Remote address: " + request.getRemoteAddr());

        HttpServletRequest httpReq = (HttpServletRequest)  request;
        HttpServletResponse httpRes = (HttpServletResponse)  response;
        HttpSession session = httpReq.getSession(); //returns existing session or creates if not existing

        String reqPath = httpReq.getServletPath();
        if (reqPath == null) {
            session.invalidate();
            httpRes.sendRedirect("./");
            return;
        }

        //if user is accessing /home - (page accessed only by logged-in users),
        //with a new session creating in this filter (which mean the session was initially
        // null and was crated in this filter at line 21, the user will be redirected to login page
        if (reqPath.equalsIgnoreCase("/home") && session.isNew() /*checks if session was created in the filter*/) {
            httpRes.sendRedirect("./login");
            return;
        }

        //in case user is accessing login/register/index page, they should not have a session. invalidate
        if (reqPath.equalsIgnoreCase("/login")
                || reqPath.equalsIgnoreCase("/register")
                || reqPath.equalsIgnoreCase("/"))
            session.invalidate();

        //proceed to the resource/servlet requested
        chain.doFilter(request, response);

//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//
//        HttpSession httpSession = httpRequest.getSession();
//        String servletPath = httpRequest.getServletPath();
//        System.out.println("servlet path:" + servletPath);
//        System.out.println("context path:" + httpRequest.getContextPath());
//        System.out.println("context URI:" + httpRequest.getRequestURI());
//
//        if (httpSession.isNew() || StringUtils.isBlank((String) httpSession.getAttribute("loggedIn"))) {
//            httpSession.invalidate();
//            if (servletPath.equals("/login") || servletPath.equals("/registerUser") || servletPath.contains("jsp") || servletPath.equals("/user")) {
//                System.out.println("1...........login");
//                chain.doFilter(request, response);
//
//            } else {
//
//                System.out.println("2...........login");
//                httpResponse.sendRedirect(httpRequest.getContextPath() + "/home");
//                response.getWriter().flush();
//            }
//        } else {
//            if (StringUtils.isNotBlank((String) httpSession.getAttribute("loggedIn"))) {
//                chain.doFilter(request, response);
//
//                /*//check if user is admin
//                String username = (String) httpSession.getAttribute("username");
//                if ("Admin".equals(username)) {
//                    // User is an admin, allow access to /admin pages
//                    if (servletPath.startsWith("/admin") || servletPath.startsWith("/") || servletPath.equals("admin.jsp")) {
//                        chain.doFilter(request, response);
//                    } else {
//                        httpResponse.sendRedirect(httpRequest.getContextPath() + "/admin");
//                    }
//                } else {
//                    if (servletPath.startsWith("/admin")) {
//                        httpResponse.sendRedirect(httpRequest.getContextPath() + "/");
//                        response.getWriter().flush();
//                    } else {
//                        chain.doFilter(request, response);
//                    }
//                }*/
//            } else {
//
//                httpResponse.sendRedirect(httpRequest.getContextPath() + "/");
//                response.getWriter().flush();
//            }
//
//        }


    }


    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
