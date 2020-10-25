# CRM System

PROJECT START STEPS:

    Pre-requisites:
    1. Java must be installed
    2. Install maven module (https://maven.apache.org/install.html).

    Steps:
    1. To run this application, do the following:
        1.a. Go to the project root directory.
        1.b. Run the following commands in the terminal/command line to build the app:
            - mvn clean install
        1.c. Run the following command(s) in the terminal/command line to run the app:
            - java -jar ./target/spring-boot-in-docker.jar

    2. Go to http://localhost:8080/ in your browser to view it.
    
PROJECT DESCRIPTION:
    
    This is a CRM system that helps manage inbound customer leads.  Let us say you are supposed to build a system that stores all the lead information and allows you to edit and update the conversation of the agents with leads. Features inclued in this project are:
    1. Fetch a lead
    2. Generate a lead
    3. Update a lead
    4. Remove a lead
    5. Mark a lead
