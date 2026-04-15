# Introduction
This project is a core microservice responsible for managing the full lifecycle of customer orders (order creation, retrieval, cancellation, and state transitions).

The service is built using **Spring Boot** and follows an event-driven architecture by publishing and consuming domain events via **Kafka**.

## Endpoints
GET
- **/v1/orders** - retrieve all orders
- **/v1/orders/{orderId}** - retrieve a specific order by orderId
- **/v1/orders/{orderId}/payment** - retrieve payment details under a specific order

POST
- **/v1/orders** - create an order 
- **/v1/orders/{orderId}/cancel** - cancel an order 

## Setup
http://localhost:8080/v1/orders

## Dependencies
- Lombok
- AWS RDS(MySQL)
