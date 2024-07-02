### Order processing
Simple Event-Driven Microservices application using 
Spring Boot and Apache Kafka.
Use Apache Kafka as a message broker for Asynchronous communication 
between multiple microservices.
In the above architecture, OrderService, StockService, and EmailService microservices are independent of each other. OrderService is a Producer application that sends an event to the Message Broker. StockService and EmailService are Consumers who will consume the events from the Message Broker.

In this tutorial, we will also see how multiple consumers will subscribe to a single Kafka topic to consume the events/messages.


Generate services using https://start.spring.io/
- Order Service - Port:8080 - Kafka Producer
  `curl --location 'http://localhost:8080/api/v1/orders' --header 'Content-Type: application/json' --data '{"name": "order1", "quantity": 1, "price": 1000}'`
- Stock Service - Port:8081 - Kafka Consumer
- Email Service - Port:8082 - Kafka Consumer
- Base Domain Service

### KAFKA
Start Kafka Env
* Start Zookeeper Service
`C:\kafka> .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties`
* Start Kafka Broker Service
`C:\kafka> .\bin\windows\kafka-server-start.bat .\config\server.properties`
* Create Kafka Topic
`C:\kafka> .\bin\windows\kafka-topics.bat --create --topic topic-example --bootstrap-server localhost:9092`
* Write Events to Kafka Topic
`C:\kafka\bin> .\windows\kafka-console-producer.bat --topic topic-example --bootstrap-server localhost:9092`
'>hello
'>goodbye
* Read Events from Kafka Topic
`C:\kafka\bin> .\windows\kafka-console-consumer.bat --topic topic-example --from-beginning --bootstrap-server localhost:9092`

### Generate JAVA SERVICES 


Technologies:
- Maven
- Lombok
- JSON
- Kafka

