package chess;

import boardgame.BoardException;

public class ChessException extends BoardException{
    private static long iL;
    private static final long serialVersionUID = iL;

    public ChessException(String msg){
        super(msg);
    }
}
