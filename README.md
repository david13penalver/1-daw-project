
![Dimentials Logo](/documentacion/english_readme/img_readme/logo.png)

## Table of Contents

- [What is Dimentials?](#introduction)
- [Made by](#members)
- [Design](#design)
- [Frontend](#front)
- [Backend](#back)
- [Database](#db)
- [UML](#uml)
- [Deployment](#deployment)
- [Organization](#org)


# 0. What is Dimentials? <a name="introduction"></a>
Dimentials is a multidisciplinary project that revolutionizes the world of merchandising and games through a unique collection of creatures originating from multidimensional portals. These creatures, grouped by their dimension of origin, share physical characteristics that make them unique and recognizable, ranging from Jurassic environments to realms made entirely of sweets. Inspired by the visual style and creative richness of iconic franchises like Pokémon, Digimon, and Yu-Gi-Oh, Dimentials offers both a fresh and familiar experience.

The Dimentials website serves as a window to the universe of these extraordinary creatures, promoting not only their discovery but also the acquisition of the innovative collectible card game "Dimentials Calamity Conquest". This first trading game invites players to dive into strategic battles and collecting, marking the beginning of an unprecedented adventure in the realm of card games.


# 1. Made by (alphabetically) <a name="members"></a>
- [David Peñalver Navarro](https://github.com/david13penalver/)
- [Borja Rubio González](https://github.com/BorjaRubio)
- [Antonio Suárez González](https://github.com/lueyo31/)

# 2. Design <a name="design"></a>
## Technologies used

- GIMP and "IA tools" <br>
The cards have been designed using artificial intelligence tools, such as Krea.ia or Bing Images Generator, and image and illustration design tools like Adobe Photoshop and Adobe Illustrator. 

Within our capabilities, we have tried to maintain the visual style of each of our creatures and their evolutions, so that the narrative of each monster does not clash with the universe we have created.

- Miro <br>
Miro became a blank canvas on which to paint, on which to start planning our mockups, our databases, and our classes.

## Color Palette 

![Color Palette](/documentacion/english_readme/img_readme/color_palette.png)
The colours simulate the different dimensions from which the creatures come. The black and white are the main colours of the website, as they are neutral and professional. The rest of the colours are used to differentiate the different dimensions.

## Pages and design decisions

We have two clear inspirations for this project. On one hand, we have tried to adopt the minimalist and professional style of Apple, making the alternation between black and white recurrent. On the other hand, we have taken the structure from the successful Pokémon Trading Card Game sales website to understand how we should approach this project.

## Typography

The Dimentials logo features a unique and custom typeface, still unnamed. The idea is that seeing it strikes you and gives you a sense of energy.

The rest of the website uses the "Poppins" font, as we found it simple, friendly, and professional.

#  3. Frontend <a name="front"></a>
## Technologies used

- Visual Studio Code <br>
Visual Studio is a Microsoft IDE for developing applications on various platforms, supporting multiple programming languages and featuring tools for code editing, debugging, and version control. We have used it in the frontend and at the database mainly.

- Bootstrap <br>
We have used these tools to create dropdown menus, implement buttons, and, in general, save ourselves tedious work in CSS.

## Programming languages

- Thymeleaff <br>
Thymeleaf is a modern server-side Java template engine for web and standalone environments. It is a better alternative to JSP (JavaServer Pages) and other template engines like Velocity. It is designed to be both human-friendly and machine-friendly. We have used it to create our web pages.
- Javascript <br>
JavaScript is a programming language that conforms to the ECMAScript specification. JavaScript is high-level, often just-in-time compiled, and multi-paradigm. It has curly-bracket syntax, dynamic typing, prototype-based object-orientation, and first-class functions. We have used it to create our web pages.

We have used mark up languages too: HTML, CSS and SCSS (SASS, specifically).


# 4. Backend <a name="back"></a>
## Technologies used

- Visual Studio Code <br>
Some of our members prefer to use this tool in all the programming languages, so it has been used at the backend part too.

- JetBrain IntelliJ Idea Ultimate Edition <br>
Thanks to our student account, we have had the opportunity to use the professional version of the widely used IDE of JetBrains for Java language.

- MySQL Workbench <br>
We have also used this software in order to create our database. 

- MySQL 8.0 Command Line Client <br>
At the deployment, we had to create the database, the tables and insert the different lines of code (insertios, users, roles...) with the console. 

## Programming languages

- Java <br>
Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible. It is a general-purpose programming language intended to let application developers write once, run anywhere (WORA), meaning that compiled Java code can run on all platforms that support Java without the need for recompilation.

- Spring <br>
Spring Boot is an open-source Java-based framework used to create a micro Service. It is developed by Pivotal Team and is used to build stand-alone and production-ready Spring applications. This is a Spring module that provides the RAD (Rapid Application Development) feature to the Spring framework.

- SQL <br>
SQL is a domain-specific language used in programming and designed for managing data held in a relational database management system, or for stream processing in a relational data stream management system. We have used it with MySQL.


# 5. Database <a name="db"></a>

![Entity-Relationship Diagram](/documentacion/diagrama_entidad_relacion_erd/bdproyecto.png)

## DBMS
- MySQL <br>
MySQL is an open-source relational database management system. Its name is a combination of "My", the name of co-founder Michael Widenius's daughter, and "SQL", the abbreviation for Structured Query Language. We have used it to create our database.

## Design
The design of the database contains the six entites we can see at the picture before. 
The entity User contains the information related to the different users of the database: admins and buyers. Order_global is where we store the information related to the orders made by the users. Oder_detail is where we store the information related to the cards that are in the orders.
The entity Card contains the information related to the cards that are in the database. Here we have an inheritance with Monster and Spell. It is a partial inheritance, as in the future it is possible that they appear more types of cards. It is also a disjoint inheritance, as a card can only be a monster or a spell.

# 6. UML <a name="uml"></a>

UML (Unified Modeling Language) is a standardized visual modeling language used in software engineering to design, visualize, and document software systems. It provides a set of graphical notations for representing the structure, behavior, and interactions of the system components. UML diagrams, such as class diagrams, use case diagrams, and sequence diagrams, are widely used to communicate and analyze the system's architecture and design.

Our case diagram is the following:

![Use Case Diagram](/documentacion/diagrama_clases_uml/diagrama_casos_usos.png)


# 7. Deployment <a name="deployment"></a>

## Amazon Web Server
Amazon Web Server is a cloud service that provides secure, resizable compute capacity in the cloud. It is designed to make web-scale cloud computing easier for developers. We have used it to deploy our website.

In order to deploy our website, we have followed the following steps:
1. We have used the Maven function "verify" to create the .jar file.
2. We have created an account in AWS and we have created an EC2 instance.
3. We have uploaded the .jar file to the instance.
4. We have created the database at the RDS instance.
5. We have connected the database with the .jar file.
6. We have created the security groups to allow the traffic to the website.

# 8. Organisation <a name="org"></a>

## Task management

We have used SCRUM as our methodology, and we have used GitHub Projects to manage our tasks. We have created a board with the different columns: To Do, Doing, Done, and Review. We have also created a column for the different sprints we have done.
The sprints have had a duration of two weeks and, after each one, we have done a review of the work done and a retrospective to see what we can improve in the next sprint.
Finally, in order to communicate with each other, we have used Discord, as it is a very easy tool to use and it has a lot of functionalities that have helped us to communicate with each other.

## VCS
To keep a lineal history of the project, we have used GitFlow as our branching model. We have created a branch for each feature we have implemented and, once it has been reviewed, we have merged it into the main branch.

