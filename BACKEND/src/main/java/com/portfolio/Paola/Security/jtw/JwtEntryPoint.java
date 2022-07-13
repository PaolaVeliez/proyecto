
package com.portfolio.Paola.Security.jtw;

import java.io.IOException;
import java.util.logging.Logger;
import javax.security.sasl.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public abstract class JwtEntryPoint implements AuthenticationEntryPoint{
   private final static Logger logger = (Logger) LoggerFactory.getLogger(JwtEntryPoint.class); 
   
 
    @Override
    
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException{
            logger.error("Fallo el metodo commence");
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }

  
}


    

