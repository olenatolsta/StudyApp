package com.studyapp.stringArray;

import java.io.IOException;
import java.util.Scanner;

public class StringHandler {

    //Constructor
    StringHandler() {
    }

    //declare a variable, that's going to store the array
    String[] stringArray;

    //Initialize the initial array
    public String[] initArray() {
        int count = 0;
        int strCount = 0;
        Scanner inputString = new Scanner(System.in);
        Scanner response = new Scanner(System.in);
        do {
            System.out.println("How many strings are you going to input?");
            while (!response.hasNextInt()) {
                System.out.println("That's not a number. Please input a digit to proceed");
                response.next();
            }
            strCount = Integer.parseInt(response.next());
        } while (strCount <= 0);
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

    //Find a position of an element in an array
    public int indexOf(String value) {
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public long charsCount(String arr) {
        long totalChars = arr.chars().count();
        return totalChars;
    }

    public String longestString(String[] arr) {
        long maxChars = 0;
        String maxStringValue = "";
        for (int i = 0; i < arr.length; i++) {
            if (charsCount(arr[i]) > maxChars) {
                maxChars = charsCount(arr[i]);
                maxStringValue = arr[i];
            }
        }
        return maxStringValue;
    }

    public String shortestString(String[] arr) {
        long minChars = 0;
        String minStringValue = "";
        for (int i = 0; i < arr.length; i++) {
            if (charsCount(arr[i]) < charsCount(arr[0])) {
                minChars = charsCount(arr[i]);
                minStringValue = arr[i];
            } else minStringValue = arr[0];
        }
        return minStringValue;
    }

    public void biggerAverage(String[] arr) {
        long avgChars;
        long sumChars = 0;
        for (int i = 0; i < arr.length; i++) {
            sumChars = sumChars + charsCount(arr[i]);
        }
        avgChars = sumChars / arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (arr.length < 1) {
                System.out.println("The arrays length is less than 2 elements. Input more elements to complete the task");
            } else if (arr.length > 1 && charsCount(arr[i]) > avgChars) {
                System.out.println(arr[i]);
                System.out.println(charsCount(arr[i]));
            }
        }
    }

    public void lessAverage(String[] arr) {
        long avgChars;
        long sumChars = 0;
        for (int i = 0; i < arr.length; i++) {
            sumChars = sumChars + charsCount(arr[i]);
        }
        avgChars = sumChars / arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (arr.length < 1) {
                System.out.println("The arrays length is less than 2 elements. Input more elements to complete the task");
            } else if (arr.length > 1 && charsCount(arr[i]) < avgChars) {
                System.out.println(arr[i]);
                System.out.println(charsCount(arr[i]));
            }
        }
    }

    public int minElement(int[] arr) {
        int minElement = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[0]) {
                minElement = arr[i];
            }
        }
        return minElement;
    }

    public void task1() {
        String[] arr = initArray();
        printArray(arr);
        System.out.println("The longest string is: " + "\"" + longestString(arr) + "\"");
        System.out.println("The longest string length is: " + charsCount(longestString(arr)) + "\"");
        System.out.println("The shortest string is: " + "\"" + shortestString(arr) + "\"");
        System.out.println("The shortest string length is: " + charsCount(shortestString(arr)) + "\"");
    }

    public void task2() {
        String[] arr = initArray();
        printArray(arr);
        System.out.println("The strings, which length is more than average and their length are: ");
        biggerAverage(arr);
    }

    public void task3() {
        String[] arr = initArray();
        printArray(arr);
        System.out.println("The strings, which length is less than average and their length are: ");
        lessAverage(arr);
    }

    public String uniqueChars(String str) {
        StringBuffer uniqueStr = new StringBuffer(); // a string for unique symbols
        String c; // current symbol in the string
        for (int i = 0; i < str.length(); i++) {
            c = String.valueOf(str.charAt(i)); // get a current symbol
            if (uniqueStr.indexOf(c) == -1) // find a symbol, which is new
                uniqueStr.append(c); // adding to the string
        }
        return uniqueStr.toString(); // returning result string
    }

    public void task4() {
        String[] arr = initArray();
        printArray(arr);
        String goal = arr[0]; // a word which we search for
        for (int i = 1; i < arr.length; i++) {
            if (uniqueChars(arr[i]).length() < uniqueChars(goal).length())
                goal = arr[i]; // new minimal element
        }
        System.out.println("A word with min different symbols " + goal + ", quantity of different symbols: " + uniqueChars(goal).length());
    }

    public boolean isNumeric(String strNum) {
        if (strNum == null) {  //verification, that the string is not empty
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);      //checking, whether the string consists of numbers only
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public void task5() {
        String[] arr = initArray();
        printArray(arr);
        String goal = arr[0]; // a word which we search for
        for (int i = 1; i < arr.length; i++) {
            if (uniqueChars(arr[i])!=null)
                goal = arr[i]; // assigning an array element, which consists of different symbols to a result variable
        }
        System.out.println("A word with min different symbols is - " + goal);
    }

    public void task6() {
        String[] arr = initArray();
        String[] resArray = new String[2];
        printArray(arr);
        String goal = resArray[0]; // a word which we search for
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < resArray.length; j++) {
                if (isNumeric(arr[i])) {
                    resArray[j] = arr[i]; //adding a word, which consists of numbers only, into result array
                }
                if (resArray[1] != null) {  //verify, if there's only 1 word which consists of numbers only
                    goal = resArray[1];     //adding the 2nd word as a result
                }
            }
            System.out.println("A word consisting of numbers only is - " + goal);
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
            printMenu();
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
            case "2":
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
                break;
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
