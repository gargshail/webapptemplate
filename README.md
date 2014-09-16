mvn jetty:run

This template includes
1. spring security 
1. angular js
1. d3js
1.  partial pages and sample controller
1. websocket
1. rest-api
1. persistence layer
1. package structure for controller, model, events

few useful urls

http://localhost:8080/users
http://localhost:8080/radd  - adds a random user
http://localhost:8080/users/id  - retrieves specific user. example of reading a value from path 
http://localhost:8080/users/add  - expects json in request body. Example of reading json data into java object.

http://localhost:8080/wsexample.html


config.JPAConfig

@Configuration

@EnableJpaRepositories("com.myapp.repositories")

interface com.myapp.repositories.UserRepository extends CrudRepository handles User object

typically one repository is defined to handle one type of object
	

#login and save cookie in a jar

	curl -v -ccookiejar -d "username=fabrice&password=fab123" http://localhost:80
80/login.html

# access API using stored session id

	curl -b cookiejar  -v http://localhost:8080/users


	curl -b cookiejar -v -H "Content-Type: application/json" --data @user.json http://localhost:8080/users/add


# Adding and using a new repository
	create an interface in com.myapp.repositories that extends CrudRepository with appropriate type in template  <T, ID> 


declare a variable type of this interface and @Autowired it, in your service class


# disabling security 

remove "extends AbstractSecurityWebApplicationInitializer" from WebSecurityInitializer.java


WebSocket and STOMP messaging

MessagingController - like a regular controller. Mapped to an URL.
in this case  mapped to /hello   @MessageMapping("/hello")

This url is used by SockJS to open a websocket connection

 var socket = new SockJS('/hello');

 stopmpClient is subscribed to  greetings queue.
 stompClient.subscribe('/topic/greetings', 

it sends messasge to "/app/hello" using stompClient.send("/app/hello"

/app prefix is defined in  WebSocketConfig.java

config.setApplicationDestinationPrefixes("/app");

end point is defined
registry.addEndpoint("/hello").withSockJS();
