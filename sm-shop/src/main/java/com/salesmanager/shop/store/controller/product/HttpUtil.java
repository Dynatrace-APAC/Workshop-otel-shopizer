package com.salesmanager.shop.store.controller.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpUtil.class);

    public static void Get(String sUrl) {
        LOGGER.info("GET " + sUrl);
        try {
            java.net.URL url = new java.net.URL(sUrl);
            java.net.HttpURLConnection con = (java.net.HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            if (responseCode == java.net.HttpURLConnection.HTTP_OK) {
                StringBuilder resp = new StringBuilder();
                try (java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(con.getInputStream()))) {
                    String inputLine;					
                    while ((inputLine = in.readLine()) != null) {
                        resp.append(inputLine);
                    }
                }
            } 
        } catch (Throwable thrown) {

        }        
    }
}