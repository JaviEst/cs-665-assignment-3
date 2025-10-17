
| CS-665       | Software Design & Patterns |
|--------------|----------------------------|
| Name         | Javier Esteban de Celis    |
| Date         | 10/17/2025                 |
| Course       | Fall                       |
| Assignment # | 3                          |

# Assignment Overview

This project implements an automated Email Generation application for a company that serves various customer segments including Business, Returning, Frequent, New, and VIP customers. The application generates personalized emails tailored to each customer type based on a flexible template system.


# GitHub Repository Link:
https://github.com/JaviEst/cs-665-assignment-3

# Implementation Description

This email generation application implements the **Strategy Pattern** to provide a flexible and maintainable solution for generating personalized emails for different customer segments. The implementation allows each customer type (Business, Returning, Frequent, New, and VIP) to have its own email generation strategy while maintaining a consistent structure.

The system consists of:
- A `Customer` interface that defines the contract for all customer types
- Five concrete customer classes, each implementing a specific email generation strategy
- An `EmailGenerator` abstract class that provides a template for email structure
- An `EmailGenerationApp` class that serves as the context for strategy execution

Each customer type encapsulates its own email generation behavior, making it easy to customize content for different customer segments without affecting other parts of the system.

## Flexibility

The implementation is highly flexible and extensible in several ways:

1. **Adding New Customer Types**: New customer segments can be added easily by creating a new class that implements the `Customer` interface. No modifications to existing code are required, adhering to the Open/Closed Principle.

2. **Modifying Email Content**: Each customer type's email content can be modified independently without affecting other customer types. The email generation logic is encapsulated within each customer class.

3. **Changing Email Structure**: The `EmailGenerator` abstract class provides a template for the overall email structure (greeting, body, offer, closing, signature). This structure can be modified in one place, and all customer types will inherit the changes while still maintaining their unique content.

4. **Runtime Strategy Selection**: The appropriate email generation strategy is automatically selected at runtime based on the customer type, providing dynamic behavior without complex conditional logic.

5. **Easy Testing**: Each customer type can be tested independently, making it simple to verify that each generates the correct email content.

## Simplicity and Understandability

The code is designed to be simple and easy to understand:

1. **Clear Separation of Concerns**: Each class has a single, well-defined responsibility:
   - `Customer` interface: Defines what a customer can do
   - Concrete customer classes: Implement specific customer behaviors
   - `EmailGenerator`: Provides the template for email structure
   - `EmailGenerationApp`: Coordinates email generation

2. **Descriptive Naming**: All classes, methods, and variables use clear, self-documenting names that convey their purpose (e.g., `BusinessCustomer`, `generateEmail`, `getGreeting`).

3. **Comprehensive Documentation**: Each class includes JavaDoc comments explaining its purpose, design pattern implementation, and how it fits into the overall system.

4. **Consistent Code Style**: The entire codebase follows Java conventions with 2-space indentation, making it easy to read and maintain.

5. **Minimal Complexity**: The Strategy Pattern eliminates complex conditional statements (if/else chains or switch statements) that would otherwise be needed to handle different customer types.

6. **Encapsulation**: Email generation logic is encapsulated within each customer type's inner class, keeping related code together and hiding implementation details.

7. **Easy to Follow Flow**: The email generation process follows a straightforward path: create a customer → call generateEmail() → receive personalized email.

## Design Pattern

This implementation uses the **Strategy Pattern** as the primary design pattern.

### Strategy Pattern

**Definition**: The Strategy Pattern defines a family of algorithms (email generation strategies), encapsulates each one, and makes them interchangeable. The strategy lets the algorithm vary independently from clients that use it.

**Implementation in this project**:
- **Strategy Interface**: `Customer` interface defines the contract
- **Concrete Strategies**: `BusinessCustomer`, `ReturningCustomer`, `FrequentCustomer`, `NewCustomer`, and `VipCustomer` each implement different email generation strategies
- **Context**: `EmailGenerationApp` uses customer objects without knowing their specific types

**Why Strategy Pattern is appropriate**:
1. **Multiple algorithms**: We have five different ways to generate emails, one for each customer type
2. **Avoid conditional logic**: Without this pattern, we would need large if/else or switch statements to handle different customer types
3. **Runtime flexibility**: The email generation behavior can be changed by simply using a different customer type
4. **Easy extension**: New customer types can be added without modifying existing code
5. **Encapsulation**: Each strategy encapsulates its own email generation logic


# Run the Application
This time around neither a console nor a ui interface has been implemented. Therefore, the user can only run the tests for the email generation.

To run the program you will first need to compile the code by running the following command:
```bash
mvn clean compile
```

Once the above is successfully ran, you can run the tests by running the following command:
```bash
mvn clean test
```


# Maven Commands

We'll use Apache Maven to compile and run this project. You'll need to install Apache Maven (https://maven.apache.org/) on your system. 

Apache Maven is a build automation tool and a project management tool for Java-based projects. Maven provides a standardized way to build, package, and deploy Java applications.

Maven uses a Project Object Model (POM) file to manage the build process and its dependencies. The POM file contains information about the project, such as its dependencies, the build configuration, and the plugins used for building and packaging the project.

Maven provides a centralized repository for storing and accessing dependencies, which makes it easier to manage the dependencies of a project. It also provides a standardized way to build and deploy projects, which helps to ensure that builds are consistent and repeatable.

Maven also integrates with other development tools, such as IDEs and continuous integration systems, making it easier to use as part of a development workflow.

Maven provides a large number of plugins for various tasks, such as compiling code, running tests, generating reports, and creating JAR files. This makes it a versatile tool that can be used for many different types of Java projects.

## Compile
Type on the command line: 

```bash
mvn clean compile
```


## JUnit Tests
JUnit is a popular testing framework for Java. JUnit tests are automated tests that are written to verify that the behavior of a piece of code is as expected.

In JUnit, tests are written as methods within a test class. Each test method tests a specific aspect of the code and is annotated with the @Test annotation. JUnit provides a range of assertions that can be used to verify the behavior of the code being tested.

JUnit tests are executed automatically and the results of the tests are reported. This allows developers to quickly and easily check if their code is working as expected, and make any necessary changes to fix any issues that are found.

The use of JUnit tests is an important part of Test-Driven Development (TDD), where tests are written before the code they are testing is written. This helps to ensure that the code is written in a way that is easily testable and that all required functionality is covered by tests.

JUnit tests can be run as part of a continuous integration pipeline, where tests are automatically run every time changes are made to the code. This helps to catch any issues as soon as they are introduced, reducing the need for manual testing and making it easier to ensure that the code is always in a releasable state.

To run, use the following command:
```bash
mvn clean test
```


## Spotbugs 

SpotBugs is a static code analysis tool for Java that detects potential bugs in your code. It is an open-source tool that can be used as a standalone application or integrated into development tools such as Eclipse, IntelliJ, and Gradle.

SpotBugs performs an analysis of the bytecode generated from your Java source code and reports on any potential problems or issues that it finds. This includes things like null pointer exceptions, resource leaks, misused collections, and other common bugs.

The tool uses data flow analysis to examine the behavior of the code and detect issues that might not be immediately obvious from just reading the source code. SpotBugs is able to identify a wide range of issues and can be customized to meet the needs of your specific project.

Using SpotBugs can help to improve the quality and reliability of your code by catching potential bugs early in the development process. This can save time and effort in the long run by reducing the need for debugging and fixing issues later in the development cycle. SpotBugs can also help to ensure that your code is secure by identifying potential security vulnerabilities.

Use the following command:

```bash
mvn spotbugs:gui 
```

For more info see 
https://spotbugs.readthedocs.io/en/latest/maven.html

SpotBugs https://spotbugs.github.io/ is the spiritual successor of FindBugs.


## Checkstyle 

Checkstyle is a development tool for checking Java source code against a set of coding standards. It is an open-source tool that can be integrated into various integrated development environments (IDEs), such as Eclipse and IntelliJ, as well as build tools like Maven and Gradle.

Checkstyle performs static code analysis, which means it examines the source code without executing it, and reports on any issues or violations of the coding standards defined in its configuration. This includes issues like code style, code indentation, naming conventions, code structure, and many others.

By using Checkstyle, developers can ensure that their code adheres to a consistent style and follows best practices, making it easier for other developers to read and maintain. It can also help to identify potential issues before the code is actually run, reducing the risk of runtime errors or unexpected behavior.

Checkstyle is highly configurable and can be customized to fit the needs of your team or organization. It supports a wide range of coding standards and can be integrated with other tools, such as code coverage and automated testing tools, to create a comprehensive and automated software development process.

The following command will generate a report in HTML format that you can open in a web browser. 

```bash
mvn checkstyle:checkstyle
```

The HTML page will be found at the following location:
`target/site/checkstyle.html`
