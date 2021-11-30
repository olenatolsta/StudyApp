/*
 *Main.java
 *
 * Version 0.1
 */

package com.studyapp;


class ArrayHandler {
    //Constructor, which calls an array
    //int arraySize;

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

    //A method to print an array
    public void printArray(int[] printArray) {
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
        int evenArray[] = new int[20];
        int k =0;
        for (int i = 1; i < intArray.length; i=i+2) {
            for (int j = i+2; j < intArray.length; j=j+2) {
                if (intArray[i] == intArray[j]) {
                    evenArray[k]=intArray[j];
                    k++;
                    break;
                    }
                }
            }
        int resultArray[] = new int[k];
        for (int i=0; i<k; i++){
            resultArray[i] = evenArray[i];
        }
        printArray(resultArray);
    }
}
    public class StudyApp {
        public static void main(String[] args) {
            ArrayHandler app = new ArrayHandler();
            app.printArray(app.intArray);
            app.changePosit();
            app.printArray(app.intArray);
            System.out.println("Task 1: ");
            System.out.println("Position of max negative element is: " + app.indexOf(app.maxNegative()));
            System.out.println("Max negative value: " + app.maxNegative());
            System.out.println("Position of min positive element is: " + app.indexOf(app.minPositive()));
            System.out.println("Min positive value: " + app.minPositive());
            System.out.println("Task 2: ");
            System.out.println("Sum of even elements is: " + app.evenPositions());
            System.out.println("Task 3. Negative elements are replaced with zero: ");
            app.zeroReplace();
            app.printArray(app.intArray);
            System.out.println("Task 4. Triple positive elements. New array is: ");
            app.initArray();
            app.printArray(app.intArray);
            app.tripleElements();
            app.printArray(app.intArray);
            System.out.println("Task 5. Difference between average and minimal element: ");
            app.printArray(app.intArray);
            System.out.println("Minimal element is: " + app.minElement());
            System.out.println("Average value is: " + app.averageValue());
            System.out.println("A difference between average and minimal element is: " + (app.averageValue() - app.minElement()));
            System.out.println("Task 6. Elements that are listed more than once and which indexes are odd: ");
            System.out.println("Initial array is: ");
            app.printArray(app.intArray);
            System.out.println("Resulting array is: ");
            app.multipleElements();
        }
    }
