package com.company;

public class Main {

    public static void main(String[] args) {
            RealNumber one = new RealNumber(1.56f, 4.7f, 7.8f);
            RealNumber two = new RealNumber(4.7f, 7.1f);
            two.addElement(2.0f);
            two.deleteElement(1.56f);
            System.out.println(one.getElement(1));
            System.out.println(one.intersection(two));
            System.out.println("Equal (true/false): " + one.equals(two));
    }
}
