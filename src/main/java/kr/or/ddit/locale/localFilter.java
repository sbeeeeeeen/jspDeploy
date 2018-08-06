package kr.or.ddit.locale;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import kr.or.ddit.filter.DefCompFilter;
import kr.or.ddit.filter.DefCompWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet Filter implementation class localFilter
 */
@WebFilter("/localeSelect")
public class localFilter implements Filter {
	
	private Logger logger = LoggerFactory.getLogger(localFilter.class);

    /**
     * Default constructor. 
     */
    public localFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		
		//lock이 걸려있는 map 객체라 임의 등록이 불가능하다 > wrapper를 통해 해결 
		logger.debug(req.getRequestURI() + " : LocaleFilter doFilter");
		LocaleHttpServletRequestWraapper localeWrapper = new LocaleHttpServletRequestWraapper(req);

		// pass the request along the filter chain
		chain.doFilter(localeWrapper, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
