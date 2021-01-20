import java.util.HashMap;

public class Knight extends Piece {

    public Knight(String s, String n, int m) {
        super(s, n, m);
    }

    public String toString(){
        if(side.equals("W"))
            return "N";
        if(side.equals("B"))
            return "n";
        else
            return "color error";
    }

    public boolean isValidMove(Square newSquare, HashMap<String, Square> squareMap){

        char oldLetter = square.name.charAt(0);
        int oldNumber = Character.getNumericValue(square.name.charAt(1));
        char newLetter = newSquare.name.charAt(0);
        int newNumber = Character.getNumericValue(newSquare.name.charAt(1));

        //Up two Right one
        if((int) oldLetter == (int) newLetter + 1 && (newNumber == (oldNumber + 2)))
            return true;
        //Up two Left one
        else if((int) oldLetter == (int) newLetter - 1 && (newNumber == (oldNumber + 2)))
            return true;
        //Down two Right one
        else if((int) oldLetter == (int) newLetter + 1 && (newNumber == (oldNumber - 2)))
            return true;
        //Down two Left one
        else if((int) oldLetter == (int) newLetter - 1 && (newNumber == (oldNumber - 2)))
            return true;
        //Up one Right two
        else if((int) oldLetter == (int) newLetter + 2 && (newNumber == (oldNumber + 1)))
            return true;
        //Up one Left two
        else if((int) oldLetter == (int) newLetter - 2 && (newNumber == (oldNumber + 1)))
            return true;
        //Down one Right two
        else if((int) oldLetter == (int) newLetter + 2 && (newNumber == (oldNumber - 1)))
            return true;
        //Down one Left two
        else if((int) oldLetter == (int) newLetter - 2 && (newNumber == (oldNumber - 1)))
            return true;
        else
            return false;
    }

}
