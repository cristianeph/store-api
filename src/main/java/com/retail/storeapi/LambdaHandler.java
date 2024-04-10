package com.retail.storeapi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

public class LambdaHandler implements RequestStreamHandler {

   static {
      StoreApiApplication.createHandler();
   }

   @Override
   public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
      StoreApiApplication.handler.proxyStream(inputStream, outputStream, context);
   }
}
