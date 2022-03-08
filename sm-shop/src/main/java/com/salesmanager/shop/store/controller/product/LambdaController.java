package com.salesmanager.shop.store.controller.product;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class LambdaController {
    private static final String AWS_LAMBDA_URL = System.getenv("AWS_LAMBDA_URL");

    @RequestMapping("/call-lambda")
    public String callLambda() {
		String sURL = AWS_LAMBDA_URL;
		if (sURL == null) {
			sURL = "https://35g18apkt5.execute-api.ap-southeast-1.amazonaws.com/Prod/";
		}
		RestTemplate restTemplate = new RestTemplate();
		try {
			return restTemplate.getForEntity(sURL,String.class).getBody();
		} catch (Throwable thrown) {
			return "";
		}        
    }
}