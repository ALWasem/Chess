import java.util.*;

public class Pawn extends Piece {

    public Pawn(String s, String n, int m) {
        super(s, n, m);
    }

    public Pawn(String s, String n) {
        super(s, n);
    }

    public String toString(){
        if(side.equals("W"))
            return "P";
        if(side.equals("B"))
            return "p";
        else
            return "color error";
    }

    public boolean isValidMove(Square newSquare, HashMap<String, Square> squareMap){

        char oldLetter = square.name.charAt(0);
        int oldNumber = Character.getNumericValue(square.name.charAt(1));
        char newLetter = newSquare.name.charAt(0);
        int newNumber = Character.getNumericValue(newSquare.name.charAt(1));

        boolean isEnemySquare = newSquare.chessPiece != null;

        int sign;

        //White pawn
        if(side.equals("W"))
            sign = 1;
        //Black pawn
        else
            sign = -1;

        //Pawn can move up one
        if((oldLetter == newLetter) && (newNumber == (oldNumber + sign)) &&
            !isEnemySquare){
            return true;
        }
        //If its the pawns first move it can move up two
        if((oldLetter == newLetter) && (newNumber == (oldNumber + 2*sign)) &&
            !isEnemySquare && moveCount == 0){
            return true;
        }
        //Attack Move (diagonal)
        if( (int) oldLetter == (int) newLetter + 1 && (newNumber == (oldNumber + sign)) &&
            isEnemySquare){
            return true;
        }
        if( (int) oldLetter == (int) newLetter - 1 && (newNumber == (oldNumber + 2*sign)) &&
            isEnemySquare){
            return true;
        }
        return false;
    }

}