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
    public PieceColor getColor() {
        return mColor;
    }

    @Override
    public boolean isValidMove(Point initPos, Point finalPos) {
        int x = initPos.x;
        int y = initPos.y;

        if(this.mColor == PieceColor.WHITE){
            if(y == 6 && ( y - finalPos.y >= 0 && y - finalPos.y <= 2)
                    && (x == finalPos.x || x == finalPos.x - 1 || x == finalPos.x + 1)){
                return true;
            }
            else if ( y - finalPos.y == 1 && (x == finalPos.x || x == finalPos.x - 1 || x == finalPos.x + 1)){
                return true;
            }
            return false;
        }
        if(this.mColor == PieceColor.BLACK){
            if(y == 1 && ( finalPos.y - y >= 0 && finalPos.y - y <= 2)
                    && (x == finalPos.x || x == finalPos.x - 1 || x == finalPos.x + 1)){
                return true;
            }
            else if ( finalPos.y - y == 1 && (x == finalPos.x || x == finalPos.x - 1 || x == finalPos.x + 1)){
                return true;
            }
            return false;
        }

        return false;
    }

}
