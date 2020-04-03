package com.company;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Token> tokens;
    private int size;


    public Board(int value)
    {
        this.size = value;
        tokens = new ArrayList<>();
        for(int i=1;i<=value;i=i+1)
            tokens.add(new Token(i));
    }

    public synchronized int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public synchronized List<Token> availableTokens()
    {
        return tokens;
    }

    public synchronized void removeToken(Token token)
    {
        tokens.remove(token);
    }
    public synchronized Token getToken(int index)
    {

            if (index < 0 || index > size) return null;
            return tokens.get(index);
        }

}
