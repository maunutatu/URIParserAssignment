# Visma Request Identifier

## Answer for Visma Solutions' recruitment programming task

## Table Of Contents
- [Problem description](#problem-description)
- [Implementation description](#implementation-description)
- [Instructions](#instructions)

## Problem description

#### Problem:
Visma Solutions Oy is developing an application for identity management. With the application, users can login to integrated applications, confirm payments and sign documents. Identity management is a mobile application, and other apps can call its services through deep linking. When this is used, the identity management application would open automatically from the right in-app location. In this assignment, you will be implementing a part of this logic.

Read all the instructions carefully before you begin. Your submission for this assignment is only used for evaluating your competence towards the position.

#### Task:
Your task is to design and implement a class which is responsible for identifying what kind of requests it receives. Other apps can call the identity app using the scheme visma-identity.

A uri consists of three parts:

Example: visma-identity://login?source=severa

Scheme: visma-identity

Path: login

Parameters: source=severa

The class needs to satisfy the following requirements:
1. It takes the following information as input
   URI (type: string)
   Example: visma-identity://login?source=severa
2. It has to parse and validate that:
   Used URI scheme is right: visma-identity.
   Path is one of the allowed: login, confirm or sign
3. All parameters for a path are valid
4. Requirements for the parameters:
    - Path login:
      source(type:string)
      Example: visma-identity://login?source=severa
    - Path confirm:
      source(type:string)
      payment number(type:integer)
      Example: visma-identity://confirm?source=netvisor&paymentnumber=102226
    - Path sign:
      source(type: string)
      documentid(type:string)
      Example: visma-identity://sign?source=vismasign&documentid=105ab44
5. Class returns:
   Path
   Parameters as key value pairs
6. Is designed using the practises of object-oriented programming
7. Implementation needs to have a client, which uses the new class. You can for example implement the client as another class that uses the relevant methods.


## Implementation description:

### 0. Structuring the task
First I structured the task at hand using the following protocol:

#### 0.0 Defining the task
Defining the task clearly is the starting point when starting to complete an assignment. This task was pretty easy
to define as the task description is clearly stated in the e-mail. Task: Design and implement a class which is 
responsible for identifying what kind of requests it receives. The class receives an URI as a string. The class
parses the URI and is responsible for being able to return the path and parameters of given URI. There is three different
path options, each with different parameters. The problem is to be implemented using the practices of object-oriented
programming.

#### 0.1 Identifying components
The needs and restrictions are clear. Next up, the problem is broken down to smaller parts. Structuring the task to
different stages and components allows for clarity regarding the problem.

Components:

Create a class with the following requirements:
Take string as input (the URI). Parse that string for validation. If correct, continue by fetching the path. The path sets
the requirements for the parameters. Check which path the request is regarding and fetch the corresponding parameters from the string.
Create methods for returning said path and parameters.

Create a client object that uses the class for request identification. Free hands on this one.

#### 0.2 Roadmap the structure
Organizing the recognized structure of the task to a to-do order makes starting and continuing the work easier. Here the roadmap was
self-evident.

Roadmap:

Create the class responsible for identifying the request &rarr; Create the client using said class &rarr;
Test the implementation &rarr; Write the documentation

### 1. Planning the implementation
When the task is clearly defined and structured, it's time to pick the tools for solving it. I pondered between Scala and Javascript.
Javascript is the language fitting the job advertisements' tech stack, but I've more experience on object-oriented programming with Scala.
The assignment description asks to use the programming language I'm the most comfortable with, hence for OOP, I chose Scala.

### 2. Executing the implementation
Coding the actual implementation was fairly swift and I didn't crash into any major problems. I enjoyed the assignment. The string
parsing was straightforward with the default Scala methods. The hardest thing was thinking about the possible error situations
when parsing the received input.

### 3. Testing
Testing parts of the implementation and the implementation as a whole was done through Scala REPL and the created client
by giving manual input in the console. I did not recognize a need for further testing.

### 4. Possible improvement and alternatives
If there would be more requirements for the different request types, for example methods, a possible improvement would be creating 
a Request case class and create own classes for each request type.

### 5. Delayed inspection
If the deadline allows for it, delaying returning the assignment for a bit and then returning to it with fresh eyes can provide
insightful ideas for improvements and allows to spot previously undetected mistakes. In my case, no mistakes were found.
I improved the comments and README a bit.

### 6. UML Class Diagram
![UML Class Diagram](assets/Visma%20Identity%20UML.png)

## Instructions:

Clone the repository. Run the RequestClient. A console opens up. Provide the URI as input and observe what happens. :)