# codechallenge_QA
QA Challenges

## Challenge 1

QA Challenge
Given the requirements for a set of applications which span a number of different platforms, develop a testing strategy that will ensure that each application receives some degree of testing, such that the full set of applications could be released to the public.  For the purposes of this exercise, please assume the following:
You are the only QA resource for this set of applications
This strategy will detail the next 3-6 months of effort required to test these applications
You are allowed to delegate some tasks to developers, but those tasks should not significantly impact their existing workloads

Please consider the following points, and include them in your strategy:
For each of the following, what tools will be used and how will they be used?
Continuous integration
Bug tracking
Code coverage
End to end automation
What language will automated tests be written in?
How will you prioritize the necessary work?

Please be as specific as possible in your strategy document.  Include expected timelines and deliverables if possible.  This document should demonstrate:
Your ability to recognize the most important QA tasks in a project
Your ability to prioritize and organize an overwhelming amount of work
Your ability to research, evaluate, and recommend appropriate tools
Your ability to learn and understand new technologies in order to do a job

Your strategy should clearly explain the following:
What needs to be done today
What needs to be done this week
What needs to be done this month
What needs to be done in the next 3 months
What still needs to be done after that

The following applications use the Rotten Tomatoes API to perform a common set of functions across multiple platforms.
 

Android App
Rotten Tomatoes
The requirements:
Be able to search by movie title and display the results in a list or grid. (with the movie image and optionally the title if appropriate)
Show "In Theater" movies in a list or grid. (with the movie image)
Show the details of a movie when a movie is clicked. (Show off your skills and display the movie details any way you wish)
Must use fragments.
Must use RecyclerView.
Layout & Design:
Please refer to the PNGs and .sketch file in the Design directory for layout requirements. (You may need the Roboto font to view the .sketch file; we've included it in /Design/Fonts)
Application design should resemble these mockups as closely as possible.




iOS App
Design and Specs of iOS app
Using the rotten tomatoes api, an app is created using a horizontal scroll view with the poster data including a small area for movie metadata.
Key Features
Posters are horizontal scrolling with each poster centering in the middle
movie data is changed to match currently selected poster
Tapping on poster should bring up a modal with more movie details
All data pulled from Rotten tomatoes feeds (any feed or series of movies, minimum of 5 movies)
design is an example, feel free to make it your own
Use Xcode 7 and swift 2 (or xcode 6 and swift 1)
Favoriting and saving movies
User registration and login using the keychain
3D Touch shortcuts


Scala App
A web service that wraps rotten tomatoes api
Web service should be able to parse json bodies as well and return movie results
Bonus points for unit tests
Bonus points for Actor Per Request
Bonus points for logger requests to rabbitMQ or kafka
Bonus Points Overall
Show clear code that is easily testable.
Show understanding of the functional paradigm.
Add a typesafe config to your final project.

Message Queue
Two java modules that will communicate over RabbitMQ: Module A and Module B. Both modules will communicate with a rest api.
https://www.rabbitmq.com/java-client.html
All data should be sent as json.
Modules should load the following configurations from a file (one file for each module):
RabbitMQ host
RabbitMQ credentials
Name of exchange to listen on
Type of exchange (e.g. topic, fanout, etc)
Routing key
Module A and Module B should connect to RabbitMQ using different credentials.
Module A and Module B should listen for messages on separate exchange/routing-key combinations.
Module A will send requests to Module B; Module B will send responses to Module A in any order.
Module A should send in each of its requests the exchange/type/routing-key combination that Module B should respond on.
Module B should send its responses to Module A using the received exchange/type/routing-key combination.
Receiving messages from the Rabbit queue should be non-blocking; each message should be handled in a worker thread.
You may queue the messages consumed from Rabbit internally.
The data.
You will query RottenTomatoes for Opening Movies in Module A. Module A should then send each movie individually to Module B using RabbitMQ. For each movie Module B receives it should query RottenTomatoes for the Full Cast and send it back to Module A according to the rules in the challenge description. For each Full Cast received from ModuleB, Module A should save the Movie with its Full Cast to a file.
RottenTomatoes key: yy5at44a4hzqqbsgnm4u47ju Docs: http://developer.rottentomatoes.com/docs

Web App
A Node application which uses data obtained from RottenTomatoes through its API, which will:
Be able to search by movie title and display the results in a list or grid. (with the movie image and optionally the title if appropriate)
Show "In Theater" movies in a list or grid. (with the movie image)
Show the details of a movie when a movie is clicked. (Show off your skills and display the movie details any way you wish)
Movies currently in the theater will show a link or map which displays nearby theaters and showtimes for the movie in question, along with a way to purchase tickets for the movie.
The Node application will use the Message Queue system to query further information about the movie.


## Challenge 2

Establish a method of ensuring correct processing of data in Apache Spark and Kafka based framework.

The Goal of this framework shoul be an automation framework that achieves the following:

Establish Environment Readiness on Deployment
Verify Data is existing and displaying / pollable correctly

Pick any dataset(s) off of here for the challenge. https://github.com/caesar0301/awesome-public-datasets

How do you verify if data has been properly converted in a stream like XML to json?

