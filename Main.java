package com.joelGefen;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();
    private static LinkedList<Song> playList = new LinkedList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Album album1 = new Album("hello");
        album1.addSong("sholom", 3.45);
        album1.addSong("sholom", 3.45);
        album1.addSong("super", 3.22);
        album1.addSong("smash", 2.55);
        album1.addSong("brill", 3.55);

        Album album2 = new Album("goodBye");
        album2.addSong("great", 3.21);
        album2.addSong("fantastic", 3.33);
        album2.addSong("brilliant", 4.02);
        album2.addSong("amazing", 3.00);

        albums.add(album1);
        albums.add(album2);


        albums.get(0).playList("sholom", playList);
        albums.get(0).playList("brill", playList);
        albums.get(0).playList(4, playList);
        albums.get(1).playList("amazing", playList);
        albums.get(1).playList("super", playList);
        albums.get(1).playList(2, playList);
        play(playList);
        printPlayList();
    }

    private static void printPlayList() {
        for (int i = 0; i < playList.size(); i++) {
            System.out.println(playList.get(i).toString());
        }
    }

    //options for user to quit, skip forward to next song, go to previous song, replay song
    private static void play(LinkedList<Song> playList) {

        if (playList.size() == 0) {
            System.out.println("play list is empty!");
        } else {
            System.out.println(playList.toString());
        }

        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        boolean quit = false;
        while (!quit) {

            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("end of play list");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("end of play list");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("reached beginning of play list");
                        forward = true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
                case 4:
                    printPlayList();
                    break;

            }
        }
    }
    private static void printMenu(){
        System.out.println("choose from the following:\n0 - quit\n1 - next song\n2 - previous song\n3 - print menu" +
                "\n4 - print play list");
    }

}
