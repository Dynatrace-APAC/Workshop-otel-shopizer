package com.salesmanager.shop.store.controller.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

@Component
public class GoRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(GoRunner.class);

	private static class StreamGobbler implements Runnable {
	    private InputStream inputStream;
	    private Consumer<String> consumer;

	    public StreamGobbler(InputStream inputStream, Consumer<String> consumer) {
	        this.inputStream = inputStream;
	        this.consumer = consumer;
	    }

	    @Override
	    public void run() {
	        new BufferedReader(new InputStreamReader(inputStream)).lines()
	          .forEach(consumer);
	    }
	} 

    public static void info(String msg) {
        LOGGER.info("[PROCESS OUTPUT] " + msg);
    }   

    @Override
    public void run(String... args) {
        Thread thread = new Thread() {
            public void run() {
                try {
                    Path currentRelativePath = Paths.get("");
                    String s = currentRelativePath.toAbsolutePath().toString();
                    LOGGER.info("Current absolute path is: " + s);
                    File gosrvc = new File(new File(s).getParentFile(), "gosrvc");
                    ProcessBuilder builder = new ProcessBuilder();
                    builder.command("go", "run", ".");
                    builder.directory(gosrvc);
                    Process process = builder.start();
                    StreamGobbler streamGobbler = new StreamGobbler(process.getInputStream(), GoRunner::info);
                    Executors.newSingleThreadExecutor().submit(streamGobbler);
                    int exitCode = process.waitFor();
                    LOGGER.info("GoRunner exiting");
                } catch (Throwable thrown) {
                    thrown.printStackTrace(System.err);
                }
            }
        };
        thread.setDaemon(true);
        thread.start();        
    }
}
