package Pieces;

public abstract class Piece {

    public String side;

    public String name;

    public String squareName;

    public Piece(String s, String n){

        side = s;
        name = n;

    }


    public abstract boolean isValidMove(String newSquareName);

}
