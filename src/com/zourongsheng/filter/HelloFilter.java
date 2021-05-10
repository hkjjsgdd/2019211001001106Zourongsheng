package com.zourongsheng.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "HelloFilter",
    urlPatterns = {"/*"}
)
public class HelloFilter implements Filter {
    public void destroy() {
        System.out.println("i am in helloFilter---destory()");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("i am in helloFilter----init()");
    }

}
