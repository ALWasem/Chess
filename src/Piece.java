import java.util.*;

public abstract class Piece {

    public String side;

    public String name;

    public int moveCount;

    public Square square;

    public boolean isCaptured;

    public Piece(String s, String n, int m){

        side = s;
        name = n;
        moveCount = m;
        isCaptured = false;

    }

    public Piece(String s, String n){

        side = s;
        name = n;
        moveCount = -1;
        isCaptured = false;

    }



    public abstract boolean isValidMove(Square newSquare, HashMap<String, Square> squareMap);

}