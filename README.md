# About the master project
This has 2 separate Java Spring Boot projects to Produce and Consume events from Wikimedia website (https://stream.wikimedia.org/v2/stream/recentchange). 
stream.wikimedia.org hosts services that allow one to subscribe to real-time events from Wikimedia wikis. The magic happens when both producer and consumer apps are run together..!
## Producer App
This app streams data from https://stream.wikimedia.org/v2/stream/recentchange to Kafka Broker
## Consumer App
This app consumes the events from specified topic in the Kafka Broker and inserts data into MySQL database
To run the application, we would have to create a new schema named "wikimedia" in MySQL, and provide necessary properties in application.properties
