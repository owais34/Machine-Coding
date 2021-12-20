package com.company;

public class Snake implements BoardEntity{
    private int start;
    private int end;
    public Snake(int start,int end){
        assert start!=end;
        assert start<end;
        this.start=start;
        this.end=end;
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
        return "Ohh no you got bitten :( falling to position "+end;
    }
}
