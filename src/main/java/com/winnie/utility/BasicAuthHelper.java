package com.winnie.utility;

import java.io.Serializable;
import java.util.Base64;

public class BasicAuthHelper implements Serializable {

        public static String encodeCredentials(String username, String password) {
            String credentials = username + ":" + password;
            return Base64.getEncoder().encodeToString(credentials.getBytes());
        }

}
