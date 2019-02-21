# Finally getting more distributed :)

*This class and the exercises are adapted by material given by Professor Robert Kitlei*

We gonna see today
* Client - Server structure
* [Java Socket](https://docs.oracle.com/javase/7/docs/api/java/net/Socket.html)
* [Java ServerSocket ](https://docs.oracle.com/javase/7/docs/api/java/net/ServerSocket.html)


# Exercises

0.  Make a server and a client.
    Start the server on port 12345.
    Establish a client connection to it.
    The client should send a textual message on a line to the server.
    The server should send the line back, and the client should print it.

1.  The server contains a string in the beginning.
    The client should send a number (n) in textual form to the server.
    The server should print its string back n times on a line to the client.
    The client receives the server'r reply, then prints it on the standard output.

2.  The client reads numbers from a file, and sends them to the server.
    After the last number, the client sends the text "end" to the server.
    The server applies the function f(n)=2*n+1 to all numbers,
    and sends them back to the client.
    The client should print the received numbers.

    1. The same as exercise 2, but after a client has quit,
        the server should wait for another connection.
        Thus, the server never exits: it is always waiting for a client to connect,
        or is communicating with one.

3.  The client sends a filename to the server.
    The server tries to open the file.
    If the file does not exist, the server replies with an error message.
    If the file exists, the server sends the lines of the file to the client.

4.  The server keeps track of the number of clients.
    Whenever a client is connected, the server increases this number,
    sends it back to the client,
    then closes the connection and waits for the next client to come.

5.  The server stores a number, which is initially 0.
    After connection, the current client sends some numbers, then the text "exit".
    For each number sent, the server adds the number to its internal counter,
    and sends the increased value back to the client.
    When the client exits, the server starts waiting for the next client.

6.  The server waits for two connections on the same port.
    After they both have arrived, they send their names on one line.
    After that, they start exchanging messages in the following way.
    First, client 1 sends a message to the server, and the server sends this message on to client 2.
    Then, client 2 sends a message to the server, and the server sends this message on to client 1.
    The clients continue sending their messages in alternate steps.

    1. First, the server accepts n connections from clients, n being a fixed number.
       Once a client appears, he sends his name on a one line message.
       After all names have been collected, the server starts the following activity,
       and repeats it until infinity.

    The server connects all clients in order, and receives a message from all of them.
    When the clients have sent all their lines,
    the server sends all messages (along with the name of the sending client) to all clients.
