package com.studyapp.stringArray;

import java.io.IOException;
import java.util.Scanner;

public class StringHandler {

    //Constructor, which calls an array
    StringHandler() {
    }

    //declare a variable, that's going to store the array
    String[] stringArray;

    //Initialize the initial array
    public String[] initArray() {
        int count = 0;
        System.out.println("How many strings are you going to input?");
        Scanner response = new Scanner(System.in);
        int strCount = Integer.parseInt(response.next());
        Scanner inputString = new Scanner(System.in);
        String[] stringArray = new String[strCount];
        System.out.println("Input " + strCount + " string(s). A string may consist of characters, numbers and white spaces.");
        for (int i = 0; i < stringArray.length; i++) {
            if (count < strCount) {
                stringArray[i] = inputString.nextLine();
                count++;
            }
        }
        return stringArray;
    }

    //A method to print an array
    public void printArray(String[] printArray) {
        System.out.println("Here is an array of String elements: ");
        System.out.print("[");
        for (int i = 0; i < printArray.length; i++) {
            System.out.print(printArray[i]);
            if (i < printArray.length - 1) {
                System.out.print("; ");
            }
        }
        System.out.println("]");
    }

    public void task1() {
        String[] arr = initArray();
        printArray(arr);
        long totalChars = 0;
        for (int i = 0; i < arr.length; i++) {
            totalChars = arr[i].chars().count();
            System.out.println("String " + (i + 1) + " is: " + arr[i]);
            String toPrint = arr[i];
            System.out.println("String " + (i + 1) + " length is: " + totalChars);
        }
    }

    public void printMenu() {
        System.out.println("Task 1: input n strings from console, find the shortest one and the longest one. Print the strings and their lenght. \n" +
                "Task 2: input n strings from console. Print those, which length is larger than average and also their length. \n" +
                "Task 3: input n strings from console. Print those, which lenth is less than average and also their length. \n" +
                "Task 4: input n words from console. Find a word, which has a minimal quantity of different symbols. In case there are several such words, find the first one.\n" +
                "Task 5: input n strings from console. Find a word, which consists of different symbols only. In case there are several such words, find the first one.\n" +
                "Task 6: input n words from console. Find a word, which consists of digits only. In case there are several such words, find the first one.");
        System.out.println("Tasks are numerated accordingly from 1 to 6. \n" +
                "Select any of tasks or press 7 to Exit.");
    }

    public void tasksMenu() {
        boolean closeApp;
        do {
            Scanner input = new Scanner(System.in);
            //clearScreen();
            printMenu();
            //TODO: clear screen
            String userChoice = input.nextLine();
            closeApp = userChoosesOption(userChoice);
            if (!closeApp) {
                System.out.println("Press Enter to proceed..");
                try {
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        while (!closeApp);
    }

    private boolean userChoosesOption(String userChoice) {
        boolean closeApp = false;
        switch (userChoice) {
            case "1":
                task1();
                break;
      /*      case "2":
                task2();
                break;
            case "3":
                task3();
                break;
            case "4":
                task4();
                break;
            case "5":
                task5();
                break;
            case "6":
                task6();
                break;*/
            case "7":
                closeApp = true;
                System.out.println("Exiting the program");
                break;
            default:
                System.out.println("The input is wrong. Select an option to proceed - 1-6 for Tasks execution or 7 to Exit");
        }
        return closeApp;
    }
}
