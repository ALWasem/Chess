import Pieces.Piece;

public class Square {

    public Piece chessPiece;

    public Square(){
        chessPiece = null;
    }

    public Square(Piece p){
        chessPiece = p;
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
    }

    public String toString(){
        if(chessPiece == null)
            return "[ ]";
        else
            return "[" + chessPiece.toString() + "]";
    }

}
