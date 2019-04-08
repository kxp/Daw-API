# Daw-API
Daw server API


Maven: https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html
* to compile: mvn clean
* to compile: mvn compile 
* to run: mvn spring-boot:run





Next changes: 
* Add id and date to Comments;
* When calling post project, we need to add something to add user_id using the get user in the authorization. That way ProjectIM doesnt need a user_id.


Tested:
- Projects:
* Get all 
* Post
* Delete
* Get single
-States:
* Put : but when sended a list the list didnt replace the previous one, need to check on phase 2 
* Delete all 
* get all project states 
-Issues:
* 

Things that we may need:
* https://github.com/isel-leic-daw/1819v-public/blob/master/LI61N/services/spring-demo/src/main/kotlin/pt/isel/daw/demo/ExampleHandlerExceptionResolver.kt
* https://github.com/isel-leic-daw/1819v-public/blob/master/LI61N/services/spring-demo/src/main/kotlin/pt/isel/daw/demo/LoggingFilter.kt
