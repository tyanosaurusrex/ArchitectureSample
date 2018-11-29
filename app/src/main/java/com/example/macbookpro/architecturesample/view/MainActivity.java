package com.example.macbookpro.architecturesample.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import com.example.macbookpro.architecturesample.R;
import com.example.macbookpro.architecturesample.view_model.TicTacToViewModel;

public class MainActivity extends AppCompatActivity {
    public Button button;
    public TicTacToViewModel viewModel = new TicTacToViewModel();
    public String player1nameextra, player2nameextra;
    public TextView player1text, player2text;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player1nameextra = getIntent().getExtras().getSerializable("player1name").toString();
        player2nameextra = getIntent().getExtras().getSerializable("player2name").toString();

        player1text = findViewById(R.id.player1name);
        player1text.setText(player1nameextra);
        player2text = findViewById(R.id.player2name);
        player2text.setText(player2nameextra);
    }

    public void markCellActivity(View view){
        button = (Button) view;
        String buttonTag = (String) button.getTag();
        String row, col;
        row = buttonTag.substring(0,1);
        col = buttonTag.substring(1,2);

        String playerMark = viewModel.markCell(Integer.parseInt(row), Integer.parseInt(col));
        button.setText(playerMark);
        TextView winnerText = findViewById(R.id.winner);
        String winOrDraw = viewModel.checkWinOrDraw();
        if (winOrDraw != null) {
            if (!winOrDraw.equals("DRAW")) {
                String winnerName = winOrDraw.equals("X") ? player1nameextra : player2nameextra;
                winOrDraw = winnerName + " win";
            }
            winnerText.setText(winOrDraw);
            setEnabledBoard(false);
        }
    }

    public void resetActivity(View view){
        viewModel.clear();
        clearBoard();
        TextView winnerText = findViewById(R.id.winner);
        winnerText.setText("");
        setEnabledBoard(true);
    }

    public void clearBoard() {
        GridLayout grid = findViewById(R.id.board);
        for( int i = 0; i < grid.getChildCount(); i++ ) {
            ((Button) grid.getChildAt(i)).setText("");
        }
    }

    public void setEnabledBoard(boolean enable){
        GridLayout grid = findViewById(R.id.board);
        for( int i = 0; i < grid.getChildCount(); i++ ) {
            ((Button) grid.getChildAt(i)).setEnabled(enable);
        }
    }
}
