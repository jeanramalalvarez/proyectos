package com.security2;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;

import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

abstract public class SecureSimpleClientHttpRequestFactory extends
        SimpleClientHttpRequestFactory {

    protected CredentialsProvider credentialsProvider;

    public SecureSimpleClientHttpRequestFactory() {
    }

    public CredentialsProvider getCredentialsProvider() {
        return credentialsProvider;
    }

    public void setCredentialsProvider(CredentialsProvider credentialsProvider) {
        this.credentialsProvider = credentialsProvider;
    }

    @Override
    public ClientHttpRequest createRequest(URI uri, HttpMethod httpMethod)
            throws IOException {
        HttpURLConnection connection = openConnection(uri.toURL(), null);
        prepareConnection(connection, httpMethod.name());
        prepareSecureConnection(connection);
        return new SecureSimpleClientHttpRequest(connection);
    }

    abstract protected void prepareSecureConnection(HttpURLConnection connection);

}