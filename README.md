# REST API for an Covid-19 Vaccination

* We have developed this REST API for an Covid-19 Vaccination. This API performs all the fundamental CRUD operations of any Online Cab Booking platform with user validation at every step.
* This project is developed by team of 5 Back-end Developers during project week in [Masai School](www.masaischool.com). 

## Tech Stack

* Java
* Spring Framework
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL

## Modules

* Login, Logout Module
* Doctor Module
* User Module
* Admin Module
* Dose Generation Module

## Features

* User, Doctor and Admin authentication & validation with session uuid having.
* Admin Features:
    * Administrator Role of the entire application
    * Only registered admins with valid session token can add/update/delete driver or user from main database
    * Admin can access the details of different Users, Doctors, Center and Dose.
* User Features:
    * Registering themselves with application, and logging in to it.
    * Viewing list of available Center and booking a Appointment.
    * Only logged in user can access profile updation and other features.

## Contributors

* [Akhil Gonde](https://github.com/akhilgonde)
* [Aman Roy](https://github.com/ROY-AMAN)
* [Mohit Agarwal](https://github.com/mohitagrawal22)
* [Ravi Patel](https://github.com/Ravipatel02)
* [Abusalem Mangalwedhe](https://github.com/Abusalem9)
* [Abhishek Chaudhary](https://github.com/Abhicoder01)


## Installation & Run

* Before running the API server, you should update the database config inside the [application.properties](CovidVaccination\src\main\resources\application.properties) file. 
* Update the port number, username and password as per your local database config.

```
    server.port=8089
    spring.datasource.url=jdbc:mysql://localhost:3306/CovidVaccination;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root

```

## API Root Endpoint

`http://covid19vaccinationapi-env-1.eba-becpxd2x.ap-south-1.elasticbeanstalk.com/`

`http://covid19vaccinationapi-env-1.eba-becpxd2x.ap-south-1.elasticbeanstalk.com/v2/api-docs`

`http://covid19vaccinationapi-env-1.eba-becpxd2x.ap-south-1.elasticbeanstalk.com/swagger-ui.html`


### Sample API Response for user Login

`POST: http://covid19vaccinationapi-env-1.eba-becpxd2x.ap-south-1.elasticbeanstalk.com/swagger-ui.html#/user-controller/userLoginUsingPOST_1`

* Request Body

```
    {
        "Mobile": "85022457580",
        "password": "pass@12"
    }
```

* Response

```
   Login Successful.
```
