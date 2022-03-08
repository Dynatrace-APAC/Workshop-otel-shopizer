package com.salesmanager.shop.store.controller.product;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LoadGen implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoadGen.class);

    private static final Random RAND = new Random(System.currentTimeMillis());

    private static final String[] PRODUCT_URLS = new String[] {
        "http://127.0.0.1:8080/shop/product/vintage-courier-bag.html/ref=c:2",
        "http://127.0.0.1:8080/shop/product/vintage-laptop-bag.html/ref=c:3",
        "http://127.0.0.1:8080/shop/product/vintage-exotik-carry-bag.html/ref=c:2,2",
        "http://127.0.0.1:8080/shop/product/vintage-bag-with-leather-bands.html/ref=c:1,4"
    };

    private static String randProdURL() {
        return PRODUCT_URLS[RAND.nextInt(PRODUCT_URLS.length)];
    }

    @Override
    public void run(String... args) {
        Thread thread = new Thread() {
            public void run() {
                for (;;) {
                    try { Thread.sleep(10000); } catch (InterruptedException ie) { }
                    HttpUtil.Get(randProdURL());
                    HttpUtil.Get("http://127.0.0.1:8080/shop/category/laptop-bags.html/ref=c:3");
                }
            }
        };
        thread.setDaemon(true);
        thread.start();
    }
}
