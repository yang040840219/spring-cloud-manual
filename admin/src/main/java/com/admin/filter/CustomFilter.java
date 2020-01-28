package com.admin.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 2020/1/24
 * 过滤器 servlet 函数回调处理链
 */

@WebFilter(urlPatterns = "/*")
public class CustomFilter implements Filter {

    Logger logger = LoggerFactory.getLogger(CustomFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("custom filter doFilter request"); // 请求处理之前
        filterChain.doFilter(servletRequest, servletResponse);
        logger.info("custom filter doFilter response"); // 请求处理之后
    }

    @Override
    public void destroy() {

    }
}
