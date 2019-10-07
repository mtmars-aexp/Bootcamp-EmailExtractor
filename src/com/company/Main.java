package com.company;
import java.nio.file.*;
import java.io.IOException;
import java.util.Stack;
import java.util.regex.*;
import java.util.HashMap;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) throws IOException {

        HashMap<String, Integer> emailHash = new HashMap<String, Integer>();
        Stack<String> emailStack = new Stack<String>();

        int[][] sortHashArray = new int[216][2];


        findWithRegex("sample.txt","@[A-Za-z0-9._-]+\\.[A-Za-z]{2,4}",emailHash, emailStack);
        printHash(emailHash);
    }


    public static void findWithRegex(String fileInput, String regexInput, HashMap<String, Integer> hashLocation, Stack stackLocation) throws IOException {

        Pattern p = Pattern.compile(regexInput); //A pattern is a series of regex that is interpreted by a matcher.
        Matcher m = p.matcher(Files.readString(Paths.get(fileInput))); //A matcher interprets a pattern to find character sequences with regex.

        while(m.find()) { //While the matcher can find the next instance of "@softwire.com" in the given input, increment the counter every loop.
            System.out.println(m.group());
            hashLocation.putIfAbsent(m.group(), 0);
            hashLocation.put(m.group(), (hashLocation.get(m.group()) + 1));

            if (stackLocation.contains( m.group() )) {
                System.out.println("Already in.");
            } else {
                System.out.println("Not already in.");
                stackLocation.push( m.group() );
            }

        }

    }


    public static void printHash(HashMap<String, Integer> externalHash) {
        System.out.println(externalHash);
    }

}

