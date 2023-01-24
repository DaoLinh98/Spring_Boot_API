package com.restapi.user.service;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {
   @Value("${secret_key}")
   private String secret_key;
   @Value("${expire_time}")
   private String expiretime;

   public static final String Email = "email";

   public String generateTokenLogin(String email) {
      String token = null;
      try {
         //Create HMAC signer
         JWSSigner signer = new MACSigner(gennerateShareSecret());

         JWTClaimsSet.Builder builder = new JWTClaimsSet.Builder();
         builder.claim(Email, "email");
         builder.expirationTime(generateExpirationDate());

         JWTClaimsSet claimsSet = builder.build();
         SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);


         //apply th HMAC
         signedJWT.sign(signer);

      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return token;
   }

   private JWTClaimsSet getClaimsFromToken(String token){
      JWTClaimsSet claims = null;
      try{
         SignedJWT signedJWT = SignedJWT.parse(token);
         JWSVerifier verifier = new MACVerifier(gennerateShareSecret());
         if(signedJWT.verify(verifier)) {
            claims = signedJWT.getJWTClaimsSet();
         }
      }catch (Exception e){
         e.printStackTrace();
      }
      return  claims;
   }

   private Date generateExpirationDate() {
      int expire_time = Integer.parseInt(expiretime);
      return  new Date(System.currentTimeMillis() + expire_time);
   }

   private Date getExpirationDateFromToken(String token) {
      Date expiration = null;
      JWTClaimsSet claims = getClaimsFromToken(token);
      expiration = claims.getExpirationTime();
      return expiration;
   }

   public String getEmailFromToken(String token) {
      String email = null;
      try {
         JWTClaimsSet claims = getClaimsFromToken(token);
         email = claims.getStringClaim(Email);

      }catch (Exception e){
         e.printStackTrace();
      }
      return email;
   }

   private  byte[] gennerateShareSecret() {
      byte[] shareSecret = new byte[32];
      String secretKey = secret_key;
      shareSecret = secretKey.getBytes();
      return  shareSecret;
   }

   private  Boolean isTokenExpired(String token) {
      Date expiration = getExpirationDateFromToken(token);
      return expiration.before(new Date());
   }

public Boolean validateTokenLogin(String token) {
      if(token == null || token.trim().length() == 0) {
         return  false;
      }
      String email = getEmailFromToken(token);
      if(email == null || email.isEmpty()){
         return false;
      }
      if(isTokenExpired(token)){
         return false;
      }
      return true;
}

}
