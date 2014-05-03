package com.test;

import org.springframework.web.client.RestTemplate;

import com.security2.BasicSecureSimpleClientHttpRequestFactory;
import com.security2.Credentials;
import com.security2.SimpleCredentialsProvider;

public class RestClient {
	
	RestTemplate restTemplate = new RestTemplate();
	static final String URL = "http://localhost:8082/plantilla/api/test";
	static final String username = "admin";
	static final String password = "admin";

	public RestClient() {
		BasicSecureSimpleClientHttpRequestFactory requestFactory = new BasicSecureSimpleClientHttpRequestFactory();
		requestFactory.setCredentialsProvider(new SimpleCredentialsProvider(new Credentials(username, password)));
		restTemplate.setRequestFactory(requestFactory);
	}

	public void exec() {
		String response = restTemplate.getForObject(URL, String.class);
		System.out.println("Response: " + response);
	}

	static public void main(String[] args) {
		RestClient client = new RestClient();
		client.exec();
	}
}