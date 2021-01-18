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

    public void createSquaresMap(){
        squareMap = new HashMap<>();
        for(int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                squareMap.put(Character.toString((char)(65+j)) + String.valueOf(8-i), board[i][j]);
            }
        }
    }

    public Board(){
        board = new Square[8][8];
        createPieces();
        for(int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(i == 0)
                    board[i][j] = new Square(pieces[j]);
                else if(i == 1)
                    board[i][j] = new Square(pieces[j+8]);
                else if(i == 6)
                    board[i][j] = new Square(pieces[j+16]);
                else if(i == 7)
                    board[i][j] = new Square(pieces[j+24]);
                else
                    board[i][j] = new Square();
            }
        }
    }

    public <K, V> K getKey(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public String getOldPosition(String piece){
        for(int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j].pieceName().equals(piece)) {
                    return getKey(squareMap, board[i][j]);
                }
            }
        }
        return null;
    }

    public void updateBoard(){
        createPiecesMap();
        createSquaresMap();

        String move = "";

        while(true){
            Scanner s = new Scanner(System.in);
            System.out.print("Enter your move: ");
            move = s.nextLine();
            if(move.equals("End"))
                break;
            int firstSpace = move.indexOf(" ");

            String piece = move.substring(0, firstSpace);
            String newPosition = move.substring(move.length() - 2);
            String oldPosition = getOldPosition(piece);

            squareMap.get(oldPosition).emptySquare();
            squareMap.get(newPosition).addPiece(pieceMap.get(piece));

            System.out.print(this.toString());
        }
    }

    public String toString(){
        String sBoard = "\n";
        for(int i = 0; i < 8; i++){
            sBoard += String.valueOf(8 - i) + " ";
            for(int j = 0; j < 8; j++){
                sBoard += board[i][j].toString();
            }
           sBoard += "\n";
        }
        sBoard += "   A  B  C  D  E  F  G  H ";
        sBoard += "\n";
        return sBoard;
    }


}