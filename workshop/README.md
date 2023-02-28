## Workshop 24

export MYSQL_USER = ?
export MYSQL_PASSWORD = ?

## Configure Spriing Boot App to connection to Railway
1. Make sure pom uses the latest Mysql Connection J Driver
```
# <dependency>
#     <groupId>com.mysql</groupId>
#     <artifactId>mysql-connector-j</artifactId>
#     <version>8.0.32</version>
# </dependency>
```
2. Make sure the application.properties setup with the following attributes:

```

spring.datasource.url=${MYSQL_APP_URL} including 'jdbc:' at the front
spring.datasource.username=${MYSQL_APP_USER}
spring.datasource.password=${MYSQL_APP_PW}
#old driver 
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```