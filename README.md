# one16-challenge solution
My solution for the one16 Six Letter Words API challenge that can be found [below](https://github.com/Thomarkey/one16-challenge/new/master?readme=1#the-challenge)

This application is written in Java and Spring Boot


### Prerequisites

Make sure you have the following prerequisites installed:

- Java 11 or higher
- Maven (if you are building the project from source)

  
### Getting Started

To run the application locally, follow these steps:

1. Clone the repository to your local machine.
2. Navigate to the project root.
3. Build and run the application using Maven: `mvn clean package`
4. Run the JAR: `java -jar target/one16-challenge-1.0.0.jar`
5. Access the application and endpoints in your web browser at `http://localhost:8080`
6. The solution can be found at the solution endpoint `http://localhost:8080/api/solution`


### Configuration
The project is configured using the application.properties file. You can adjust properties like input.file.path and word.length to customize the behavior


### Testing
The project includes unit tests to verify the functionality. You can run the tests with Maven using the following command:

`mvn test`

### Contributors

Created by thomarkey




## The challenge
### Six Letter Words API
Hereby a file, input.txt, that contains words of varying lengths (1 to 6 characters).

Your objective is to show all combinations of those words that together form a word of 6 characters. That combination must also be present in input.txt  
E.g.:
``` 
foobar  
fo  
obar
```
should result in the output: 
```
fo+obar=foobar
```
You can start by only supporting combinations of two words and improve the algorithm at the end of the exercise to support any combinations.
Treat this exercise as if you were writing production code; think unit tests, SOLID, clean code and architectural healthy design. 
Be mindful of changing requirements like a different maximum combination length, or a different source of the input data.

The solution is best stored in a git repo that you communicate to us. 
After the repo is cloned, the application should be able to run with one command / script.  
You can create a docker, a runnable jar, a launch script, anything that works.  Just include a Readme file that guides us through the process.

A good extra to do is the create an API that can be called with a request containing a list of words and then returning the output as described above.
Or to store the result in a database (H2 for instance) to show that you can talk to a database.

For instance a call with curl, or a postman collection included in you project might help us.  We are your customers and we are lazy ;-).

>curl --request POST 'http://localhost:8080/api/file' --data '@input.txt' --header "Content-Type: text/plain" >> output.txt

Spend as many time as you want, but please communicate the amount of time you spent on the project.
The idea is that we just can look at some code by your hand...  most people spent 1 to 2 hours tops on this exercise.

If you have any questions feel free to contact us!

Good luck!
