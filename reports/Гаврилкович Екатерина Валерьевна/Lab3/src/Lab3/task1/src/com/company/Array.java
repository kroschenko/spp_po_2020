package com.company;

import java.util.Arrays;

public class Array{

    private int[] array1;
    int number;
    public Array(int[] array, int number){
        this.array1 = array;
        this.number = number;
    }
    public int[] getArray(){
        return array1;
    }
    public void print(){
        System.out.println(Arrays.toString(array1));
        System.out.println();
    }
    public boolean equals(Array array2){
        int[] newArray = array2.getArray();
        if(array1.length != newArray.length){
            return false;
        }
        Arrays.sort(newArray);
        Arrays.sort(array1);

        for(int i = 0; i < array1.length; i++){
            if(array1[i]!= newArray[i])
                return false;
        }
        return true;
    }
    public boolean search(int number){
        for(int i = 0; i < array1.length; i++){
            if(array1[i] == number){
                return true;
            }
        }
        return false;
    }
    public void concatenation(Array array2){
        int[] newArray2 = array2.getArray();

        int[] newArray = new int[array1.length + newArray2.length];
        System.arraycopy(array1, 0, newArray, 0, array1.length);
        System.arraycopy(newArray2, 0, newArray, array1.length, newArray2.length)
        ;
        Arrays.sort(newArray);
        for(int i = 0 ; i < newArray.length; i++){
            if(i == newArray.length-1 || newArray[i] != newArray[i+1])
                System.out.print(newArray[i] + " ");
        }
    }
    public int[] removeElement(int index){
        if(index < 0 && index >= array1.length && array1.length != 0){
            System.out.println("Try again!");
            System.exit(0);
        }
        int[] newArray = new int[array1.length - 1];
        for(int i = 0, k = 0; i < array1.length; i++,k++){
            if(i == index){
                k--;
            }
            else {
                newArray[k] = array1[i];
            }
        }
        System.out.println(Arrays.toString(newArray));
        return newArray;
    }
    public int[] addElement(int index, int number){
        if(index < 0 && index >= array1.length){
            System.out.println("Try again!");
            System.exit(0);
        }
        int[] newArray = new int[array1.length + 1];
        for(int i = 0, k = 0; i < array1.length; i++,k++){
            if(k == index){
                newArray[index] = number;
                newArray[index+1] = array1[i];
                k++;
            }
            else{
                newArray[k] = array1[i];

            }
        }
        System.out.println(Arrays.toString(newArray));
        return newArray;
    }
}
