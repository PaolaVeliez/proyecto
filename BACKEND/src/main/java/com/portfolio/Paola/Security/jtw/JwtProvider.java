package com.portfolio.Paola.Security.jtw;

import com.portfolio.Paola.Security.Entity.UsuarioPrincipal;
import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithm;
import java.security.SignatureException;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtProvider {

    private final static Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private int expiration;

    public String generateToken(Authentication authentication) {
        UsuarioPrincipal usuarioPrincipal = (usuarioPrincipal) authentication.getPrincipal();
        return Jwts.builder.setSubject(usuarioPrincipal.getUsername()).setIssuedAt(new Date()).setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .sigWhith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String getNombreUsuarioFromToken(String token) {
        return Jwts.parser().setSigninKey(secret).parseClaimsJws(token).getBody().getSubjet();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigninKey(secret).parseClaimsJws(token);
            return true;
        } catch (MalFormedJwtException e) {
            logger.error("Token mal formado");
        } catch (UnsupportedJwtException e) {
            logger.error("Token no soportado");
        } catch (ExpiredJwtEsception e) {
            logger.error("Token expirado");
        } catch (IllegalArgumentException e) {
            logger.error("Token vacio");
        } catch (SignatureException e) {
            logger.error("Firma no valida");
        }
        return false;
    }
}
