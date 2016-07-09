package model.piece;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Rook implements Piece{

    private URL imageURL;

    @Override
    public void draw(Graphics g, int x, int y) {
        Image pieceImage = new ImageIcon(imageURL).getImage();
        g.drawImage(pieceImage, x, y, null);
    }

    @Override
    public void setColor(PieceColor color) {

        if(color == PieceColor.BLACK)
            imageURL = getClass().getResource("../../img/b_rook.png");
        else
            imageURL = getClass().getResource("../../img/w_rook.png");
    }

}
