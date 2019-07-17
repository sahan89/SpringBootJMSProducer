## *Overview*
Sample Messaging Queue Producer Application.

Sample Messaging Queue Consumer Application `https://github.com/sahan89/SpringBootJmsProducer`

## *Prerequisites*
* Java 1.8
* Maven
* MySQL
* Spring Boot
* Hibernate
* ActiveMQ

## *Build Project*
1. Create Database ```CREATE DATABASE sms_db;``` (Create Database automatically) 
2. Set Username and Password in the ```application.yml``` file
2. Setup ActiveMQ ```application.properties``` file
3. Clone the project
4. Invoke ```mvn clean install -DskipTests```
5. Navigate to target folder

## *Run Project*

Send SMS ```http://localhost:8085/api/sendSms```

Rest API body

`{
     "mobileNumber": "0702062886",
     "message": "Hello Sahan.!"
 }`

Header
`Content-Type application/json`

Get all SMS
`http://localhost:8085/api/getAllSms`
