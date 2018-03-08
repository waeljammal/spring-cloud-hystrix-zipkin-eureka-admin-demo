# Usage Instructions

**Preparation:**

- Clone this repo
- cd into it
- clone git@github.com:waeljammal/poc-ground-config.git

For local Spring cloud config will load it's configuration from the **poc-ground-config** directory.

**Local Development:**

If you just want to run the project from the command line you can use the following steps:

- mvn package
- docker-compose -f docker-compose-all.yml up -d --build

**Using an IDE:**

If you would like to use an ide make sure you start up the docker-compose.yml file first.

You can open the project in an IDE like InteliJ and start up the following services in the given order first:

- grd-discovery
- grd-config
- all the other services and support app's

**Support URL's:**

- Eureka: http://localhost:8761/
- Zipkin: http://localhost:9411/zipkin
- Admin (Includes Hystrix): http://localhost:8766/
- RabbitMQ: http://localhost:15672/ (demo/password)
- Swagger: http://localhost:8765/swagger-ui.html

**API:**

curl -X GET \
  http://localhost:8765/user/profile \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json'