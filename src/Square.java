import java.util.*;

public class Square {

    public Piece chessPiece;

    public String name;

    public Square(String n){
        name = n;
        chessPiece = null;
    }

    public void emptySquare(){
        chessPiece = null;
    }

    public void addPiece(Piece p){
        chessPiece = p;
        chessPiece.square = this;
        chessPiece.moveCount += 1;
    }

    public void killPiece(Piece killingPiece){
        System.out.print("\n");
        System.out.print(killingPiece.name + " captures " + chessPiece.name);
        System.out.print("\n");
        chessPiece.isCaptured = true;
        chessPiece = null;
    }

    public String toString(){
        if(chessPiece == null)
            return "[ ]";
        else
            return "[" + chessPiece.toString() + "]";
    }

}