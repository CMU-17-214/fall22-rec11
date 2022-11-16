package edu.cmu.cs.cs214.rec09.plugin;

import edu.cmu.cs.cs214.rec09.framework.core.GameFramework;
import edu.cmu.cs.cs214.rec09.framework.core.GamePlugin;
import edu.cmu.cs.cs214.rec09.games.TicTacToe.Player;

public class TicTacToe implements GamePlugin<TicTacToe.Player> {
    private static final String GAME_NAME = "Tic-Tac-Toe";
    private static final int WIDTH = 3;
    private static final int HEIGHT = 3;
    private static final String PLAYER_WON_MSG = "You won!";
    private static final String COMPUTER_WON_MSG = "The computer won!";
    private static final String GAME_TIED_MSG = "The game ended in a tie.";
    private static final String GAME_START_FOOTER = "You are playing Tic-Tac-Toe with a computer!";


    private GameFramework framework;
    private TicTacToe game;

    @Override
    public String getGameName() {
        return GAME_NAME;
    }

    @Override
    public int getGridWidth() {
        return TicTacToe.SIZE;
    }

    @Override
    public int getGridHeight() {
        return TicTacToe.SIZE;
    }

    @Override
    public void onRegister(GameFramework framework) {
        this.framework = framework;
        
    }

    @Override
    public void onNewGame() {
        this.framework.setFooterText(GAME_START_FOOTER);
        
    }

    @Override
    public void onNewMove() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean isMoveValid(int x, int y) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isMoveOver() {
        return true;
    }
ghj
    @Override
    public void onMovePlayed(int x, int y) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean isGameOver() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String getGameOverMessage() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onGameClosed() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Object currentPlayer() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
