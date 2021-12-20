package com.company;

import java.util.Random;

public class Dice {
    private int sides;
    private Random random;
    Dice(){
        this.sides=6;
        random=new Random();
    }
    public int roll(){
        return 1+random.nextInt(sides);
    }
}
