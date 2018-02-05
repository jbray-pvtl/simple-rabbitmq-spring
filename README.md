# simple-rabbitmq-spring
This is a simple Spring Boot application that allows a user to send messages to a message queue via a REST operation.

## Environment
This application requires Java 8 or higher.  A RabbitMQ instance should be accessible to the application.  By default, the application will look for the RabbitMQ instance on the host where it is running.

## Exposed endpoints
The default port is set to 8090, but can be changed by modifying the `server.port` property in the resources.properties.  The exposed operations are listed below:
```$xslt
/

/send

/retrieve
```

## Configuration
The application is configured via Spring configuration.  The RabbitMqConfiguration class contains the configuration items.  They are currently hard-coded in the class, but can be abstracted out to work with a cloud Config Server.
