# EECS2030-A3
MLS

This is a simple MLS system with little DB access
Also a project for 2021 Summer EECS2030 course Assignment 3

Report On EECS 2030 A3

This project is intended to create a Multiple Listing Service for a real estate company, which handles the CRUD (Create, Read, Update and Delete) of MLS information records. The project is developed using Java Language and through Maven project combined with SpringBoot Web API and simple Web Pages. 

Structure: 
The initial project from A2 was simplified version with less attributes and single class implementation. On this project, we used 4 type of class objects to decompose the information of an MLS record, an Owner class for owner, a Building class for Property, a Parking class for parking, Last, we have the MLS class which composed by all three other objects and some information related to that relation, such as Listing Name, Listing Date, Listing Type, etc. Such implementation not only provided more flexibility on further implementation of other functions or attributes of the owner and parking class, but also perfectly align with the implementation of different table of entities in Database.  
As for building class, we decided to make it abstract since it can divide into several different subtypes such as Condo, Detached, Semi-Detached, Townhouse, Land etc. And each subtype could have different preset values and behavior. Also, we used builder design on Building types, with only the Building object has a builder class and subtypes calling it.
To better display a bunch of information as text, we developed a Interface for all classes. Function Display() is more than toString().
![UML](https://user-images.githubusercontent.com/81537377/126907541-ef1d9a7b-5d70-4753-a003-f3d0bd56feed.jpg)

GUI and API:
MLSApplication and MLSSpringBoot are the Web GUI and API handler built by spring Boot. Both GUI and API are open on port 9000 (Can change in project property file), once the project runs, we disabled security function to grant easier access for testing. Several JSP files are made as templates for GUI. But style sheet was not developed, so the page looks kind raw. On url = …/mls, the program returns an Application/Json Type result of certain MLS info. Other types of API, Building, Owner and Parking specifically, is turned off on mapping, and only used when construct MLS object and GUI requests.

Caching:
	The caching function is developed with singleton cache design, which speeds up the second read request on the same MLS object, also prevented direct modification on the DB original data. This provided redundancy for mistakes or bad data modifications. Another Cache or registry is the ViewingID class, which provide the id for Controller to know which object is currently using.

JDBC:
In A2, the Data was provided in a txt file, which is slow in read and difficult on modification. A Mysql JDBC(Java Data Base Connector) is provided and implemented partially to retrieve data from MySql Server in this project. Mainly the read part is ready, but create and update is not yet implemented.

Team Work：
	In general, all members have a strong willing to spend more effort in this project, however, some of the teammates are not skilled enough to accomplish given task perfectly. Sometimes people wasted effort on wrong structure or sometimes having syntax errors when put file together. All members should practice more on collaboration, especially online collaboration. Also get familiar with git repositories. As team leader, human resource and task division are also important。 

Imperfections:
There are a lot of imperfect places in the “end” source code. Including: Lack of exception handling in some cases, Bad organization on code structure which reduces the readability (Especially in MLSSpringBoot) and over simplified Javadoc. Also unfinished GUI part is also an imperfection. The main reason is time shortage, The page and function robustness can be improved if more time given.

Github Page of this project:
https://github.com/KenRen98/EECS2030-A3
