package Pieces;

public class Bishop extends Piece{

    public Bishop(String s, String n) {
        super(s, n);
    }

    public String toString(){
        if(side == "W")
            return "B";
        if(side == "B")
            return "b";
        else
            return "color error";
    }

    public boolean isValidMove(String newSquare){
        return true;
    }

}
