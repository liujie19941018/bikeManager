package com.aowin.filters;

import com.aowin.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter("/*")
public class Filter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {


    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HttpServletRequest req= (HttpServletRequest) request;
        HttpServletResponse resp= (HttpServletResponse) response;
        resp.setDateHeader("Expires", -1);
        resp.setHeader("Cache-Control", "no-cache");
        HttpSession session=req.getSession();
        User user= (User) session.getAttribute("user");
        String url=req.getRequestURI();
        if(url.contains("bikeRent")){
            if(user==null){
                resp.sendRedirect("/admin.html");
            }else {
                if(!user.getUrl().equals("bikeRent")){
                    resp.sendRedirect("/auth.html");
                }else {
                    chain.doFilter(request, response);
                }
            }
        }if(url.contains("bikeBuy")){
            if(user==null){
                resp.sendRedirect("/admin.html");
            }else {
                if(!user.getUrl().equals("bikeBuy")){
                    resp.sendRedirect("/auth.html");
                }else {
                    chain.doFilter(request, response);
                }
            }
        }if(url.contains("news")){
            if(user==null){
                resp.sendRedirect("/admin.html");
            }else {
                if(!user.getUrl().equals("bikeBuy")||!user.getUrl().equals("bikeRent")){
                    resp.sendRedirect("/auth.html");
                }else {
                    chain.doFilter(request, response);
                }

            }
        }
        else {
            chain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {

    }
}
