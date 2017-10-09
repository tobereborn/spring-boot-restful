package com.github.tbr.spring.concert;

public class DefaultEncoreable implements Encoreable {
    @Override
    public void performEncore() {
        System.out.println("Encore");
    }
}
