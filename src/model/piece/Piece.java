package model.piece;

import java.awt.*;

public interface Piece {

    void draw(Graphics g, int x, int y);
    boolean isValidMove(int ix, int iy, int fx, int fy);
    void setColor(PieceColor color);

}
