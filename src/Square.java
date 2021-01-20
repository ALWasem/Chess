import Pieces.Piece;
import java.util.*;

public class Square {

    public Piece chessPiece;

    public String name;

    public Square(String n){
        name = n;
        chessPiece = null;
    }

    public Piece getChessPiece(){
        return this.chessPiece;
    }

    public String pieceName(){
        if(chessPiece == null)
            return "";
        return chessPiece.name;
    }

    public void emptySquare(){
        chessPiece = null;
    }

    public void addPiece(Piece p){
        chessPiece = p;
        chessPiece.squareName = name;
    }

    public void killPiece(Piece p, Piece[] pieces){
        System.out.print("\n");
        System.out.print(p.name + " takes " + chessPiece.name);
        System.out.print("\n");
        int idx = Arrays.asList(pieces).indexOf(chessPiece);
        pieces[idx] = null;
        chessPiece = null;
    }

    public String toString(){
        if(chessPiece == null)
            return "[ ]";
        else
            return "[" + chessPiece.toString() + "]";
    }

}
