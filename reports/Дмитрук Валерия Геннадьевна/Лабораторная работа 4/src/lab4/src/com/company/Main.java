package com.company;

public class Main {

    public static void main(String[] args) {
        // mobile one
        Mobile iphone = new Mobile();
        Mobile.Parameters iphoneParameters = iphone.new Parameters();
        iphone.setModel("Iphone 7");
        System.out.println(iphone.getModel());
        iphone.setParameters(iphoneParameters); iphoneParameters.setMegapixels(12); iphoneParameters.setRam(2); iphoneParameters.setMemory(128);
        iphone.getOperatingSystem();
        iphoneParameters.getAllParameters();
        // mobile two
        Mobile samsung = new Mobile("Samsung S10+");
        Mobile.Parameters samsungParameters = samsung.new Parameters();
        System.out.println(samsung.getModel());
        samsung.setParameters(samsungParameters);
        samsungParameters.setMegapixels(16)
        ; samsungParameters.setRam(4);
        samsungParameters.setMemory(64);
        samsungParameters.setPower(2000);
        samsungParameters.setScreen("2000x4000");
        samsung.getOperatingSystem();
        samsungParameters.getAllParameters();
    }
}
