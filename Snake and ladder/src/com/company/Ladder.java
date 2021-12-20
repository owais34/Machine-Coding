package com.company;

public class Ladder implements BoardEntity{
    private int start;
    private int end;

    public Ladder(int index1, int index2) {
        this.start=index1;
        end=index2;
    }

    @Override
    public int getStart() {
        return start;
    }

    @Override
    public int getEnd() {
        return end;
    }

    @Override
    public String getMessage() {
        return "Ohh yess :) a ladder , leveling up to position "+end;
    }
}
