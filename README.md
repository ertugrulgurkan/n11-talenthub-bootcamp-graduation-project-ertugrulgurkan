# N11 TalentHub Bootcamp Graduation Project
___
# Credit Application Center
___
### Spring Boot Application

This project provides to apply credit for users.

## Requirements

* [JDK 11+](https://www.oracle.com/java/technologies/javase-downloads.html)
* [Apache Maven](https://maven.apache.org/download.cgi) for terminal
* [Docker](https://www.docker.com/) for dockerized run

## Installing
Can be installed and run as:
### Maven
**1. Clone the application**

```bash
git clone https://github.com/n11-TalentHub-Java-Bootcamp/n11-talenthub-bootcamp-graduation-project-ertugrulgurkan.git
```
**2. Go to the project directory**
```bash
cd n11-talenthub-bootcamp-graduation-project-ertugrulgurkan
cd cd credit-backend
```
**3. Run**
```bash
mvn spring-boot:run
```
### Docker
**1. Clone the application**

```bash
git clone https://github.com/n11-TalentHub-Java-Bootcamp/n11-talenthub-bootcamp-graduation-project-ertugrulgurkan.git
```
**2. Go to the project directory**
```bash
cd n11-talenthub-bootcamp-graduation-project-ertugrulgurkan
cd n11-talenthub-bootcamp-graduation-project-ertugrulgurkan
cd cd credit-backend
```
**3. Run**
```bash
mvn clean install
docker-compose -f docker-compose.yml up -d
```


## API ENDPOINTS

### For Users

* [Show All Users](docs/api/users/show-users.md) : `GET /api/v1/users/`
* [Show User](docs/api/users/show-user.md) : `GET /api/v1/users/:nationalIdNumber`
* [Update User](docs/api/users/update-user.md) : `PUT /api/users/:nationalIdNumber`
* [Delete User](docs/api/users/delete-user.md) : `DELETE /api/users/:nationalIdNumber`

### For Credit Applications

* [Show Credit Application with NationalIDNumber and Birthdate](docs/api/credits/find-credit-applications-of-user.md) : `GET /api/v1/credit-applications/?birthdate={Date}&id={nationalIDNumber}`
* [Create Credit Application for User](docs/api/credits/create-credit-application.md) : `POST /api/v1/credit-applications`

## Other internal links
#### User Service other
* [Swagger UI](http://localhost:8080/swagger-ui/index.html) `http://localhost:8080/swagger-ui/index.html`
* [API DOCS JSON](http://localhost:8080/swagger-ui/index.html) `http://localhost:8080/api-docs`


## FRONTEND
* [Installation and Demo Picture of Frontend Project](credit-frontend/README.md)


## Author
**Ertuğrul Ayvaz Gürkan**
[github/ertugrulgurkan](https://github.com/ertugrulgurkan)