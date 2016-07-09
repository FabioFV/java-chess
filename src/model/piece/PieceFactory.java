package model.piece;

public class PieceFactory {

    public Piece getPiece(PieceType type, PieceColor color)
    {
        if(type == PieceType.BISHOP)
        {
            Piece p = new Bishop();
            p.setColor(color);
            return p;
        }

        if(type == PieceType.KING)
        {
            Piece p = new King();
            p.setColor(color);
            return p;
        }

        if(type == PieceType.KNIGHT)
        {
            Piece p = new Knight();
            p.setColor(color);
            return p;
        }

        if(type == PieceType.PAWN)
        {
            Piece p = new Pawn();
            p.setColor(color);
            return p;
        }

        if(type == PieceType.QUEEN)
        {
            Piece p = new Queen();
            p.setColor(color);
            return p;
        }

        if(type == PieceType.ROOK)
        {
            Piece p = new Rook();
            p.setColor(color);
            return p;
        }

        if(type == PieceType.BLANK)
        {
            Piece p = new Blank();
            return p;
        }
        return null;
    }

}
