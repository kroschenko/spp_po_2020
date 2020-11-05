package com.company;

public class Main {

    public static void main(String[] args) {
        int [] inputArray1 ={0,1,3,4,55};
        int [] inputArray2 = {1,4,3,0};
        int count = 7;
        int index1= 3;
        int index2 = 2;
        Array array1 = new Array(inputArray1, count);
        Array array2 = new Array(inputArray2, count);

//print
        System.out.println();
        System.out.println("First array: ");
        array1.print();
        System.out.println("Second array: ");
        array2.print();
        System.out.println();
//check equal

        if (array1.equals(array2))
            System.out.println("Equal");
        else System.out.println("Not Equal");
        System.out.println();

//find number
        System.out.println("Search in the first array: ");

        if(array1.search(count))
            System.out.println("First array contains " + count);
        else
            System.out.println("First array doesn't contains " + count);
        System.out.println();

        System.out.println("Search in the second array: ");
        if(array2.search(count))
            System.out.println("Second array contains " + count);
        else
            System.out.println("Second array doesn't contains " + count);
        System.out.println();

//concatenation
        System.out.println("Concatenation:");
        array1.concatenation(array2);
        System.out.println();
//remove element
        System.out.println("Remove element:");
        array1.removeElement(index1);
        System.out.println();
//add element
        System.out.println("Add element:");
        array2.addElement(index2, count);
        System.out.println();
    }
}

