package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player implements Runnable {


    private String name;
    private Board board;
    private List<Token> tokens;
    private Game game;
    private boolean available = false;


    public Player(String name)
    {
        this.name = name;
        tokens = new ArrayList<>();
    }

    public synchronized String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public synchronized List<Token> getTokens() {
        return tokens;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    @Override
    public void run() {
        int round=0;
        while(board.getSize()>0 && game.hasFinished() == null && game.hasFinishedSize()==false)
        {
            try {
                pickToken();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public synchronized void pickToken() throws InterruptedException{

        Random random = new Random();
        int aux = board.getSize();
        Token choosenToken = null;

        while (choosenToken== null) {

            int index = random.nextInt(aux);
            choosenToken = board.getToken(index);


        }

        this.addToken(choosenToken);
        //System.out.println(getName()+" a ales : "+ choosenToken.getValue());

        board.removeToken(choosenToken);
        board.setSize(aux-1);


    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public synchronized void addToken(Token token)
    {
        tokens.add(token);
    }

    public String showTokens()
    {
        String s="";
        for(Token token: tokens)
            s = s + token.toString()+" , ";

        return s;
    }
}
