package model.piece;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class King implements Piece{

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
            imageURL = getClass().getResource("../../img/b_king.png");
        else
            imageURL = getClass().getResource("../../img/w_king.png");
    }

    @Override
    public boolean isValidMove(Point initPos, Point finalPos) {
        int x = initPos.x;
        int y = initPos.y;

        if(finalPos.x == x + 1 && finalPos.y == y) return true;
        if(finalPos.x == x - 1 && finalPos.y == y) return true;
        if(finalPos.y == y + 1 && finalPos.x == x) return true;
        if(finalPos.y == y - 1 && finalPos.x == x) return true;
        if(finalPos.y == y - 1 && finalPos.x == x - 1) return true;
        if(finalPos.y == y + 1 && finalPos.x == x + 1) return true;
        if(finalPos.y == y - 1 && finalPos.x == x + 1) return true;
        if(finalPos.y == y + 1 && finalPos.x == x - 1) return true;

        else return false;
    }

    @Override
    public PieceColor getColor() {
        return mColor;
    }

}
