# poc-angular-springboot-combo
Example of Angular 6 and SpringBoot application working together

# Requirements
- JRE 1.8
- Maven
- NPM & Nodejs installed

# How to run

1. Build client with `cd angular-client && ng build --prod`
2. Move to server project `cd .. && cd springboot-server`
3. Build server project `mvn clean package`
4. Run server project `java -jar ./target/angular-springboot-combo-0.0.1-SNAPSHOT.jar`
5. Open browser on `localhost:8080`

# Notes
Better to separate the client and server due to easier CI pipeline setup and quicker delivery
