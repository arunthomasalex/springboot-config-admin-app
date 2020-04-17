package com.run.clientapp.config.filters;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.run.clientapp.util.ApplicationConstant;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TokenOncePerRequestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        String token = (String) session.getAttribute(ApplicationConstant.TOKEN_VALUE.name());
        if (token == null && request.getParameter("code") != null) {
            ResponseEntity<String> reqResponse = null;
            RestTemplate restTemplate = new RestTemplate();

            String credentials = "client:password";
            String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.add("Authorization", "Basic " + encodedCredentials);
            HttpEntity<String> header = new HttpEntity<String>(headers);

            String access_token_url = "http://authentication:9000/auth/oauth/token";
            access_token_url += "?code=" + request.getParameter("code");
            access_token_url += "&grant_type=authorization_code";
            access_token_url += "&redirect_uri=http://localhost:8000/home";

            reqResponse = restTemplate.exchange(access_token_url, HttpMethod.POST, header, String.class);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(reqResponse.getBody());
            session.setAttribute(ApplicationConstant.TOKEN_VALUE.name(), node.path("access_token").asText());
            chain.doFilter(request, response);
        } else if(token == null) {
            request.getRequestDispatcher("/home").forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }
}