package com.security2;

import java.net.HttpURLConnection;

import sun.misc.BASE64Encoder;

public class BasicSecureSimpleClientHttpRequestFactory extends
            SecureSimpleClientHttpRequestFactory {

        public BasicSecureSimpleClientHttpRequestFactory() {
        }

        protected void prepareSecureConnection(HttpURLConnection connection) {
            if (credentialsProvider == null) {
                return;
            }
            Credentials credentials = credentialsProvider.getCredentials(null);
            String token = credentials.getUsername() + ":"
                    + credentials.getPassword();
            BASE64Encoder enc = new sun.misc.BASE64Encoder();
            String encodedAuthorization = enc.encode(token.getBytes());
            connection.setRequestProperty("Authorization", "Basic "
                    + encodedAuthorization);
        }
    }