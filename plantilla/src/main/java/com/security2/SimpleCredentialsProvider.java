package com.security2;

public class SimpleCredentialsProvider implements CredentialsProvider {

	private Credentials credentials;

	public SimpleCredentialsProvider(Credentials credentials) {
		super();
		this.credentials = credentials;
	}

	@Override
	public Credentials getCredentials(String str) {

		return credentials;
	}

}