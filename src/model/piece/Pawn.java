package model.piece;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Pawn implements Piece{

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
            imageURL = getClass().getResource("../../img/b_pawn.png");
        else
            imageURL = getClass().getResource("../../img/w_pawn.png");
    }

    @Override
    public boolean isValidMove(Point initPos, Point finalPos) {
        return false;
    }

}
