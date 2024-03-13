<h1 align="center"> DM112 Project </h1>

---

## Introduction

The purpose of this work is to implement the delivery logistics service as a micro service of the complete purchase 
project. It is possible to identify, signal and verify whether or not the delivery has already been made by the system.
We also have the service of sending an e-mail to the customer after the delivery is made.

In this project, H2 was used for storage.

---

## Technologies

What I used to develop the project:</p>

<div align="left">

![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)
![Intellij](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=Postman&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)
![Maven](https://img.shields.io/badge/apache_maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)


</div>

---


## Steps to run the Project

<h3> Running the application:</h3>
Use the following command to clone the project on terminal of your choice in a folder to use in your Windows OS, in this
case:

```bash
$ git clone https://github.com/izaltinoromao/trabalho-dm112.git
```

To build the project, use this command on terminal of your choice in a folder to use in your Windows OS, in this case,
where the project was cloned:

```bash
$ mvn clean install
```


---

# Endpoints

## Endpoints of Request

To confirm a delivery and send the email:
`PUT  http://localhost:9090/PedidoDM112/api/orders/1/delivery-confirmation`

To read the existing order list:
`GET  http://localhost:9090/PedidoDM112/api/orders`

To create a delivery receipt:
`POST  http://localhost:8081/EntregaDM112/api/make-delivery?orderNumber=2&receiverCpf=111.111.111-11`

It is necessary to use a valid Pokémon in the URL;

