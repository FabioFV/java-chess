package model.piece;

import java.awt.*;

public interface Piece {

    void draw(Graphics g, int x, int y);
    boolean isValidMove(Point initPos, Point finalPos);
    void setColor(PieceColor color);
    PieceColor getColor();

}
