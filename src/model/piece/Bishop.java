package model.piece;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Bishop implements Piece{

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
            imageURL = getClass().getResource("../../img/b_bishop.png");
        else
            imageURL = getClass().getResource("../../img/w_bishop.png");
    }

    @Override
    public boolean isValidMove(Point initPos, Point finalPos) {
        int x = initPos.x;
        int y = initPos.y;
        int xDiference, yDiference;

        if(x > finalPos.x) xDiference = x - finalPos.x;
        else xDiference = finalPos.x - x;

        if(y > finalPos.y) yDiference = y - finalPos.y;
        else yDiference = finalPos.y - y;

        if(xDiference == yDiference) return true;

       return false;
    }

    @Override
    public PieceColor getColor() {
        return mColor;
    }
}
