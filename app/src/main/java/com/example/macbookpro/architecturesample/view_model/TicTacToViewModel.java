package com.example.macbookpro.architecturesample.view_model;

import com.example.macbookpro.architecturesample.model.Board;
import com.example.macbookpro.architecturesample.model.Player;

public class TicTacToViewModel {
    public Board board;

    public TicTacToViewModel() {
        board = new Board();
    }

    public String markCell(int row, int col){
        Player playerMark = board.mark(row, col);
        return playerMark.toString();
    }

    public String checkWinOrDraw(){
        Player winner = board.getWinner();
        if (winner != null) {
            return winner.toString();
        } else {
            return board.checkDraw() ? "DRAW" : null;
        }
    }

    public void clear(){
        board.restart();
    }
}
