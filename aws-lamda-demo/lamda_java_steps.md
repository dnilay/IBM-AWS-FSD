To enable AWS lambda, we need the following dependency in our project:

<dependency>
    <groupId>com.amazonaws</groupId>
    <artifactId>aws-lambda-java-core</artifactId>
    <version>1.1.0</version>
</dependency>
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-shade-plugin</artifactId>
    <version>2.4.3</version>
    <configuration>
        <createDependencyReducedPom>false</createDependencyReducedPom>
    </configuration>
    <executions>
        <execution>
            <phase>package</phase>
	    <goals>
                <goal>shade</goal>
            </goals>
        </execution>
    </executions>
</plugin>

Simply put, to invoke a lambda function, we need to specify a handler; there are 3 ways of creating a handler:

Creating a custom MethodHandler
Implementing the RequestHandler interface
Implementing the RequestStreamHandler interface
3.1. Custom MethodHandler
We'll create a handler method that will be the entry point for incoming requests. We can use JSON format or primitive data types as input values.
Also, the optional Context object will allow us to access useful information available within the Lambda execution environment:

public class LambdaMethodHandler {
    public String handleRequest(String input, Context context) {
        context.getLogger().log("Input: " + input);
        return "Hello World - " + input;
    }
}

3.2. RequestHandler Interface
We can also implement the RequestHandler into our class and override the handleRequest method which will be our entry point for requests:

public class LambdaRequestHandler
  implements RequestHandler<String, String> {
    public String handleRequest(String input, Context context) {
        context.getLogger().log("Input: " + input);
        return "Hello World - " + input;
    }
}

3.3
public class LambdaRequestStreamHandler
  implements RequestStreamHandler {
    public void handleRequest(InputStream inputStream, 
      OutputStream outputStream, Context context) {
        String input = IOUtils.toString(inputStream, "UTF-8");
        outputStream.write(("Hello World - " + input).getBytes());
    }
}

mvn clean package shade:shade

Sign in to AWS Amazon and then click on Lambda under services. This page will show the lambda functions list, which is already created.

Here are the steps required to create our lambda:

“Select blueprint” and then select “Blank Function”
“Configure triggers” (in our case we don't have any triggers or events)
“Configure function”:
Name: Provide MethodHandlerLambda,
Description: Anything that describes our lambda function
Runtime: Select java8
Code Entry Type and Function Package: Select “Upload a .ZIP and Jar file” and click on “Upload” button. Select the file which contains lambda code.
Under Lambda function handler and role:
Handler name: Provide lambda function handler name com.baeldung.MethodHandlerLambda::handleRequest
Role name: If any other AWS resources are used in lambda function, then provide access by creating/using existing role and also define the policy template.
Under Advanced settings:
Memory: Provide memory that will be used by our lambda function.
Timeout: Select a time for execution of lambda function for each request.
Once you are done with all inputs, click “Next” which will show you to review the configuration.
Once a review is completed, click on “Create Function”.

