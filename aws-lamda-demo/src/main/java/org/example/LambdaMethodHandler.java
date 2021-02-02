package org.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.*;
public class LambdaMethodHandler {

    public String handleRequest(Map<String,Object> input, Context context) {

        System.out.println(input);

        return "Hello-world";

    }
}
