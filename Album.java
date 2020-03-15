package com.joelGefen;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String albumName;
    private ArrayList<Song> songs;

    public Album(String albumName) {
        this.albumName = albumName;
        this.songs = new ArrayList<>();
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void addSong(String title, double duration){

        this.songs.add(new Song(title,duration));
    }

    //add to playList by typing in track number

    public boolean playList(int trackNumber, LinkedList<Song> playList){
        int index = trackNumber -1;
        if (trackNumber >= 0 && trackNumber < this.songs.size()){
            playList.add(this.songs.get(index));
            return true;
        }
        return false;
    }

    //add to playList by typing in the name of the song
    public boolean playList(String songName, LinkedList<Song> playList){
        Song checkedSong = checkSong(songName);
        if (checkedSong != null){
            playList.add(checkedSong);
            return true;
        }

        return false;
    }



    private Song checkSong(String songName){

        for (Song searchSong : this.songs){
            if (searchSong.getTitle().equals(songName)){
                return searchSong;
            }
        }
        return null;
    }

}
