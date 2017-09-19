Goal:
- make `SampleApplicationShould` test green.

Restrictions:
- do not change `SampleApplicationShould` test
- only sources under `com.example.application` are allowed to be modified
- do not change web container (to Tomcat)


Funny ways to make test green:
1. use Tomcat:
   * use `CallbackController#returnRequestBodyV1`
   * change dependency to `<artifactId>spring-boot-starter-tomcat</artifactId>` in pom.xml
 
   Tomcat does not have issue with unordered request param map. 
   It keeps the order and spring rebuilds body from request parameter map (see `ServletServerHttpRequest:171`) 

2. Do not define additional controllers
   * use `CallbackController#returnRequestBodyV2`
   * remove `GreetingController` from `FrameworkBeans`
   
   Spring tries to understand what method to invoke (see `AbstractHandlerMethodMapping:347`).
   It reads request parameter `name` to check if `GreetingController#helloWithName` matches request or not.
   Once parameter is read - input stream is empty
   
3. Do not use path variables
   * use `CallbackController#returnRequestBodyV3`
   * change request url in the test to `http://localhost:8080/callback`
   
   Spring skips matching phase with all controller methods if there's direct match with one of the method (see `AbstractHandlerMethodMapping:343`)
   