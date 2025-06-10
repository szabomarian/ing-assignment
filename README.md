# Backend Assessment
### Requirements
- maven installed with the mvn executable in the home path
- java 17. If you wish to use a newer version, go to pom.xml and adjust the java.version property accordingly
### Running the API
By default, the API starts on port 8080. If this port is already in used, adjust the `server.port` property from `application.properties`
1. clone the API
2. run the following command in a terminal `mvn spring-boot:run `

### OpenAPI documentation
The OpenAPI documentation can be found at `server_host:port/swagger-ui/index.html`
This should probably not be enabled in production.