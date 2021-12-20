package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Game snakeladder =new Game();
        snakeladder.addPlayer("Owais");
        snakeladder.addPlayer("Massoom");
        snakeladder.addPlayer("Nishant");
        snakeladder.addPlayer("Abu qamar");
        try {
            snakeladder.startGame();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
