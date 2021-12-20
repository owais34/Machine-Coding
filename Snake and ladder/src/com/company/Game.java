package com.company;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class Game {
    private Board board;
    private Dice dice;
    private Map<String,Integer> playerList;
    Game(){
    board=new Board();
    dice=new Dice();
    playerList=new TreeMap<>();
    }
    public void addPlayer(String name){
        if(playerList.containsKey(name)){
            System.out.println("Player already present");
        }
        else{
            playerList.put(name,1);
        }
    }
    public void startGame() throws InterruptedException {
        boolean run=true;
        while(run){
            for(String name:playerList.keySet()){
                System.out.println("Turn of "+name);
                Integer currPosition=playerList.get(name);
                TimeUnit.MILLISECONDS.sleep(1000);
                int diceOp=dice.roll();
                System.out.println("Die rolled to "+diceOp);
                if(diceOp+currPosition> board.getSize()){
                    System.out.println("Sorry you have to wait");
                }
                else if(diceOp+currPosition== board.getSize()){
                    System.out.println(name+"  Won the game !!!!! ");
                    run=false;
                    break;
                }
                else if(board.getBoardEntity(diceOp+currPosition)==null){
                    playerList.put(name,diceOp+currPosition);
                    System.out.println("Advanced to position "+(diceOp+currPosition));
                }
                else{
                    BoardEntity entity= board.getBoardEntity(diceOp+currPosition);
                    System.out.println(entity.getMessage());
                    playerList.put(name, entity.getEnd());

                }
                System.out.println("-----------------------------------------------------");

            }
        }

    }
}
