package chess;

public class ChessException extends RuntimeException{
    private static long iL;
    private static final long serialVersionUID = iL;

    public ChessException(String msg){
        super(msg);
    }
}
