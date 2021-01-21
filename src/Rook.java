import java.util.*;

public class Rook extends Piece {

    public Rook(String s, String n, int m) {
        super(s, n, m);
    }

    public Rook(String s, String n) {
        super(s, n);
    }

    public String toString(){
        if(side.equals("W"))
            return "R";
        if(side.equals("B"))
            return "r";
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

        boolean isStraight = letterDifference == 0 || numberDifference == 0;

        int squaresMoved;

        String squareNameCheck = "";

        //Check if the move is straight
        if(isStraight){

            //Check if Up/Down or Left/Right
            if(oldLetter == newLetter)
                squaresMoved = Math.abs(oldNumber - newNumber);
            else
                squaresMoved = Math.abs((int)oldLetter - (int)newLetter);

            //loop through each ascending square
            for(int i = 1; i < squaresMoved; i++){
                //Right
                if((int)oldLetter < (int)newLetter && oldNumber == newNumber)
                    squareNameCheck = String.valueOf((char)((int) oldLetter + i)) + newNumber;
                //Left
                if((int)oldLetter > (int)newLetter && oldNumber == newNumber)
                    squareNameCheck = String.valueOf((char)((int) oldLetter - i)) + newNumber;
                //Up
                if(oldNumber < newNumber && oldLetter == newLetter)
                    squareNameCheck = newLetter + String.valueOf(oldNumber + i);
                //Down
                if(oldNumber > newNumber && oldLetter == newLetter)
                    squareNameCheck = newLetter + String.valueOf(oldNumber - i);

                if(squareMap.get(squareNameCheck).chessPiece != null)
                    return false;
            }
            return true;
        }
        return false;
    }

}