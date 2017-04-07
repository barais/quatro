package ur1.demoandroid2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;

public class Plateau extends AppCompatActivity {


    ImageButton piece1;
    ImageButton piece2;
    ImageButton piece3;
    ImageButton piece4;
    ImageButton piece5;
    ImageButton piece6;
    ImageButton piece7;
    ImageButton piece8;

    ImageButton pieceselected = null;

    ImageButton[][] bts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plateau);

         bts = new ImageButton[4][4];

        TableLayout table = (TableLayout) findViewById(R.id.mytablelayout);

        for(int i = 0 ; i <  4 ; i++) {
            TableRow row = (TableRow) table.getChildAt(i);
            createRow(bts,row,i);
        }


        TableRow row1 = (TableRow) findViewById(R.id.rowpiece1);
        piece1 = createPiece(R.drawable.piece_0b);
        piece2 = createPiece(R.drawable.piece_1b);
        piece3 = createPiece(R.drawable.piece_2b);
        piece4 = createPiece(R.drawable.piece_3b);
        row1.addView(piece1);
        row1.addView(piece2);
        row1.addView(piece3);
        row1.addView(piece4);


        TableRow row2 = (TableRow) findViewById(R.id.rowpiece2);
        piece5= createPiece(R.drawable.piece_4b);
        piece6= createPiece(R.drawable.piece_5b);
        piece7= createPiece(R.drawable.piece_6b);
        piece8= createPiece(R.drawable.piece_7b);
        row2.addView(piece5);
        row2.addView(piece6);
        row2.addView(piece7);
        row2.addView(piece8);


        piece1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pieceselected = piece1;

            }
        });


        bts[0][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pieceselected != null){
//                    pieceselected.getId();
                    if (pieceselected == piece1) {
                        bts[0][0].setImageResource(R.drawable.piece_0b);
                        piece1.setImageResource(R.drawable.piece_0);
                        piece2.setImageResource(R.drawable.piece_1);
                        piece3.setImageResource(R.drawable.piece_2);
                        piece4.setImageResource(R.drawable.piece_3);
                        piece5.setImageResource(R.drawable.piece_4);
                        piece6.setImageResource(R.drawable.piece_5);
                        piece7.setImageResource(R.drawable.piece_6);
                        piece8.setImageResource(R.drawable.piece_7);
                        pieceselected.setImageResource(R.drawable.empty);

                    }
                    pieceselected =null;
                }

            }
        });

    }

    public ImageButton createPiece(int id){
        ImageButton btnGreen = new ImageButton(this);
        btnGreen.setImageResource(id);
        return  btnGreen;
    }

    public void createRow(ImageButton[][] bts, TableRow row, int column){
        for(int i = 0 ; i <  4 ; i++)
        {

            ImageButton btnGreen = new ImageButton(this);
            btnGreen.setImageResource(R.drawable.empty);
            btnGreen.setTag(i);
            btnGreen.setId(i);
            row.addView(btnGreen);
            bts[column][i] = btnGreen;
//            gameBoard..addView(btnGreen);


        }
    }

}
