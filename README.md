# Url Shortener (SpringBoot)
A rest api for shortening url developed in SpringBoot.

## Requirements
For building and running the application you need:
- Java [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- Apache [Maven 3.6.3](https://maven.apache.org/install.html)
- Spring [Boot 3.0.1](https://spring.io/projects/spring-boot)

## Tools used
- Intellij [IDEA](https://www.jetbrains.com/pt-br/idea/);
- Insomnia [Rest](https://insomnia.rest/download);

## Running the application
You can run the application directly from your preferred IDE by running `main` method in the `com.tds.shortener.ShortenerApplication` class.
Or alternatively run the command below in the application directory:

```shell
mvn spring-boot:run
```

You can also run the unit tests manually in your preferred ide. Or run the command below to run all tests at once:

```shell
mvn test
```

## Endpoints

### Generate short Url
### Request
`POST /shorten`

Body:
  ```shell 
  { "url": "https://www.amazon.com.br/ref=nav_logo" }
  ```
### Response
```shell
{
 "originalUrl": "https://www.amazon.com.br/ref=nav_logo",
 "shortUrl": "c87133"
}
```

### Redirect to original Url
Access the url through your browser of choice. 

### Request
`GET /{shortUrl}`

Example:
```shell 
localhost:8080/c87133
```
### Response
You will be redirected to your Original url.

### Get access from all shortUrl
### Request
`GET /access`

Example:
```shell
localhost:8080/access
```

### Response
```shell
[
 {
  "shortUrl": "c87133",
  "access": 1
 },
 {
  "shortUrl": "e1cc55",
  "access": 0
 }
]
```

### Get access by shortUrl
### Request
`GET /access/{shortUrl}`

Example:
```shell
localhost:8080/access/c87133
```

### Response
```shell
{
  "totalAccess": 1
}
```
