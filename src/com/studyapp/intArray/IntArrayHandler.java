/*
 *Main.java
 *
 * Version 0.1
 */

package com.studyapp.intArray;

import java.util.Scanner;

class IntArrayHandler {
    //class variable - field
    int _arraySize;

    //Constructor, which calls an array
    IntArrayHandler(int arraySize) {
        _arraySize=arraySize;
    initArray();
    }

    //declare a variable, that's going to store the array
    int[] intArray;

    //Initialize the initial array
    public int[] initArray() {
        intArray = new int[_arraySize];
        for (int i = 0; i < intArray.length; i++) {
            int n = (int) (Math.random() * 15 - 5);
            intArray[i] = n;
        }
        return intArray;
    }

    //Find a position of an element in an array
    public int indexOf(int value) {
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] == value) {
                return i;
            }
        }
        return -1;
    }

    //A method to print an array
    public void printArray(int[] printArray) {
        System.out.println("Here is an array of int elements: ");
        System.out.print("[");
        for (int i = 0; i < printArray.length; i++) {
            System.out.print(printArray[i]);
            if (i < printArray.length - 1) {
                System.out.print("; ");
            }
        }
        System.out.println("]");
    }

    public int maxNegative() {
        int maxNegat = 0;// whe do you need -99 and 99
        for (int i = 0; i < intArray.length - 1; i++) {
            if (intArray[i] < maxNegat) {
                maxNegat = intArray[i];
            }
        }
        return maxNegat;
    }

    public int minPositive() {
        int minPosit = 1;
        for (int i = 0; i < intArray.length-1; i++) {
            if (intArray[i] <= minPosit && intArray[i] > 0) {
                minPosit = intArray[i];
            }
        }
        return minPosit;
    }

    //A method to change positions of elements
    void changePosit() {
        int minPositivePosition = indexOf(maxNegative());
        int maxNegativePosition = indexOf(minPositive());
        int tmp = intArray[minPositivePosition];
        intArray[minPositivePosition] = intArray[maxNegativePosition];
        intArray[maxNegativePosition] = tmp;
    }

    //Task 2. A method to find even elements positions
    public int evenPositions() {
        int sumEvens = 0;
        for (int i = 0; i < intArray.length; i++) {
            if (i % 2 != 0) {
                sumEvens = sumEvens + intArray[i];
            }
        }
        return sumEvens;
    }

    //Task 3. A method to replace negative values with zero
    public void zeroReplace() {
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] < 0) {
                intArray[i] = 0;
            }
        }
    }

    //Task 4. A method to triple elements
    public void tripleElements() {
        for (int i = 1; i < intArray.length; i++) {
            if (intArray[i - 1] > 0 && intArray[i] < 0) {
                intArray[i - 1] = intArray[i - 1] * 3;
            }
        }
    }

    //Task 5.1 Minimal element
    public int minElement() {
        int minElement = intArray[0];
        for (int i = 1; i < intArray.length; i++) {
            if (intArray[i] < intArray[0]) {
                minElement = intArray[i];
            }
        }
        return minElement;
    }

    //Task 5.2 Average value
    public int averageValue() {
        int sumValue = 0;
        for (int i = 1; i < intArray.length; i++) {
            sumValue = sumValue + intArray[i];
        }
        return sumValue;
    }

    public void multipleElements() {
       // TODO: replace 20 with dynamic value
        int evenArray[] = new int[20];
        int k = 0;
        for (int i = 1; i < intArray.length; i = i + 2) {
            for (int j = i + 2; j < intArray.length; j = j + 2) {
                if (intArray[i] == intArray[j]) {
                    evenArray[k] = intArray[j];
                    k++;
                    break;
                }
            }
        }
        int resultArray[] = new int[k];
        for (int i = 0; i < k; i++) {
            resultArray[i] = evenArray[i];
        }
        printArray(resultArray);
    }

    public void stringArrayTask() {
        System.out.println("stringArrayTask");
    }

    public void calculatorTask() {
        System.out.println("calculatorTask");
    }

    public void tasksMenu() {
        boolean validOption;
        do {
            Scanner input = new Scanner(System.in);
            String userChoice = input.nextLine();
            validOption = userChoosesOption(userChoice);
        }
        while (!validOption);

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

    public void task1() {
        printArray(intArray);
        changePosit();
        System.out.println("The array after changing positions of elements: ");
        printArray(intArray);
        System.out.println("Task 1: ");
        System.out.println("Position of max negative element is: " + indexOf(maxNegative()));
        System.out.println("Max negative value: " + maxNegative());
        System.out.println("Position of min positive element is: " + indexOf(minPositive()));
        System.out.println("Min positive value: " + minPositive());
    }

    public void task2() {
        System.out.println("Task 2. Sum of even elements: ");
        printArray(intArray);
        System.out.println("Sum of even elements is: " + evenPositions());
    }

    public void task3() {
        System.out.println("Task 3. Negative elements are replaced with zero: ");
        printArray(intArray);
        zeroReplace();
        printArray(intArray);
    }

    public void task4() {
        System.out.println("Task 4. Triple positive elements. New array is: ");
        initArray();
        printArray(intArray);
        tripleElements();
        printArray(intArray);
    }

    public void task5() {
        System.out.println("Task 5. Difference between average and minimal element: ");
        printArray(intArray);
        System.out.println("Minimal element is: " + minElement());
        System.out.println("Average value is: " + averageValue());
        System.out.println("A difference between average and minimal element is: " + (averageValue() - minElement()));
    }

    public void task6() {
        System.out.println("Task 6. Elements that are listed more than once and which indexes are odd: ");
        System.out.println("Initial array is: ");
        printArray(intArray);
        System.out.println("Resulting array is: ");
        multipleElements();
    }

}

