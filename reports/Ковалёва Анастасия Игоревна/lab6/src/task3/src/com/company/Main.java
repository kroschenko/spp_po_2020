package com.company;

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer(new LaserPrinter());
        printer.print();
        printer.turnOn();
        printer.print();
        printer.changePrinterTo(new InkPrinter());
        printer.print();
        printer.turnOff();
    }
}

class Printer {
    private PrinterInterface printer;
    private boolean isOn;

    Printer(PrinterInterface printer) {
        this.printer = printer;
    }

    void print() {
        if (isOn) {
            printer.print();
        } else {
            System.out.println("Turn on printer!");
        }
    }

    void changePrinterTo(PrinterInterface printer) {
        this.printer = printer;
    }

    void turnOff() {
        System.out.println("printer is turned off");
        isOn = false;
    }

    void turnOn() {
        System.out.println("printer is turned on");
        isOn = true;
    }
}

interface PrinterInterface {
    void print();
}

class InkPrinter implements PrinterInterface {
    @Override
    public void print() {
        System.out.println("Printing... (InkPrinter)");
    }
}

class LaserPrinter implements PrinterInterface {
    @Override
    public void print() {
        System.out.println("Printing... (LaserPrinter)");
    }
}