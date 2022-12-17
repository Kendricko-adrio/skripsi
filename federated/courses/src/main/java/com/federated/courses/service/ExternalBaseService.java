package com.federated.courses.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class ExternalBaseService {

    // T request , K response
    public <T,K> K hitExternalService(String url, HttpMethod method, T body, HttpHeaders headers, Class<K> clazz) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<T> request = new HttpEntity<>(body, headers);
        ObjectMapper mapper = new ObjectMapper();
        K response = null;
        try {
            String jsonRequest = mapper.writeValueAsString(body);
            log.info("Request : " + jsonRequest);
            response = restTemplate.exchange(url, method, request, clazz).getBody();
            String jsonResponse = mapper.writeValueAsString(response);
            log.info("Response : " + jsonResponse);
        }catch (HttpClientErrorException e){
            e.printStackTrace();
            log.info("Client Error: {}", e.getMessage());
        }catch (HttpServerErrorException se){
            se.printStackTrace();
            log.info("Server Error: {}", se.getMessage());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return response;
    }
}
