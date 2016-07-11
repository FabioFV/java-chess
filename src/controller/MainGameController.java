package controller;

import view.MainGame;

import java.awt.*;
import java.awt.event.*;

public class MainGameController implements MouseListener, KeyListener{

    @Override
    public void mouseClicked(MouseEvent e) {
        Point p = e.getPoint();
        int x = (int) p.getX() / 60;
        int y = (int) ((p.getY() + 30) / 60) - 1;
        System.out.println("["+x+","+y+"]");
        MainGame.clickTail(new Point(x,y));
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        if(keyEvent.getKeyChar() == KeyEvent.VK_N)
            MainGame.newGame();
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
