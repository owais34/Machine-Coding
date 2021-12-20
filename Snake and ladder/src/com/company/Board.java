package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
    private int size;
    BoardEntity array[];
    public Board(){
        this.size=100;
        array=new BoardEntity[size+1];
        getRandomBoard(8);
    }
    public Board(int size){
        this.size=size;
        array=new BoardEntity[size+1];
        getRandomBoard(8);
    }
    public int getSize(){
        return this.size;
    }
    private boolean addBoardEntity(BoardEntity entity){
        if(entity.getStart()<=1 || entity.getStart()>=size || entity.getEnd()<=1 || entity.getEnd()>=size)
            return false;
        if(array[entity.getStart()]!=null)
            return false;
        array[entity.getStart()]=entity;
        return true;
    }
    public BoardEntity getBoardEntity(int position){
        if(position<1 || position >size)
            return null;
        else
            return array[position];
    }
    private void getRandomBoard(int entities){
        List<Integer> list=new ArrayList<>();
        Random random=new Random();
        for(int j=2;j<size;j++){
            list.add(j);
        }
        //creating snakes
        for(int i=1;i<=entities;i++){

            int index1=random.nextInt(list.size());
            int pos1=list.get(index1);
            list.remove(index1);
            int index2=random.nextInt(list.size());
            int pos2=list.get(index2);
            list.remove(index2);

            if(pos1>pos2)
                addBoardEntity(new Snake(pos1,pos2));
            else
                addBoardEntity(new Snake(pos2,pos1));
        }
        //creating ladders
        for(int i=1;i<=entities;i++){
            int index1=random.nextInt(list.size());
            int pos1=list.get(index1);
            list.remove(index1);
            int index2=random.nextInt(list.size());
            int pos2=list.get(index2);
            list.remove(index2);

            if(pos1<pos2)
                addBoardEntity(new Ladder(pos1,pos2));
            else
                addBoardEntity(new Ladder(pos2,pos1));
        }
    }
}
