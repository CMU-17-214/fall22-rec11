package edu.cmu.cs.cs214.rec10.plugin;

import edu.cmu.cs.cs214.rec10.framework.core.GameFramework;
import edu.cmu.cs.cs214.rec10.framework.core.GamePlugin;
import edu.cmu.cs.cs214.rec10.games.TicTacToe;

/**
 * An example Rock Paper Scissors game plug-in.
 */
public class TttPlugin implements GamePlugin<String> {

    private static final String GAME_NAME = "Tic Tac Toe";

    private static final int WIDTH = 3;
    private static final int HEIGHT = 3;

    private static final String PLAYER_WON_MSG = "You won!";
    private static final String COMPUTER_WON_MSG = "The computer won!";
    private static final String GAME_TIED_MSG = "The game ended in a tie.";

    private static final String GAME_START_FOOTER = "You are playing Tic Tac Toe with a computer!";

    private TicTacToe game;

    private GameFramework framework;
    // private RockPaperScissors.Result gameResult = null;

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
        framework.setFooterText(GAME_START_FOOTER);
        game = new TicTacToe();
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                framework.setSquare(i, j, "");
            }
        }
    }

    @Override
    public void onNewMove() { } // Nothing to do here.

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
        framework.setSquare(x, y, game.currentPlayer().toString());
    }

    @Override
    public boolean isGameOver() {
        return game.isOver();
    }

    @Override
    public String getGameOverMessage() {
        switch(game.winner()) {
            case X: return PLAYER_WON_MSG;
            case O: return COMPUTER_WON_MSG;
            default: return GAME_TIED_MSG;
            // default: throw new IllegalStateException("Called getGameOverMessage with incomplete game");
        }
    }

    @Override
    public void onGameClosed() { } // Nothing to do here.

    @Override
    public String currentPlayer() {
        return game.currentPlayer().toString();
    }
}
