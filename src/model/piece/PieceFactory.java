package model.piece;

public class PieceFactory {

    public Piece getPiece(PieceType type, PieceColor color)
    {
        if(type == PieceType.BISHOP)
            return new Bishop();

        if(type == PieceType.KING)
            return new King();

        if(type == PieceType.KNIGHT)
            return new Knight();

        if(type == PieceType.PAWN)
            return new Pawn();

        if(type == PieceType.QUEEN)
            return new Queen();

        if(type == PieceType.ROOK)
            return new Rook();

        return null;
    }

}
