package model.piece;

import java.awt.*;

public class Blank implements Piece{

    @Override
    public void draw(Graphics g, int x, int y) {

    }

    @Override
    public boolean isValidMove(Point initPos, Point finalPos) {
        return false;
    }

    @Override
    public void setColor(PieceColor color) {

    }
}
