package model.piece;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Knight implements Piece{

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
            imageURL = getClass().getResource("../../img/b_knight.png");
        else
            imageURL = getClass().getResource("../../img/w_knight.png");
    }

    @Override
    public boolean isValidMove(Point initPos, Point finalPos) {
        return false;
    }

}
