package model;

import model.piece.Piece;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Board {

    Piece[][] mBoard = new Piece[8][8];
    private URL IMAGE_URL = getClass().getResource("../img/board.png");

    public Board() {
        init();
    }

    private void init()
    {

    }

    public void draw(Graphics g)
    {
        Image boardImage = new ImageIcon(IMAGE_URL).getImage();
        g.drawImage(boardImage,0,30,null);
    }

}
