package controller;

import view.MainGame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainGameController implements MouseListener{

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
}
