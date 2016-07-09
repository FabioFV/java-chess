package model.piece;

import java.awt.*;

public interface Piece {

    void draw(Graphics g, int x, int y);
    void setColor(PieceColor color);

}
