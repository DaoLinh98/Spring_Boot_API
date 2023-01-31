package com.restapi.user.jwt;


import com.restapi.user.security.CustomUserDetails;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class JwtTokenProvider {
    @Value("${com.example.jwt.jwt.secret}")
    private String JWT_SECRET;
    @Value("${com.example.jwt.jwt.expiration}")
    private int JWT_EXPIRATION;

    //tao jwt tu thong tin account
    public String generateToken(CustomUserDetails customUserDetails){
        Date now = new Date();
        Date dateExpired =new Date(now.getTime()+JWT_EXPIRATION);

        //tao chuoi Json token tu userName cua account
        return Jwts.builder()
                .setSubject(customUserDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(dateExpired)
                .signWith(SignatureAlgorithm.HS512,JWT_SECRET).compact();
    }
    // lay ra thong tin tu jwt
    public String getUserNameFromJwt(String token){
        Claims claims = Jwts.parser().setSigningKey(JWT_SECRET)
                .parseClaimsJws(token).getBody();
        //tra lai thong tin
        return claims.getSubject();
    }

    //Validate thong tin token
    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(JWT_SECRET)
                    .parseClaimsJws(token);
            return true;
        }catch (MalformedJwtException ex){
            log.error("Invalid JWT");
        }catch (ExpiredJwtException ex){
            log.error("Expired JWT");
        }catch (UnsupportedJwtException ex){
            log.error("Unsupported JWT");
        }catch (IllegalArgumentException ex){
            log.error("JWT claims String is empty");
        }
        return false;
    }


}
