package com.security2;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;

public class SecureSimpleClientHttpRequest implements ClientHttpRequest {
    public SecureSimpleClientHttpRequest(HttpURLConnection connection) {
        // TODO Auto-generated constructor stub
    }
    @Override
    public HttpMethod getMethod() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public URI getURI() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public HttpHeaders getHeaders() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public OutputStream getBody() throws IOException {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public ClientHttpResponse execute() throws IOException {
        // TODO Auto-generated method stub
        return null;
    }
}