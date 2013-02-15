package com.in6k.mypal.service.facebook;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class UserService {

    public JSONObject getFacebookUserData(String accessToken) {
        try {

            JSONObject jsonObject = new JSONObject(readUrl("https://graph.facebook.com/me?access_token=" + accessToken));
            return jsonObject;

        } catch (Throwable ex) {
            throw new RuntimeException("failed login", ex);
        }
    }

    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }
}
