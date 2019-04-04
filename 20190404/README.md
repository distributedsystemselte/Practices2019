# Exam Simulation

This is a **shorten** version of an exam, during the exam, different rules will apply.

Try to do it without help from former codes or from the Internet, during the exam you'll be allowed to use the Oracle official documentation and to use half an A4 page cheatsheet, being one edge for your cheating information and the other half with ONLY your name. The cheatsheet MUST be hand written. If a student is caught with other student's cheatsheet, both students fail the exam.



## 2 Points
The first step is to create a Socket connection between a *Server* and a *Client*, where the *Client* receives information regarding two connections.

Create a Class called *ConnectionToRMI*, this class must have the following attributes:
  * *String url*
  * *integer port*
  * *String serviceName*

Make a connection and send the message "ready", once the server receives it, it will send the two objects to the client.

The client should receive the objects, unserialize it and print the information in the console. (For now these values can be arbitrary)

## 3 Points
Put the previous exercise into a multi-thread context, include a lock that allows only one connection to get the object at a time. Once the object connection is sent, the lock is released.

## 4 Points
Develop a remote class *CountConnections*, with two constructors, one has an integer (value of *n*) the other one is empty; The class has an *integer n* as attribute;

Create a method called *countMeIn* which adds 1 to *n* and return the new value of *n*;

Create a method called *dontCountMe* which simply returns the value of *n*;

Develop one RMI server that has two services, one is called "CountingFromFive" and starts a new *CountConnections* with *n*=5 and the other one  which starts with empty value for *n*;

Crate a *DeployCountConnections* with two registers one called *StartFromFive* and the other one called *StartFromZero*;

## 5 Points
Using the previous examples, deploy the two servers,

* Run the *DeployCountConnections*;
* Connect the *Client* to *Server*;
* Create two *ConnectionToRMI* objects with information to connect to *CountConnections* ;
* Collect the two *ConnectionToRMI* from the *Server*;
* Connect to the two Services on *DeployCountConnections* using the *ConnectionToRMI* objects.
