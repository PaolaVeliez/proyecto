
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
public class JwtEntryPoint implements AuthenticationEntryPoint{
   private final static Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class); 
   
  public void commence  (HttpServletRequest request, HttpServletResponse response, AuthenticationException authException);
  response.sendError(HttpServletResponse.SC_CUNATHORIZED );

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, org.springframework.security.core.AuthenticationException authException) throws IOException, ServletException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
