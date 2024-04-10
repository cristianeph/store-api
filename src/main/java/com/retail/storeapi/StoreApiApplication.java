package com.retail.storeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
import com.amazonaws.serverless.proxy.spring.SpringBootProxyHandlerBuilder;
import com.retail.storeapi.controller.GreetingsController;

@SpringBootApplication
@Import({ GreetingsController.class})
public class StoreApiApplication {
	public static SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;

	public static void main(String[] args) {
		SpringApplication.run(StoreApiApplication.class, args);
	}

	public static void createHandler() {
		try {
			if (handler == null) {
				handler = SpringBootLambdaContainerHandler.getAwsProxyHandler(StoreApiApplication.class);
			}
			handler = new SpringBootProxyHandlerBuilder<AwsProxyRequest>()
					.defaultProxy()
					.asyncInit()
					.springBootApplication(StoreApiApplication.class)
					.buildAndInitialize();
		} catch (ContainerInitializationException e) {
			e.printStackTrace();
			throw new RuntimeException("Could not initialize Spring Boot application", e);
		}
	}

}
