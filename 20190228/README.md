
# Concurrency

![]( https://i2.wp.com/www.dhunplugged.com/wp-content/uploads/2017/01/dh_344.jpg)

This material is adapted from Professor Robert Kitlei class notes.

## Useful:
* [About Threads](https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html)
* [Runnable interface ](https://docs.oracle.com/javase/6/docs/api/java/lang/Runnable.html)
* [About locks and synchronized statements]( https://docs.oracle.com/javase/tutorial/essential/concurrency/locksync.html)
* [Synchronized Methods](https://docs.oracle.com/javase/tutorial/essential/concurrency/syncmeth.html)



## Exercises

1. Make a application with two threads.
    Let one thread print the text "Hello" 10000 times on separate lines,
    and let the other print "World".

    1. Now do the same, but make the threads print the texts character by character.

    2. Keeping the character by character printing, fix 1b.

2.  Two goats are trying to cross a bridge, but they cannot pass each other.
    Instead, they meet in the middle and try to push each other off the bridge.
    To do that, a goat takes its time to gather power (between 0.5 and 2.0 seconds),
    and then moves forward one step, pushing the other goat one step backwards.
    At each push, print the position of the two goats,
    and whenever one of the goats falls off the bridge,
    the application should end, and announce which goat has managed to go through.

    The length of the bridge is given in a command line argument.

3. Make a parallel chat application.
The application starts a server on a given port, and lets two clients connect through it.
After that, the two clients can talk to each other without waiting for each other,
that is, if one of them sends a line of text to the server,
the application immediately sends the message over to the other client.

4.  Make an application that acts in a similar way to a telnet client. The application gets a machine name and a port number
as its two command line arguments.
The application then connects to the port on the machine.
Supposing the connection can be established, the application does two things simultaneously:
if the local user types in a line on the standard input,
the application transmits it to the server;
in parallel to that, if the application receives a line of text from the server,
it prints it on the standard input.
