package com.company;

public class Token {

    private int value;

    public Token(int value)
    {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String toString()
    {
        return "T_"+value+"_";


    }

}
