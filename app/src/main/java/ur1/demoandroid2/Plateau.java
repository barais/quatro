

package ur1.demoandroid2;

import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.ArrayList;
import java.util.List;

import ur1.demoandroid2.model.Caracteristique;
import ur1.demoandroid2.model.Case;
import ur1.demoandroid2.model.CercleCarre;
import ur1.demoandroid2.model.CroixVide;
import ur1.demoandroid2.model.Entoure;
import ur1.demoandroid2.model.NoirBlanc;
import ur1.demoandroid2.model.TypePiece;

public class Plateau extends AppCompatActivity {

    ImageButton[] pieces =new ImageButton[8];
    int pieceselected = -1;
    ImageButton[][] bts =new ImageButton[4][4];;
    Case[][] plateau = new Case[4][4];

    List<Integer> imagePiecesBlanche = new ArrayList<Integer>() ;
    List<Integer> imagePiecesNoir = new ArrayList<Integer>() ;

    // qui joue vrai = joueur blanc
    // qui joue faux = joueur noir

    boolean quijoue = true;

    List<TypePiece> mainJoueurNoir = new ArrayList<TypePiece>();
    List<TypePiece> mainJoueurBlanc = new ArrayList<TypePiece>();

    private void init(){
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

        imagePiecesBlanche.add(R.drawable.piece_0b);
        imagePiecesBlanche.add(R.drawable.piece_1b);
        imagePiecesBlanche.add(R.drawable.piece_2b);
        imagePiecesBlanche.add(R.drawable.piece_3b);
        imagePiecesBlanche.add(R.drawable.piece_4b);
        imagePiecesBlanche.add(R.drawable.piece_5b);
        imagePiecesBlanche.add(R.drawable.piece_6b);
        imagePiecesBlanche.add(R.drawable.piece_7b);

        imagePiecesNoir.add(R.drawable.piece_0);
        imagePiecesNoir.add(R.drawable.piece_1);
        imagePiecesNoir.add(R.drawable.piece_2);
        imagePiecesNoir.add(R.drawable.piece_3);
        imagePiecesNoir.add(R.drawable.piece_4);
        imagePiecesNoir.add(R.drawable.piece_5);
        imagePiecesNoir.add(R.drawable.piece_6);
        imagePiecesNoir.add(R.drawable.piece_7);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plateau);
        init();

        TableLayout table = (TableLayout) findViewById(R.id.mytablelayout);

        for (int i = 0; i < 4; i++) {
            TableRow row = (TableRow) table.getChildAt(i);
            createRow(bts, row, i);
        }

        TableRow row1 = (TableRow) findViewById(R.id.rowpiece1);
        TableRow row2 = (TableRow) findViewById(R.id.rowpiece2);

        for (int i = 0; i<8;i++){
            pieces[i] = createPiece(imagePiecesBlanche.get(i));
            if (i<4){
                row1.addView(pieces[i]);
            }else{
                row2.addView(pieces[i]);
            }

        }

        for (int i = 0; i<8;i++){
            final int k = i;
            pieces[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if ((mainJoueurBlanc.contains(TypePiece.values()[k]) && quijoue) || (mainJoueurNoir.contains(TypePiece.values()[k]) && !quijoue)) {
                        pieces[k].setBackgroundColor(getResources().getColor(R.color.colorAccent));
                        pieceselected = k;
                    }
                }
            });
        }

        nextTurn();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                final int k = i;
                final int l = j;

                bts[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (pieceselected != -1) {
//                    pieceselected.getId();
                                if (quijoue) {
                                    bts[k][l].setImageResource(imagePiecesBlanche.get(pieceselected));
                                    plateau[k][l] = new Case(TypePiece.values()[k], NoirBlanc.blanc);
                                    mainJoueurBlanc.remove(TypePiece.values()[k]);
                                } else {
                                    plateau[k][l] = new Case(TypePiece.values()[k], NoirBlanc.noir);
                                    bts[k][l].setImageResource(imagePiecesNoir.get(pieceselected));
                                    mainJoueurNoir.remove(TypePiece.values()[k]);
                                }
                                bts[k][l].setOnClickListener(null);
                            nextTurn();
                            pieces[pieceselected].setBackgroundColor(getResources().getColor(R.color.colorBackground));
                            pieceselected = -1;
                        }

                    }
                });

            }
        }
        ;
    }

    private Point getWindowSize(){
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size;
    }

    public ImageButton createPiece(int id) {
        ImageButton btnGreen = new ImageButton(this);
        btnGreen.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        btnGreen.setLayoutParams(new TableRow.LayoutParams(getWindowSize().x/5,getWindowSize().y/5));
        btnGreen.setImageResource(id);
        return btnGreen;
    }

    public void createRow(ImageButton[][] bts, TableRow row, int column) {
        for (int i = 0; i < 4; i++) {
            ImageButton btnGreen = new ImageButton(this);
            btnGreen.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            btnGreen.setLayoutParams(new TableRow.LayoutParams(getWindowSize().x/4,getWindowSize().y/4));
            btnGreen.setImageResource(R.drawable.empty);
            btnGreen.setTag(i);
            btnGreen.setId(i);
            row.addView(btnGreen);
            bts[column][i] = btnGreen;
        }
    }

    public void afterVictory(){
        for (int i = 0;i<8;i++){
            pieces[i].setOnClickListener(null);
        }
        Intent transition = new Intent(Plateau.this, Demo3.class);
        startActivity(transition);
    }



    public void nextTurn(){
        if (!vainqueur()) {
            for (int i = 0;i<8;i++){
                pieces[i].setImageResource(R.drawable.empty);
                if (quijoue) {
                    if (mainJoueurBlanc.contains(TypePiece.values()[i])) {
                        pieces[i].setImageResource(imagePiecesBlanche.get(i));
                    }
                }else{
                    if (mainJoueurNoir.contains(TypePiece.values()[i])) {
                        pieces[i].setImageResource(imagePiecesNoir.get(i));
                    }
                }
            }
            quijoue = !quijoue;
        }else{
            afterVictory();
        }
    }



    public boolean verifyLine(Case[] cases){
        boolean lignepleine = true;
        for (int j = 0; j < 4; j++) {
            if (cases[j] == null) {
                lignepleine = false;
            }
        }
        if (lignepleine == true) {
            boolean noirBlanc = true;
            boolean cercleCarre = true;
            boolean entoureNon = true;
            boolean croixounon = true;
            for (int j = 1; j < 4; j++) {
                Caracteristique colone1 = TypePiece.piece1.quelCaractristique(cases[0]);
                Caracteristique autrecolone = TypePiece.piece1.quelCaractristique(cases[j]);
                if (colone1.noirblanc != autrecolone.noirblanc)
                    noirBlanc = false;
                if (colone1.croixvide != autrecolone.croixvide)
                    croixounon = false;
                if (colone1.cerclecarre != autrecolone.cerclecarre)
                    cercleCarre = false;
                if (colone1.entoure != autrecolone.entoure)
                    entoureNon = false;

            }
            if (noirBlanc == true || cercleCarre == true || entoureNon == true || croixounon == true) {
                return true;
            }
        }
        return false;
    }


    public boolean vainqueur() {
        //Vérification Ligne
        for (int i = 0; i < 4; i++) {
            if (verifyLine(plateau[i])){
                return true;
            }
        }
        //Vérification Colonne
        for (int i = 0; i < 4; i++) {
            Case[] cases = new Case[4];
            for (int j = 0; j < 4; j++) {
                cases[j] = plateau[j][i];
            }
            if (verifyLine(cases)){
                return true;
            }
        }
        //Vérification Diago1
        Case[] cases = new Case[4];
        for (int i = 0; i < 4; i++) {
            cases[i] = plateau[i][i];
            }
        if (verifyLine(cases)){
            return true;
        }
        //Vérification Diago2
        cases = new Case[4];
        for (int i = 0; i < 4; i++) {
            int j = 3-i;
            cases[i] = plateau[i][j];
        }
        if (verifyLine(cases)){
            return true;
        }
        //Pas de gagnat
        return false;

    }
}
