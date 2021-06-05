package com.zourongsheng.lab2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


@WebFilter(filterName = "ZourongshengFilter")
public class ZourongshengFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("ZourongshengFilter -- before chain");
        chain.doFilter(req, resp);
        System.out.println("ZourongshengFilter -- after chain");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
