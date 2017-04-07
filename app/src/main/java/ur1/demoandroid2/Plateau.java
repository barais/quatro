

package ur1.demoandroid2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.ArrayList;
import java.util.List;

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


    // qui joue vrai = joueur blanc
    // qui joue faux = joueur noir

    boolean quijoue = true;

    List<TypePiece> mainJoueurNoir = new ArrayList<TypePiece>();
    List<TypePiece> mainJoueurBlanc= new ArrayList<TypePiece>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plateau);
        mainJoueurNoir.add(TypePiece.piece1);
        mainJoueurNoir.add(TypePiece.piece2);
        mainJoueurNoir.add(TypePiece.piece3);
        mainJoueurNoir.add(TypePiece.piece4);
        mainJoueurNoir.add(TypePiece.piece5);
        mainJoueurNoir.add(TypePiece.piece6);
        mainJoueurNoir.add(TypePiece.piece7);
        mainJoueurNoir.add(TypePiece.piece8);

        mainJoueurBlanc.add(TypePiece.piece1);
        mainJoueurBlanc.add(TypePiece.piece2);
        mainJoueurBlanc.add(TypePiece.piece3);
        mainJoueurBlanc.add(TypePiece.piece4);
        mainJoueurBlanc.add(TypePiece.piece5);
        mainJoueurBlanc.add(TypePiece.piece6);
        mainJoueurBlanc.add(TypePiece.piece7);
        mainJoueurBlanc.add(TypePiece.piece8);


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


        tourJoueurBlanc();

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
                        mainJoueurBlanc.remove(TypePiece.piece1);
                        if (quijoue){
                            tourJoueurNoir();

                        }
                        else{
                            tourJoueurBlanc();
                        }
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

    public void tourJoueurBlanc(){
        quijoue = true;
        piece1.setImageResource(R.drawable.empty);
        piece2.setImageResource(R.drawable.empty);
        piece3.setImageResource(R.drawable.empty);
        piece4.setImageResource(R.drawable.empty);
        piece5.setImageResource(R.drawable.empty);
        piece6.setImageResource(R.drawable.empty);
        piece7.setImageResource(R.drawable.empty);
        piece8.setImageResource(R.drawable.empty);
        for( TypePiece t : mainJoueurBlanc){
            if (t.equals(TypePiece.piece1)){
                piece1.setImageResource(R.drawable.piece_0b);
            }else if (t.equals(TypePiece.piece2)){
                piece2.setImageResource(R.drawable.piece_1b);
            }else if (t.equals(TypePiece.piece3)){
                piece3.setImageResource(R.drawable.piece_2b);
            }
            else if (t.equals(TypePiece.piece4)){
                piece4.setImageResource(R.drawable.piece_3b);
            }
            else if (t.equals(TypePiece.piece5)){
                piece5.setImageResource(R.drawable.piece_4b);
            }
            else if (t.equals(TypePiece.piece6)){
                piece6.setImageResource(R.drawable.piece_5b);
            }
            else if (t.equals(TypePiece.piece7)){
                piece7.setImageResource(R.drawable.piece_6b);
            }
            else if (t.equals(TypePiece.piece8)){
                piece8.setImageResource(R.drawable.piece_7b);
            }
        }


    }
    public void tourJoueurNoir(){
        quijoue = false;

        piece1.setImageResource(R.drawable.empty);
        piece2.setImageResource(R.drawable.empty);
        piece3.setImageResource(R.drawable.empty);
        piece4.setImageResource(R.drawable.empty);
        piece5.setImageResource(R.drawable.empty);
        piece6.setImageResource(R.drawable.empty);
        piece7.setImageResource(R.drawable.empty);
        piece8.setImageResource(R.drawable.empty);
        for( TypePiece t : mainJoueurNoir){
            if (t.equals(TypePiece.piece1)){
                piece1.setImageResource(R.drawable.piece_0);
            }else if (t.equals(TypePiece.piece2)){
                piece2.setImageResource(R.drawable.piece_1);
            }else if (t.equals(TypePiece.piece3)){
                piece3.setImageResource(R.drawable.piece_2);
            }
            else if (t.equals(TypePiece.piece4)){
                piece4.setImageResource(R.drawable.piece_3);
            }
            else if (t.equals(TypePiece.piece5)){
                piece5.setImageResource(R.drawable.piece_4);
            }
            else if (t.equals(TypePiece.piece6)){
                piece6.setImageResource(R.drawable.piece_5);
            }
            else if (t.equals(TypePiece.piece7)){
                piece7.setImageResource(R.drawable.piece_6);
            }
            else if (t.equals(TypePiece.piece8)){
                piece8.setImageResource(R.drawable.piece_7);
            }
        }

    }

}
