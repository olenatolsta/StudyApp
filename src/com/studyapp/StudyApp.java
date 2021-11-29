/*
 *Main.java
 *
 * Version 0.1
 */

package com.studyapp;

class ArrayHandler {
    //Constructor, which calls an array
    int arraySize;
    ArrayHandler() {
        initArray();
    }

    //declare a variable, that's going to store the array
    int[] intArray = new int[20];

    //Initialize the initial array
    public int[] initArray() {
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

    //A method to print the array
    public void printArray() {
        System.out.print("[");
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i]);
            if (i < intArray.length - 1) {
                System.out.print("; ");
            }
        }
        System.out.println("]");
    }

    public int maxNegative() {
        int maxNegat = -99;
        for (int i = 0; i < intArray.length - 1; i++) {
            if (intArray[i] > maxNegat && intArray[i] < 0) {
                maxNegat = intArray[i];
            }
        }
        return maxNegat;
    }

    public int minPositive() {
        int minPosit = 99;
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] < minPosit && intArray[i] > 0) {
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

    //Task 2. A method to find odd elements positions
    public int oddPositions() {
        int sumOdds = 0;
        for (int i = 0; i < intArray.length; i++) {
            if (i % 2 != 0) {
                sumOdds = sumOdds + intArray[i];
            }
        }
        return sumOdds;
    }

    //Task 3. A method to replace negative values with zero
    public void zeroReplace(){
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i]<0) {
                intArray[i] = 0;
            }
        }
    }

    //Task 4. A method to triple elements
    public void tripleElements(){
        for (int i = 1; i < intArray.length; i++) {
            if (intArray[i-1]>0 && intArray[i]<0) {
                intArray[i-1] = intArray[i-1]*3;
            }
        }
    }

    //Task 5.1 Minimal element
    public int minElement(){
        int minElement = intArray[0];
        for (int i = 1; i < intArray.length; i++) {
            if (intArray[i]<intArray[0]) {
                minElement = intArray[i];
            }
        }
        return minElement;
    }

    //Task 5.2 Average value
    public int averageValue(){
        int sumValue = 0;
        for (int i = 1; i < intArray.length; i++) {
            sumValue = sumValue + intArray[i];
            }
        return sumValue;
    }

  /*  public int multipleElements(){
        int initValue = intArray[0];
        int evenArray[];
        for (int i = 1; i < intArray.length; i++) {
            if(intArray[i] == initValue) {
                evenArray[i] = intArray[i];
            };
        }
        return;
        .removeElement(array, element)
    }*/

}
    public class StudyApp {
        public static void main(String[] args) {
            ArrayHandler app = new ArrayHandler();
            app.printArray();
            app.changePosit();
            app.printArray();
            System.out.println("Task 1: ");
            System.out.println("Position of max negative element is: " + app.indexOf(app.maxNegative()));
            System.out.println("Max negative value: " + app.maxNegative());
            System.out.println("Position of min positive element is: " + app.indexOf(app.minPositive()));
            System.out.println("Min positive value: " + app.minPositive());
            System.out.println("Task 2: ");
            System.out.println("Sum of odd elements is: " + app.oddPositions());
            System.out.println("Task 3. Negative elements are replaced with zero: ");
            app.zeroReplace();
            app.printArray();
            System.out.println("Task 4. Triple positive elements. New array is: ");
            app.initArray();
            app.printArray();
            app.tripleElements();
            app.printArray();
            System.out.println("Task 5. Difference between average and minimal element: ");
            app.printArray();
            System.out.println("Minimal element is: " + app.minElement());
            System.out.println("Average value is: " + app.averageValue());
            System.out.println("A difference between average and minimal element is: " + (app.averageValue() - app.minElement()));
        }
    }

