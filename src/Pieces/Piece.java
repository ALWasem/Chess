package Pieces;

public abstract class Piece {

    public String side;

    public String name;

    public int moveCount;

    public String squareName;

    public Piece(String s, String n, int m){

        side = s;
        name = n;
        moveCount = m;

    }

    public abstract boolean isValidMove(String newSquareName);

}
