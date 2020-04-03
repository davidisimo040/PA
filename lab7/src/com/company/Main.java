package com.company;

public class Main {

    public static void main(String[] args) {

    Player player1 = new Player("David");
    Player player2 = new Player("Abdul");

    Board board = new Board(10);

    Game game = new Game();
    game.setBoard(board);
    game.addPlayer(player1);
    game.addPlayer(player2);
    game.setArithmetic_progression_SIZE(5);
    game.startThread();


    }
}
