import java.util.*;

public class Bishop extends Piece {

    public Bishop(String s, String n, int m) {
        super(s, n, m);
    }

    public Bishop(String s, String n) {
        super(s, n);
    }

    public String toString(){
        if(side.equals("W"))
            return "B";
        if(side.equals("B"))
            return "b";
        else
            return "color error";
    }

    public boolean isValidMove(Square newSquare, HashMap<String, Square> squareMap){

        char oldLetter = square.name.charAt(0);
        int oldNumber = Character.getNumericValue(square.name.charAt(1));
        char newLetter = newSquare.name.charAt(0);
        int newNumber = Character.getNumericValue(newSquare.name.charAt(1));

        int letterDifference = Math.abs((int)oldLetter - (int)newLetter);
        int numberDifference = Math.abs(oldNumber - newNumber);

        boolean isDiagonal = letterDifference == numberDifference;

        int squaresMoved;

        String squareNameCheck = "";

        //Check if the move is diagonal
        if(isDiagonal){
            squaresMoved = Math.abs((int)oldLetter - (int)newLetter);

            //loop through each ascending square
            for(int i = 1; i < squaresMoved; i++) {
                //Up-Right
                if (oldNumber < newNumber && (int)oldLetter < (int)newLetter)
                    squareNameCheck = (char)((int) oldLetter + i) + String.valueOf(oldNumber + i);
                //Up-Left
                if (oldNumber < newNumber && (int)oldLetter > (int)newLetter)
                    squareNameCheck = (char)((int) oldLetter - i) + String.valueOf(oldNumber + i);
                //Down-Right
                if (oldNumber > newNumber && (int)oldLetter < (int)newLetter)
                    squareNameCheck = (char)((int) oldLetter + i) + String.valueOf(oldNumber - i);
                //Down-Left
                if (oldNumber > newNumber && (int)oldLetter > (int)newLetter)
                    squareNameCheck = (char)((int) oldLetter - i) + String.valueOf(oldNumber - i);

                if (squareMap.get(squareNameCheck).chessPiece != null)
                    return false;
            }
            return true;
        }
        return false;

    }

}