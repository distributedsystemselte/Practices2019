package models;
import java.io.*;
import java.net.*;
import java.util.*;

public class Pair implements Serializable {
    public int line;
    public int column;
    public Pair(int line,int column){
        this.line = line;
        this.column = column;
    }
}