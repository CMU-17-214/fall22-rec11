package edu.cmu.cs.cs214.rec10.plugin;

import edu.cmu.cs.cs214.rec10.framework.core.GameFramework;
import edu.cmu.cs.cs214.rec10.framework.core.GamePlugin;
import edu.cmu.cs.cs214.rec10.games.TicTacToe;
import edu.cmu.cs.cs214.rec10.games.TicTacToe.Player;

public class TicTacToePlugin implements GamePlugin<Integer> {
    private static final int WIDTH = 3;
    private static final int HEIGHT = 3;

    private static final String GAME_NAME = "TicTacToe";
    private static final String BLANK_SQUARE_STRING = "";
    private static final String OCCUPIED_SQUARE_STRING = "%s";
    private static final String PLAYER_TURN_MSG = "It's player %s turn!";
    private static final String PLAYER_WON_MSG = "Player %s won!";
    private static final String PLAYERS_TIED_MSG = "Players tied.";

    private GameFramework framework;
    private TicTacToe game;

    @Override
    public String getGameName() {
        return GAME_NAME;
    }

    @Override
    public int getGridWidth() {
        return WIDTH;
    }

    @Override
    public int getGridHeight() {
        return HEIGHT;
    }

    @Override
    public void onRegister(GameFramework f) {
        framework = f;
    }

    @Override
    public void onNewGame() {
        game = new TicTacToe();
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                framework.setSquare(i, j, BLANK_SQUARE_STRING);
            }
        }
        framework.setFooterText(String.format(PLAYER_TURN_MSG, game.currentPlayer() == Player.X ? "X" : "O"));
    }

    @Override
    public void onNewMove() {
    }

    // private int boardPositionFor(int x, int y) {
    //     return (y * WIDTH) + x;
    // }

    @Override
    public boolean isMoveValid(int x, int y) {
        return game.isValidPlay(x, y);
    }

    @Override
    public boolean isMoveOver() {
        return true;
    }

    @Override
    public void onMovePlayed(int x, int y) {
        game.play(x, y);
        framework.setSquare(x, y, String.format(OCCUPIED_SQUARE_STRING, game.getSquare(x, y) == Player.X ? "X" : "O"));
        framework.setFooterText(String.format(PLAYER_TURN_MSG, game.currentPlayer() == Player.X ? "X" : "O"));
        return;
    }

    @Override
    public boolean isGameOver() {
        return game.isOver();
    }

    @Override
    public String getGameOverMessage() {
        Player winner = game.winner();
        if (winner == null) {
            return String.format(PLAYERS_TIED_MSG);
        } else {
            return String.format(PLAYER_WON_MSG, winner == Player.X ? "X" : "O");
        }
    }

    @Override
    public void onGameClosed() {
    }

    @Override
    public Integer currentPlayer() {
        // return Integer.valueOf(game.currentPlayer() + 1);
        return game.currentPlayer() == Player.X ? 1 : 2;
    }
}