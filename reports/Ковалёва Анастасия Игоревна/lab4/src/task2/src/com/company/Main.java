package com.company;

public class Main {
    public static void main(String[] args) {
        MatherBoard matherBoard1 = new MatherBoard("634", "amd 487");
        RAM ram1 = new RAM("ram2", 123);
        Drive drive = new Drive("toshiba");
        Computer computer1 = new Computer(matherBoard1, ram1);
        computer1.setDrive(drive);
        computer1.show();

        MatherBoard matherBoard2 = new MatherBoard("246", "aaa 986");
        RAM ram2 = new RAM("ram1", 100);
        Computer computer2 = new Computer(matherBoard1, ram1);
        computer2.show();
    }
}


class Computer {
    private MatherBoard matherboard;
    private RAM ram;
    private Drive drive;
    Computer(MatherBoard matherboard, RAM ram){
        this.matherboard = matherboard;
        this.ram = ram;
    }

    public void setDrive(Drive rive) {
        this.drive = drive;
    }

    public void show(){
        System.out.println("MatherBoard info: ");
        matherboard.show();
        System.out.println("RAM info: ");
        ram.show();
        if(drive != null){
            System.out.println("Drive info: ");
            drive.show();
        } else {
            System.out.println("No drive");
        }
        System.out.println();
    }
}

class MatherBoard {
    String id;
    String socket;
    MatherBoard(String id, String socket){
        this.id = id;
        this.socket = socket;
    }

    public void setName(String id) {
        this.id = id;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public void show() {
        System.out.println("Id: " + id);
        System.out.println("Socket: " + socket);
    }
}

class RAM {
    String name;
    int power;
    RAM(String name, int power){
        this.name = name;
        this.power = power;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPower(int volume) {
        this.power = volume;
    }
    public void show(){
        System.out.println("Name: " + name);
        System.out.println("Power: " + power);
    }
}

class Drive {
    String name;
    Drive(String name){
        this.name = name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void show(){
        System.out.println("Name: " + name);
    }
}
