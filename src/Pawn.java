import java.util.HashMap;

public class Pawn extends Piece {

    public Pawn(String s, String n, int m) {
        super(s, n, m);
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

        //White Pawn
        if(side.equals("W")){
            //Pawn can move up one
            if((oldLetter == newLetter) && (newNumber == (oldNumber + 1)) &&
                !isEnemySquare){
                return true;
            }
            //If its the pawns first move it can move up two
            if((oldLetter == newLetter) && (newNumber == (oldNumber + 2)) &&
                !isEnemySquare && moveCount == 0){
                return true;
            }
            //Attack Move (diagonal)
            if( (int) oldLetter == (int) newLetter + 1 && (newNumber == (oldNumber + 1)) &&
                isEnemySquare){
                return true;
            }
            if( (int) oldLetter == (int) newLetter - 1 && (newNumber == (oldNumber + 1)) &&
                isEnemySquare){
                return true;
            }
        }
        //Black Pawn
        else{
            if((oldLetter == newLetter) && (newNumber == (oldNumber - 1)) &&
                !isEnemySquare){
                return true;
            }
            //If its the pawns first move it can move up two
            if((oldLetter == newLetter) && (newNumber == (oldNumber - 2)) &&
                !isEnemySquare && moveCount == 0){
                return true;
            }
            //Attack Move (diagonal)
            if( (int) oldLetter == (int) newLetter + 1 && (newNumber == (oldNumber - 1)) &&
                isEnemySquare){
                return true;
            }
            if( (int) oldLetter == (int) newLetter - 1 && (newNumber == (oldNumber - 1)) &&
                isEnemySquare){
                return true;
            }
        }
        return false;
    }


}
