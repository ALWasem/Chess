import Pieces.*;

import java.util.*;

public class Board {

    public Square[][] board;

    public Piece[] pieces;

    public HashMap<String, Piece> pieceMap;

    public HashMap<String, Square> squareMap;

    public void createPieces(){

        pieces = new Piece[32];

        pieces[0] = new Rook("B", "qr");
        pieces[1] = new Knight("B", "qn");
        pieces[2] = new Bishop("B", "qb");
        pieces[3] = new Queen("B", "q");
        pieces[4] = new King("B", "k");
        pieces[5] = new Bishop("B", "kb");
        pieces[6] = new Knight("B", "kn");
        pieces[7] = new Rook("B", "kr");
        pieces[8] = new Pawn("B", "qrp");
        pieces[9] = new Pawn("B", "qnp");
        pieces[10] = new Pawn("B", "qbp");
        pieces[11] = new Pawn("B", "qp");
        pieces[12] = new Pawn("B", "kp");
        pieces[13] = new Pawn("B", "kbp");
        pieces[14] = new Pawn("B", "knp");
        pieces[15] = new Pawn("B", "krp");

        pieces[16] = new Pawn("W", "QRP");
        pieces[17] = new Pawn("W", "QNP");
        pieces[18] = new Pawn("W", "QBP");
        pieces[19] = new Pawn("W", "QP");
        pieces[20] = new Pawn("W", "KP");
        pieces[21] = new Pawn("W", "KBP");
        pieces[22] = new Pawn("W", "KNP");
        pieces[23] = new Pawn("W", "KRP");
        pieces[24] = new Rook("W", "QR");
        pieces[25] = new Knight("W", "QN");
        pieces[26] = new Bishop("W", "QB");
        pieces[27] = new Queen("W", "Q");
        pieces[28] = new King("W", "K");
        pieces[29] = new Bishop("W", "KB");
        pieces[30] = new Knight("W", "KN");
        pieces[31] = new Rook("W", "KR");

    }

    public void createPiecesMap(){
        pieceMap = new HashMap<>();
        for(int i = 0; i < 32; i++){
            pieceMap.put(pieces[i].name, pieces[i]);
        }
    }

    public Board(){
        board = new Square[8][8];
        squareMap = new HashMap<>();
        createPieces();
        String squareName;
        for(int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                squareName = (char)(65+j) + String.valueOf(8-i);
                Square square = new Square(squareName);
                board[i][j] = square;

                squareMap.put(squareName, square);

                if(i == 0)
                    square.addPiece(pieces[j]);
                else if(i == 1)
                    square.addPiece(pieces[j+8]);
                else if(i == 6)
                    square.addPiece(pieces[j+16]);
                else if(i == 7)
                    square.addPiece(pieces[j+24]);
            }
        }
    }

    public void startGame(){

        //initialize turn
        int turn = 1;
        String side;

        //Create string maps to the pieces and squares
        createPiecesMap();

        //initialize the input string
        String move;

        //Loop until user ends program or a winner is decided
        while(true){
            //print the board
            System.out.print(this.toString());

            //determine who's turn
            if (turn % 2 == 0){
                System.out.print("Black move: ");
                side = "B";
            }
            else{
                System.out.print("White move: ");
                side = "W";

            }

            //Users input
            Scanner s = new Scanner(System.in);
            move = s.nextLine();

            //If End is entered, end the program
            if(move.equals("End")) {
                System.out.print("\n");
                System.out.print("You have ended the game.");
                System.out.print("\n");
                break;
            }

            //Collect info from user input
            int firstSpace = move.indexOf(" ");
            String pieceName = move.substring(0, firstSpace);
            String newSquareName = move.substring(move.length() - 2);
            newSquareName = newSquareName.toUpperCase();

            //If user enters an invalid piece
            if(!pieceMap.containsKey(pieceName)){
                System.out.print("\n");
                System.out.print("Piece does not exist!");
                System.out.print("\n");
            }
            else{

                //If user enters an invalid square
                if(!squareMap.containsKey(newSquareName)){
                    System.out.print("\n");
                    System.out.print("Square does not exist!");
                    System.out.print("\n");
                }
                else{
                    Piece piece = pieceMap.get(pieceName);

                    //If the user inters a piece on the wrong side
                    if(!piece.side.equals(side)){
                        System.out.print("\n");
                        System.out.print("Wrong side!");
                        System.out.print("\n");
                    }
                    else{
                        Square newSquare = squareMap.get(newSquareName);
                        String oldSquareName = piece.squareName;

                        //Check if the new square has a friendly piece or enemy piece
                        boolean isFriendlySquare;
                        boolean isEnemySquare;
                        if(newSquare.chessPiece == null){
                            isFriendlySquare = false;
                            isEnemySquare = false;
                        }
                        else if(newSquare.getChessPiece().side.equals(side)){
                            isFriendlySquare = true;
                            isEnemySquare = false;
                        }
                        else{
                            isEnemySquare = true;
                            isFriendlySquare = false;
                        }

                        if(!piece.isValidMove(newSquareName) || isFriendlySquare){
                            System.out.print("\n");
                            System.out.print("Invalid move!");
                            System.out.print("\n");
                        }
                        else{

                            //If enemy piece is in new square, kill it
                            if(isEnemySquare){
                                if(newSquare.getChessPiece().toString().equals("k")){
                                    System.out.print("\n");
                                    System.out.print("White Wins!");
                                    System.out.print("\n");
                                    break;
                                }
                                if(newSquare.getChessPiece().toString().equals("K")){
                                    System.out.print("\n");
                                    System.out.print("Black Wins!");
                                    System.out.print("\n");
                                    break;
                                }
                                newSquare.killPiece(piece, pieces);

                            }

                            squareMap.get(oldSquareName).emptySquare();
                            squareMap.get(newSquareName).addPiece(piece);

                            //Add turn
                            turn ++;
                        }
                    }
                }
            }
        }
    }

    public String toString(){
        StringBuilder sBoard = new StringBuilder("\n");
        for(int i = 0; i < 8; i++){
            sBoard.append(8 - i).append(" ");
            for(int j = 0; j < 8; j++){
                sBoard.append(board[i][j].toString());
            }
           sBoard.append("\n");
        }
        sBoard.append("   A  B  C  D  E  F  G  H ");
        sBoard.append("\n");
        return sBoard.toString();
    }

}
