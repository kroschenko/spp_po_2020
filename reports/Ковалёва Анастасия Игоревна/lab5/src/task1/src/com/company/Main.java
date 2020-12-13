package com.company;
import java.util.ArrayList;

interface Technique {
    void turnOn();
    void turnOff();
}
abstract class Player implements Technique {
    private boolean work;
    protected String model;

    @Override
    public void turnOff() {
        work = false;
    }

    @Override
    public void turnOn() {
        work = true;
    }

    public void Player() {
        work = false;
        model = " ";
    }
    public void Player(String model) {
        work=false;
        setModel(model);
    }
    public boolean getState() {
        return work;
    }
    abstract public void setModel(String model);
}

class VideoPlayer extends Player {
    private ArrayList<String> movies;

    public VideoPlayer() {
        super.Player();
        movies = new ArrayList<String>();
    }

    public VideoPlayer(String model, ArrayList<String> movies) {
        super.Player(model);
        this.movies = movies;
    }

    @Override
    public void turnOn() {
        super.turnOn();
        System.out.println("Player is on");
    }

    @Override
    public void turnOff() {
        super.turnOff();
        System.out.println("Player is off");
    }

    public void addMovie(String movie) {
        movies.add(movie);
    }

    public void showMovies() {
        if (super.getState()) {
            System.out.println("Movie list:");
            for (String movie : movies)
                System.out.println(movie);
            System.out.println();
        } else {
            System.out.println("Player is off");
        }
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<String> movies = new ArrayList<String>();
        movies.add("movie 1");
        movies.add("movie 2");

        VideoPlayer player = new VideoPlayer("Samsung", movies);
        player.turnOn();
        player.showMovies();

        player.addMovie("movie 3");
        player.showMovies();
        player.turnOff();
    }
}





