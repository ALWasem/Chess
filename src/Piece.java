import java.util.HashMap;

public abstract class Piece {

    public String side;

    public String name;

    public int moveCount;

    public Square square;

    public Piece(String s, String n, int m){

        side = s;
        name = n;
        moveCount = m;

    }

    public abstract boolean isValidMove(Square newSquareName, HashMap<String, Square> squareMap);



}
