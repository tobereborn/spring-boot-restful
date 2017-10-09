package com.github.tbr.spring.soundsystem;

import org.springframework.stereotype.Component;

@Component
public class SgtPeppers implements CompactDisc {
    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }

    @Override
    public void playTrack(int trackNumber) {
        System.out.println("Playing track with id: " + trackNumber);
    }
}
