package ur1.demoandroid2.model;

/**
 * Created by barais on 07/04/17.
 */

public enum TypePiece {
    piece1,
    piece2,
    piece3,
    piece4,
    piece5,
    piece6,
    piece7,
    piece8;

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
    }


    }
