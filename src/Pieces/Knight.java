package Pieces;

public class Knight extends Piece{

    public Knight(String s, String n) {
        super(s, n);
    }

    public String toString(){
        if(side == "W")
            return "N";
        if(side == "B")
            return "n";
        else
            return "color error";
    }
}
