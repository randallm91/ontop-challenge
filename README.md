# Ontop Bank Account Tranfer

RESTful API to transfer the money between the Ontop bank accounts and update the balance

### Requirements:
- Java 8 or higher
- Spring Boot
- Spring JPA

### Frameworks
- Testing
    - Junit
    - Mockito
- Database
    - MySql
- Server
    - Apache Tomcat

### Project structure

#### Sources:
Main packages for sources:

1. controller - contains the controller classes
2. entity - java-entity for tables in Database.
3. repository - Interfaces and Implementations for Data access objects, was JPARepository Interface.
4. service - handle the logic between the controller and the repository.
5. service_gateways - handle the methods to connect to the external APIs
6. service_helper - contains the classes to create the structures to make the transfers
7. validations - contains the validations for the different classes


#### Resources:

- src/main/resources/application.properties - App settings


### Available Services

#### RecipientsController

| HTTP METHOD | PATH                              | USAGE                               |
|-------------|-----------------------------------|-------------------------------------|
| POST        | /addrecipient                     | add a new recipient                 | 
| GET         | /getallrecipients                 | get all recipients                  | 
| GET         | /getallrecipients/{accountNumber} | create a new account                

#### TransactionController

| HTTP METHOD | PATH                | USAGE                                                            |
|-------------|---------------------|------------------------------------------------------------------|
| POST        | /executetransaction | execute the transaction between the banks and update the balance | 
| GET         | /showbalance        | show the balance                                                 | 
| GET         | /showfee            | show the fee                                             

#### WalletTransactionController

| HTTP METHOD | PATH                            | USAGE                             |
|-------------|---------------------------------|-----------------------------------|
| GET         | /getwallethistorybyid/{user_id} | get the wallet history by user id | 
                  


