import Pieces.Piece;


public class Square {

    public Piece chessPiece;

    public String name;

    public Square(String n){
        name = n;
        chessPiece = null;
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

    public String toString(){
        if(chessPiece == null)
            return "[ ]";
        else
            return "[" + chessPiece.toString() + "]";
    }

}
