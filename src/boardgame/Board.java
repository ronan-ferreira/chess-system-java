package boardgame;

public class Board {

    private int rows;
    private  int columms;
    private  Piece[][] pieces;

    public Board(int rows, int columms) {
        if (rows < 1 || columms < 1){
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columms = columms;
        pieces = new Piece[rows][columms];
    }

    public int getRows() {
        return rows;
    }


    public int getColumms() {
        return columms;
    }

    public void setColumms(int columms) {
        this.columms = columms;
    }
    public Piece piece(int row, int columm){
        if (!positionExists(row, columm)){
            throw new BoardException("Positio not on the board");
        }
        return pieces[row][columm];
    }
    public Piece piece(Position position){
        if (!positionExists(position)){
            throw new BoardException("Positio not on the board");
        }
        return pieces[position.getRow()][position.getColumn()];
    }
    public void placePiece(Piece piece, Position position){
        if (thereIsAPiece(position)){
           throw  new BoardException("There is already a piece on position" + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }
    public Piece removedPiece(Position position){
        if (!positionExists(position)){
            throw new BoardException("Positio not on the board");
        }
        if (piece(position) == null){
            return null;
        }
        Piece aux = piece(position);
        aux.position = null;
        pieces[position.getRow()][position.getColumn()] = null;
        return aux;

    }
    private boolean positionExists(int row, int columm){
        return row >= 0 && row < rows && columm >= 0 && columm < columms;
    }
    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColumn());
    }
    public boolean thereIsAPiece(Position position){
        if (!positionExists(position)){
            throw new BoardException("Positio not on the board");
        }
        return piece(position) != null;
    }

}
