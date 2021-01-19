package Pieces;

public class Pawn extends Piece{

    public Pawn(String s, String n) {
        super(s, n);
    }

    public String toString(){
        if(side == "W")
            return "P";
        if(side == "B")
            return "p";
        else
            return "color error";
    }

    public boolean isValidMove(String newSquare){
        char oldLetter = squareName.charAt(0);
        int oldNumber = Character.getNumericValue(squareName.charAt(1));
        char newLetter = newSquare.charAt(0);
        int newNumber = Character.getNumericValue(newSquare.charAt(1));

        if(side == "W"){
            if((oldLetter == newLetter) && (newNumber == (oldNumber + 1))){
                return true;
            }
            if((oldLetter == newLetter) && (newNumber == (oldNumber + 2))){
                return true;
            }
            return false;
        }
        else{
            if((oldLetter == newLetter) && (newNumber == (oldNumber - 1))){
                return true;
            }
            if((oldLetter == newLetter) && (newNumber == (oldNumber - 2))){
                return true;
            }
            return false;
        }
    }


}
