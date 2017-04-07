

package ur1.demoandroid2;

import android.graphics.Point;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageView;
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
    Case[][] plateau = new Case[4][4];


    enum NoirBlanc {
        noir, blanc
    }

    enum CercleCarre {
        cercle, carre
    }

    enum CroixVide {
        croix, vide
    }

    enum Entoure {
        entoure, nonentoure
    }

    class Caracteristique {
        NoirBlanc noirblanc;
        CercleCarre cerclecarre;
        CroixVide croixvide;
        Entoure entoure;
    }


    class Case {
        Case(TypePiece type, NoirBlanc noirblanc) {
            this.type = type;
            this.noirblanc = noirblanc;

        }

        TypePiece type;
        NoirBlanc noirblanc;

    }


    public Caracteristique quelCaractristique(Case case1) {
        Caracteristique c = new Caracteristique();
        c.noirblanc = case1.noirblanc;
        if (case1.type == TypePiece.piece1) {
            c.cerclecarre = CercleCarre.cercle;
            c.entoure = Entoure.nonentoure;
            c.croixvide = CroixVide.vide;
        } else if (case1.type == TypePiece.piece2) {
            c.cerclecarre = CercleCarre.cercle;
            c.entoure = Entoure.entoure;
            c.croixvide = CroixVide.vide;
        } else if (case1.type == TypePiece.piece3) {
            c.cerclecarre = CercleCarre.carre;
            c.entoure = Entoure.nonentoure;
            c.croixvide = CroixVide.vide;
        } else if (case1.type == TypePiece.piece4) {
            c.cerclecarre = CercleCarre.carre;
            c.entoure = Entoure.entoure;
            c.croixvide = CroixVide.vide;
        } else if (case1.type == TypePiece.piece5) {
            c.cerclecarre = CercleCarre.cercle;
            c.entoure = Entoure.nonentoure;
            c.croixvide = CroixVide.croix;
        } else if (case1.type == TypePiece.piece6) {
            c.cerclecarre = CercleCarre.cercle;
            c.entoure = Entoure.entoure;
            c.croixvide = CroixVide.croix;
        } else if (case1.type == TypePiece.piece7) {
            c.cerclecarre = CercleCarre.carre;
            c.entoure = Entoure.nonentoure;
            c.croixvide = CroixVide.croix;
        } else if (case1.type == TypePiece.piece8) {
            c.cerclecarre = CercleCarre.carre;
            c.entoure = Entoure.entoure;
            c.croixvide = CroixVide.croix;
        }

        return c;
//        if (bt1.getIma)


    }


    // qui joue vrai = joueur blanc
    // qui joue faux = joueur noir

    boolean quijoue = true;

    List<TypePiece> mainJoueurNoir = new ArrayList<TypePiece>();
    List<TypePiece> mainJoueurBlanc = new ArrayList<TypePiece>();

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

        for (int i = 0; i < 4; i++) {
            TableRow row = (TableRow) table.getChildAt(i);
            createRow(bts, row, i);
        }


        TableRow row1 = (TableRow) findViewById(R.id.rowpiece1);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        row1.setLayoutParams(new TableLayout.LayoutParams(width/4,width/4));
        piece1 = createPiece(R.drawable.piece_0b);
        piece2 = createPiece(R.drawable.piece_1b);
        piece3 = createPiece(R.drawable.piece_2b);
        piece4 = createPiece(R.drawable.piece_3b);
        row1.addView(piece1);
        row1.addView(piece2);
        row1.addView(piece3);
        row1.addView(piece4);


        TableRow row2 = (TableRow) findViewById(R.id.rowpiece2);
        piece5 = createPiece(R.drawable.piece_4b);
        piece6 = createPiece(R.drawable.piece_5b);
        piece7 = createPiece(R.drawable.piece_6b);
        piece8 = createPiece(R.drawable.piece_7b);
        row2.addView(piece5);
        row2.addView(piece6);
        row2.addView(piece7);
        row2.addView(piece8);


        tourJoueurBlanc();

        piece1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                piece1.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                pieceselected = piece1;
            }
        });
        piece2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                piece2.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                pieceselected = piece2;

            }
        });
        piece3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                piece3.setBackgroundColor(getResources().getColor(R.color.colorAccent));

                pieceselected = piece3;

            }
        });
        piece4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                piece4.setBackgroundColor(getResources().getColor(R.color.colorAccent));

                pieceselected = piece4;

            }
        });

        piece5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                piece5.setBackgroundColor(getResources().getColor(R.color.colorAccent));

                pieceselected = piece5;

            }
        });
        piece6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                piece6.setBackgroundColor(getResources().getColor(R.color.colorAccent));

                pieceselected = piece6;

            }
        });
        piece7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                piece7.setBackgroundColor(getResources().getColor(R.color.colorAccent));

                pieceselected = piece7;

            }
        });
        piece8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                piece8.setBackgroundColor(getResources().getColor(R.color.colorAccent));

                pieceselected = piece8;

            }
        });


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                final int k = i;
                final int l = j;

                bts[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (pieceselected != null) {
//                    pieceselected.getId();
                            if (pieceselected == piece1) {
                                if (quijoue) {
                                    bts[k][l].setImageResource(R.drawable.piece_0b);
                                    plateau[k][l] = new Case(TypePiece.piece1, NoirBlanc.blanc);
                                    mainJoueurBlanc.remove(TypePiece.piece1);
                                } else {
                                    plateau[k][l] = new Case(TypePiece.piece1, NoirBlanc.noir);
                                    bts[k][l].setImageResource(R.drawable.piece_0);
                                    mainJoueurNoir.remove(TypePiece.piece1);
                                }


                            } else if (pieceselected == piece2) {
                                if (quijoue) {
                                    plateau[k][l] = new Case(TypePiece.piece2, NoirBlanc.blanc);

                                    bts[k][l].setImageResource(R.drawable.piece_1b);
                                    mainJoueurBlanc.remove(TypePiece.piece2);
                                } else {
                                    plateau[k][l] = new Case(TypePiece.piece2, NoirBlanc.noir);

                                    bts[k][l].setImageResource(R.drawable.piece_1);
                                    mainJoueurNoir.remove(TypePiece.piece2);
                                }

                            } else if (pieceselected == piece3) {
                                if (quijoue) {
                                    plateau[k][l] = new Case(TypePiece.piece3, NoirBlanc.blanc);
                                    bts[k][l].setImageResource(R.drawable.piece_2b);
                                    mainJoueurBlanc.remove(TypePiece.piece3);
                                } else {
                                    plateau[k][l] = new Case(TypePiece.piece3, NoirBlanc.noir);

                                    bts[k][l].setImageResource(R.drawable.piece_2);
                                    mainJoueurNoir.remove(TypePiece.piece3);
                                }

                            } else if (pieceselected == piece4) {
                                if (quijoue) {
                                    plateau[k][l] = new Case(TypePiece.piece4, NoirBlanc.blanc);
                                    bts[k][l].setImageResource(R.drawable.piece_3b);
                                    mainJoueurBlanc.remove(TypePiece.piece4);
                                } else {
                                    plateau[k][l] = new Case(TypePiece.piece4, NoirBlanc.noir);

                                    bts[k][l].setImageResource(R.drawable.piece_3);
                                    mainJoueurNoir.remove(TypePiece.piece4);
                                }

                            } else if (pieceselected == piece5) {
                                if (quijoue) {
                                    plateau[k][l] = new Case(TypePiece.piece5, NoirBlanc.blanc);

                                    bts[k][l].setImageResource(R.drawable.piece_4b);
                                    mainJoueurBlanc.remove(TypePiece.piece5);
                                } else {
                                    plateau[k][l] = new Case(TypePiece.piece5, NoirBlanc.noir);

                                    bts[k][l].setImageResource(R.drawable.piece_4);
                                    mainJoueurNoir.remove(TypePiece.piece5);
                                }

                            } else if (pieceselected == piece6) {
                                if (quijoue) {
                                    plateau[k][l] = new Case(TypePiece.piece6, NoirBlanc.blanc);

                                    bts[k][l].setImageResource(R.drawable.piece_5b);
                                    mainJoueurBlanc.remove(TypePiece.piece6);
                                } else {
                                    plateau[k][l] = new Case(TypePiece.piece6, NoirBlanc.noir);

                                    bts[k][l].setImageResource(R.drawable.piece_5);
                                    mainJoueurNoir.remove(TypePiece.piece6);
                                }

                            } else if (pieceselected == piece7) {
                                if (quijoue) {
                                    plateau[k][l] = new Case(TypePiece.piece7, NoirBlanc.blanc);

                                    bts[k][l].setImageResource(R.drawable.piece_6b);
                                    mainJoueurBlanc.remove(TypePiece.piece7);
                                } else {
                                    plateau[k][l] = new Case(TypePiece.piece7, NoirBlanc.noir);

                                    bts[k][l].setImageResource(R.drawable.piece_6);
                                    mainJoueurNoir.remove(TypePiece.piece7);
                                }

                            } else if (pieceselected == piece8) {
                                if (quijoue) {
                                    plateau[k][l] = new Case(TypePiece.piece8, NoirBlanc.blanc);

                                    bts[k][l].setImageResource(R.drawable.piece_7b);
                                    mainJoueurBlanc.remove(TypePiece.piece8);
                                } else {
                                    plateau[k][l] = new Case(TypePiece.piece8, NoirBlanc.noir);

                                    bts[k][l].setImageResource(R.drawable.piece_7);
                                    mainJoueurNoir.remove(TypePiece.piece8);
                                }

                            }


                            bts[k][l].setOnClickListener(null);

                            if (quijoue) {
                                tourJoueurNoir();

                            } else {
                                tourJoueurBlanc();
                            }



                            pieceselected.setBackgroundColor(getResources().getColor(R.color.colorBackground));
                            pieceselected = null;

                        }

                    }
                });

            }
        }
        ;
    }


    public ImageButton createPiece(int id) {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;


        ImageButton btnGreen = new ImageButton(this);
        btnGreen.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        btnGreen.setLayoutParams(new TableRow.LayoutParams(width/5,width/5));

        btnGreen.setImageResource(id);
        return btnGreen;
    }

    public void createRow(ImageButton[][] bts, TableRow row, int column) {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        System.out.println(width);

        for (int i = 0; i < 4; i++) {

            ImageButton btnGreen = new ImageButton(this);
            btnGreen.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            btnGreen.setLayoutParams(new TableRow.LayoutParams(width/4,width/4));
            btnGreen.setImageResource(R.drawable.empty);
            btnGreen.setTag(i);
            btnGreen.setId(i);
            row.addView(btnGreen);
            bts[column][i] = btnGreen;
//            gameBoard..addView(btnGreen);


        }
    }

    public void tourJoueurBlanc() {
        if (!vainqueur()) {

            quijoue = true;
            piece1.setImageResource(R.drawable.empty);
            piece2.setImageResource(R.drawable.empty);
            piece3.setImageResource(R.drawable.empty);
            piece4.setImageResource(R.drawable.empty);
            piece5.setImageResource(R.drawable.empty);
            piece6.setImageResource(R.drawable.empty);
            piece7.setImageResource(R.drawable.empty);
            piece8.setImageResource(R.drawable.empty);
            for (TypePiece t : mainJoueurBlanc) {
                if (t.equals(TypePiece.piece1)) {
                    piece1.setImageResource(R.drawable.piece_0b);
                } else if (t.equals(TypePiece.piece2)) {
                    piece2.setImageResource(R.drawable.piece_1b);
                } else if (t.equals(TypePiece.piece3)) {
                    piece3.setImageResource(R.drawable.piece_2b);
                } else if (t.equals(TypePiece.piece4)) {
                    piece4.setImageResource(R.drawable.piece_3b);
                } else if (t.equals(TypePiece.piece5)) {
                    piece5.setImageResource(R.drawable.piece_4b);
                } else if (t.equals(TypePiece.piece6)) {
                    piece6.setImageResource(R.drawable.piece_5b);
                } else if (t.equals(TypePiece.piece7)) {
                    piece7.setImageResource(R.drawable.piece_6b);
                } else if (t.equals(TypePiece.piece8)) {
                    piece8.setImageResource(R.drawable.piece_7b);
                }
            }
        }else{
            piece1.setOnClickListener(null);
            piece2.setOnClickListener(null);
            piece3.setOnClickListener(null);
            piece4.setOnClickListener(null);
            piece5.setOnClickListener(null);
            piece6.setOnClickListener(null);
            piece7.setOnClickListener(null);
            piece8.setOnClickListener(null);
        }


    }

    public void tourJoueurNoir() {
        if (!vainqueur()) {
            quijoue = false;

            piece1.setImageResource(R.drawable.empty);
            piece2.setImageResource(R.drawable.empty);
            piece3.setImageResource(R.drawable.empty);
            piece4.setImageResource(R.drawable.empty);
            piece5.setImageResource(R.drawable.empty);
            piece6.setImageResource(R.drawable.empty);
            piece7.setImageResource(R.drawable.empty);
            piece8.setImageResource(R.drawable.empty);
            for (TypePiece t : mainJoueurNoir) {
                if (t.equals(TypePiece.piece1)) {
                    piece1.setImageResource(R.drawable.piece_0);
                } else if (t.equals(TypePiece.piece2)) {
                    piece2.setImageResource(R.drawable.piece_1);
                } else if (t.equals(TypePiece.piece3)) {
                    piece3.setImageResource(R.drawable.piece_2);
                } else if (t.equals(TypePiece.piece4)) {
                    piece4.setImageResource(R.drawable.piece_3);
                } else if (t.equals(TypePiece.piece5)) {
                    piece5.setImageResource(R.drawable.piece_4);
                } else if (t.equals(TypePiece.piece6)) {
                    piece6.setImageResource(R.drawable.piece_5);
                } else if (t.equals(TypePiece.piece7)) {
                    piece7.setImageResource(R.drawable.piece_6);
                } else if (t.equals(TypePiece.piece8)) {
                    piece8.setImageResource(R.drawable.piece_7);
                }
            }
        }
        else{
            piece1.setOnClickListener(null);
            piece2.setOnClickListener(null);
            piece3.setOnClickListener(null);
            piece4.setOnClickListener(null);
            piece5.setOnClickListener(null);
            piece6.setOnClickListener(null);
            piece7.setOnClickListener(null);
            piece8.setOnClickListener(null);
        }

    }


    public boolean vainqueur() {
        //Vérification Ligne
        for (int i = 0; i < 4; i++) {
            boolean lignepleine = true;
            for (int j = 0; j < 4; j++) {
                if (plateau[i][j] == null) {
                    lignepleine = false;
                }
            }
            if (lignepleine == true) {
                boolean noirBlanc = true;
                boolean cercleCarre = true;
                boolean entoureNon = true;
                boolean croixounon = true;
                for (int j = 1; j < 4; j++) {
                    Caracteristique colone1 = quelCaractristique(plateau[i][0]);
                    Caracteristique autrecolone = quelCaractristique(plateau[i][j]);
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

        }

        //Vérification Colonne

        for (int i = 0; i < 4; i++) {
            boolean colonnepleine = true;
            for (int j = 0; j < 4; j++) {
                if (plateau[j][i] == null) {
                    colonnepleine = false;
                }
            }
            if (colonnepleine == true) {
                boolean noirBlanc = true;
                boolean cercleCarre = true;
                boolean entoureNon = true;
                boolean croixounon = true;
                for (int j = 1; j < 4; j++) {
                    Caracteristique colone1 = quelCaractristique(plateau[0][i]);
                    Caracteristique autrecolone = quelCaractristique(plateau[j][i]);
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

        }


        boolean diagonalePleine = true;
        for (int j = 0; j < 4; j++) {
            if (plateau[j][j] == null) {
                diagonalePleine = false;
            }
        }
        if (diagonalePleine == true) {
            boolean noirBlanc = true;
            boolean cercleCarre = true;
            boolean entoureNon = true;
            boolean croixounon = true;
            for (int j = 1; j < 4; j++) {
                Caracteristique colone1 = quelCaractristique(plateau[0][0]);
                Caracteristique autrecolone = quelCaractristique(plateau[j][j]);
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


        boolean diagonaleInverse = true;
        for (int j = 0; j < 4; j++) {
            int i = 3-j;
            if (plateau[i][j] == null) {
                diagonaleInverse = false;
            }
        }
        if (diagonaleInverse == true) {
            boolean noirBlanc = true;
            boolean cercleCarre = true;
            boolean entoureNon = true;
            boolean croixounon = true;
            for (int j = 1; j < 4; j++) {
                int i = 3-j;

                Caracteristique colone1 = quelCaractristique(plateau[3][0]);
                Caracteristique autrecolone = quelCaractristique(plateau[i][j]);
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

        //Vérification Diago
        return false;

    }
}
