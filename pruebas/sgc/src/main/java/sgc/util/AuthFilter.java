package sgc.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@WebFilter(filterName = "AuthFilter", urlPatterns = {"*.xhtml"})
public class AuthFilter implements Filter {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	private final Logger logger2 = LoggerFactory.getLogger("pe.com.claro.esb.services.aprovisionamiento.errorIL");
     
    public AuthFilter() {
    }
 
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    	logger.debug("");
    	logger2.error("msisdn\timsi\t");
    }
 
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
         try {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;
            HttpSession session = req.getSession(false);
            String reqURI = req.getRequestURI();
            
            if(!reqURI.endsWith(".xhtml")){
            	//logger.debug("valid 1");
            	chain.doFilter(request, response);
            }else if ( reqURI.indexOf("/login.xhtml") >= 0 || 
            	 (session != null && session.getAttribute("usuarioSesion") != null) || 
            	 reqURI.indexOf("/publico/") >= 0 || 
            	 reqURI.contains("javax.faces.resource") ){
            	//logger.debug("valid 2");
            	chain.doFilter(request, response);
            }else{
            	//logger.debug("valid 3");
                //res.sendRedirect(req.getContextPath() + "/paginas/modulos/seguridad/login.xhtml?unauthorized=true");
                req.getRequestDispatcher("/paginas/modulos/seguridad/login.xhtml?unauthorized=true").forward(request, response);
            }
      }
     catch(Throwable t) {
         System.out.println( t.getMessage());
     }
    }
 
    @Override
    public void destroy() {
    	logger.debug("");
    }
}