import java.util.*;

public class King extends Piece {

    public King(String s, String n, int m) {
        super(s, n, m);
    }

    public King(String s, String n) {
        super(s, n);
    }

    public String toString(){
        if(side.equals("W"))
            return "K";
        if(side.equals("B"))
            return "k";
        else
            return "color error";
    }

    public boolean isValidMove(Square newSquare, HashMap<String, Square> squareMap){

        char oldLetter = square.name.charAt(0);
        int oldNumber = Character.getNumericValue(square.name.charAt(1));
        char newLetter = newSquare.name.charAt(0);
        int newNumber = Character.getNumericValue(newSquare.name.charAt(1));

        //Up
        if((oldLetter == newLetter) && (newNumber == (oldNumber + 1)))
            return true;
        //Down
        else if((oldLetter == newLetter) && (newNumber == (oldNumber - 1)))
            return true;
        //Left
        else if((int) oldLetter == (int) newLetter - 1 && newNumber == oldNumber)
            return true;
        //Right
        else if((int) oldLetter == (int) newLetter + 1 && newNumber == oldNumber)
            return true;
        //Up-Left
        else if((int) oldLetter == (int) newLetter - 1 && (newNumber == (oldNumber + 1)))
            return true;
        //Up-Right
        else if((int) oldLetter == (int) newLetter + 1 && (newNumber == (oldNumber + 1)))
            return true;
        //Down-Left
        else if((int) oldLetter == (int) newLetter - 1 && (newNumber == (oldNumber - 1)))
            return true;
        //Down-Right
        else if((int) oldLetter == (int) newLetter + 1 && (newNumber == (oldNumber - 1)))
            return true;
        else
            return false;
    }

}