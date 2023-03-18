Firebase Authentication is a popular choice among web developers for implementing authentication on their websites. As a result of my curiosity, I developed a custom web authentication system in order to gain a deeper understanding of the underlying mechanics.
Building a solid understanding of fundamental principles provides a more comprehensive understanding of the topic for me.

How it works: 

I created a Spring application connected to a MySQL Database.

When a user create a new account (client side), a customised stored procedure is executed in MySQL (server) to generate a unique salt for the password, which is then hashed using the SHA-256 algorithm. It is important to note that the original password is never stored in the database.
In order to authenticate users during the login process, another stored procedure is executed in MySQL to verify whether a specific salt is linked to the provided username. If the username exists, the stored procedure takes the salt and user input to generate a new password, which is then compared with the hashed password stored in the database.

Back-end: 
-Spring Boot
- MySQL
Front-end
- HTML
- JavaScript
