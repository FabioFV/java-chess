package model.piece;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Queen implements Piece{

    private URL imageURL;
    private PieceColor mColor;

    @Override
    public void draw(Graphics g, int x, int y) {
        Image pieceImage = new ImageIcon(imageURL).getImage();
        g.drawImage(pieceImage, x, y, null);
    }

    @Override
    public void setColor(PieceColor color) {
        mColor = color;

        if(color == PieceColor.BLACK)
            imageURL = getClass().getResource("../../img/b_queen.png");
        else
            imageURL = getClass().getResource("../../img/w_queen.png");
    }

    @Override
    public boolean isValidMove(Point initPos, Point finalPos) {
        int x = initPos.x;
        int y = initPos.y;
        boolean validBishopMove, validRookMove;

        PieceFactory factory = new PieceFactory();
        Piece dummyBishop = factory.getPiece(PieceType.BISHOP, PieceColor.WHITE);
        Piece dummyRook = factory.getPiece(PieceType.ROOK, PieceColor.WHITE);

        if(dummyBishop.isValidMove(initPos, finalPos) || dummyRook.isValidMove(initPos, finalPos))
            return true;

        return false;
    }

    @Override
    public PieceColor getColor() {
        return mColor;
    }
}
