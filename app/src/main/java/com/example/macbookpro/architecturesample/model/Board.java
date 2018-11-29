package com.example.macbookpro.architecturesample.model;

import static com.example.macbookpro.architecturesample.model.Player.O;
import static com.example.macbookpro.architecturesample.model.Player.X;

public class Board {
    public Cell[][] cells = new Cell[3][3];
    public Player currentPlayer;
    public Player winner;
    public boolean draw;

    public Board() {
        restart();
    }

    public void restart(){
        clearCells();
        winner = null;
        draw = false;
        currentPlayer = X;
    }

    public Player mark(int row, int col) {
        Player playerMark = currentPlayer;
        if (isEmpty(row, col)){
            cells[row][col].setValue(currentPlayer);

            if (isCurrentPlayerWin()){
                winner = currentPlayer;
            } else {
                if (isDraw()){
                    draw = true;
                }
                changePlayer();
            }
        }

        return playerMark;
    }

    public void changePlayer(){
        currentPlayer = currentPlayer == X ? O : X;
    }

    public Player getWinner(){
        return winner;
    }

    public boolean checkDraw(){
        return draw;
    }

    public void clearCells(){
        for (int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                cells[i][j] = new Cell();
            }
        }
    }

    public boolean isEmpty(int row, int col){
        return cells[row][col].getValue() != null ? false : true;
    }

    public boolean isCurrentPlayerWin(){
        if ((cells[0][0].getValue() == currentPlayer && cells[0][1].getValue() == currentPlayer && cells[0][2].getValue() == currentPlayer)
                || (cells[1][0].getValue() == currentPlayer && cells[1][1].getValue() == currentPlayer && cells[1][2].getValue() == currentPlayer)
                || (cells[2][0].getValue() == currentPlayer && cells[2][1].getValue() == currentPlayer && cells[2][2].getValue() == currentPlayer)
                || (cells[0][0].getValue() == currentPlayer && cells[1][0].getValue() == currentPlayer && cells[2][0].getValue() == currentPlayer)
                || (cells[0][1].getValue() == currentPlayer && cells[1][1].getValue() == currentPlayer && cells[2][1].getValue() == currentPlayer)
                || (cells[0][2].getValue() == currentPlayer && cells[1][2].getValue() == currentPlayer && cells[2][2].getValue() == currentPlayer)
                || (cells[0][0].getValue() == currentPlayer && cells[1][1].getValue() == currentPlayer && cells[2][2].getValue() == currentPlayer)
                || (cells[2][0].getValue() == currentPlayer && cells[1][1].getValue() == currentPlayer && cells[0][2].getValue() == currentPlayer)){
            return true;
        } else {
            return false;
        }
    }

    public boolean isDraw(){
        for (int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if (cells[i][j].getValue() == null) return false;
            }
        }
        return true;
    }
}
