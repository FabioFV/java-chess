package model.piece;

import java.awt.*;

public class Blank implements Piece{

    @Override
    public void draw(Graphics g, int x, int y) {

    }

    @Override
    public boolean isValidMove(int ix, int iy, int fx, int fy) {
        return false;
    }

    @Override
    public void setColor(PieceColor color) {

    }
}
