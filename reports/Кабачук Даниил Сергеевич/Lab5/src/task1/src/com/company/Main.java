package com.company;

public class Main {

    public static void main(String[] args) {
        VideoPlayer videoPlayer = new VideoPlayer(512,10,7);
        videoPlayer.print();
    }

}

interface Equipment {
    void print();
    int freeMemory();
}

abstract class Player implements Equipment {
    int memory;
    int records;

    Player(int memory, int records){
        this.records = records;
        this.memory = memory;
    }

    public abstract void print();
    public abstract int freeMemory();
}

class VideoPlayer extends Player {
    private int recordWeight;

    VideoPlayer(int memory, int records, int recordWeight) {
        super(memory, records);
        this.recordWeight = recordWeight;
    }

    public void print() {
        System.out.println("Память: " + memory + "мб \n" + "записи: " + records + "\nсвободная память: " + freeMemory() + "мб");
    }

    public int freeMemory() {
        return memory - records * recordWeight;
    }

}


