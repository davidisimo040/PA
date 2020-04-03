package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.*;

import static java.lang.Math.abs;
import static java.lang.Thread.sleep;

public class Game {

    private Board board;
    private List<Player> players;
    private int arithmetic_progression_SIZE;


    public Game() {
        players = new ArrayList<>();
    }


    public synchronized Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public synchronized List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player) {
        players.add(player);
        player.setBoard(this.board);
        player.setGame(this);
    }

    public synchronized boolean hasFinishedSize() {
        if (board.getSize() == 0) return true;
        return false;
    }

    public synchronized Player hasFinished() {
        int range;

        for (Player player : players) {
            if (player.getTokens().size() >= arithmetic_progression_SIZE) {
                range = 0;
                // Collections.sort(player.getTokens(), Comparator.comparing(Token::getValue));

                player.getTokens().sort(Comparator.comparing(Token::getValue));


                int ratio = abs(player.getTokens().get(0).getValue() - player.getTokens().get(1).getValue());
                for (int i = 1; i < player.getTokens().size(); i = i + 1) {
                    if (abs(player.getTokens().get(i).getValue() - player.getTokens().get(i - 1).getValue()) == ratio) {
                        range++;
                        if (range >= arithmetic_progression_SIZE - 1 ) return player;
                    } else {
                        range = 0;
                        ratio = abs(player.getTokens().get(i).getValue() - player.getTokens().get(i - 1).getValue());

                    }
                }

            }
        }
        return null;
    }

    public synchronized int getArithmetic_progression_SIZE() {
        return arithmetic_progression_SIZE;
    }

    public void setArithmetic_progression_SIZE(int arithmetic_progression_SIZE) {
        this.arithmetic_progression_SIZE = arithmetic_progression_SIZE;
    }

    void  startThread(){

        System.out.println("A INCEPUT JOCUL!");
        System.out.println("JUCATORII ACESTEI PARTIDE SUNT : ");
        for(Player player : players) {System.out.print(player.getName()+" ");}
        System.out.println("\n\n");
        //System.out.println("");
        for (int i = 0; i < players.size(); i = i + 1) {
            Runnable runnable = players.get(i);
            new Thread(runnable).start();

        }

        while (true) {

            if (hasFinished() != null) {
                Player namee = hasFinished();
                System.out.println("S-a terminat jocul, castigatorul este : " + namee.getName() + " , avnad piesele :   "+ namee.showTokens());
                break;
            }
            else if (hasFinishedSize() == true) {
                System.out.println("S-a terminat jocul cu o REMIZA! ");
                break;
            }

             else {
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
