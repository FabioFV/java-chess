package model;

import model.piece.*;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Board {

    public static Piece[][] mBoard = new Piece[8][8];
    private URL IMAGE_URL = getClass().getResource("../img/board.png");

    PieceFactory factory;

    public Board() {
        init();
    }

    private void init()
    {
        factory = new PieceFactory();

        //Black Pieces
        mBoard[0][0] = factory.getPiece(PieceType.ROOK, PieceColor.BLACK);
        mBoard[1][0] = factory.getPiece(PieceType.KNIGHT, PieceColor.BLACK);
        mBoard[2][0] = factory.getPiece(PieceType.BISHOP, PieceColor.BLACK);
        mBoard[3][0] = factory.getPiece(PieceType.QUEEN, PieceColor.BLACK);
        mBoard[4][0] = factory.getPiece(PieceType.KING, PieceColor.BLACK);
        mBoard[5][0] = factory.getPiece(PieceType.BISHOP, PieceColor.BLACK);
        mBoard[6][0] = factory.getPiece(PieceType.KNIGHT, PieceColor.BLACK);
        mBoard[7][0] = factory.getPiece(PieceType.ROOK, PieceColor.BLACK);

        //Pawns
        for(int i = 0; i < 8; i++)
            mBoard[i][1] = factory.getPiece(PieceType.PAWN, PieceColor.BLACK);

        //Spaces
        for(int i = 2; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                mBoard[j][i] = factory.getPiece(PieceType.BLANK, null);
            }
        }

        //White Pieces
        mBoard[0][7] = factory.getPiece(PieceType.ROOK, PieceColor.WHITE);
        mBoard[1][7] = factory.getPiece(PieceType.KNIGHT, PieceColor.WHITE);
        mBoard[2][7] = factory.getPiece(PieceType.BISHOP, PieceColor.WHITE);
        mBoard[3][7] = factory.getPiece(PieceType.QUEEN, PieceColor.WHITE);
        mBoard[4][7] = factory.getPiece(PieceType.KING, PieceColor.WHITE);
        mBoard[5][7] = factory.getPiece(PieceType.BISHOP, PieceColor.WHITE);
        mBoard[6][7] = factory.getPiece(PieceType.KNIGHT, PieceColor.WHITE);
        mBoard[7][7] = factory.getPiece(PieceType.ROOK, PieceColor.WHITE);

        //Pawns
        for(int i = 0; i < 8; i++)
            mBoard[i][6] = factory.getPiece(PieceType.PAWN, PieceColor.WHITE);
    }

    public void draw(Graphics g)
    {
        Image boardImage = new ImageIcon(IMAGE_URL).getImage();
        g.drawImage(boardImage,0,30,null);

        for(int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++) {
                mBoard[j][i].draw(g, j*60, (i*60)+30);
            }
        }


    }

    public boolean pieceCanPass(Point initPos, Point finalPos, Piece piece)
    {
        if(piece.getClass() == Bishop.class)
        {
            if(initPos.x > finalPos.x && initPos.y > finalPos.y)
            {
                for (int i = initPos.x - 1, j = initPos.y - 1; i > finalPos.x; i--, j--) {
                    if(mBoard[i][j].getClass() != Blank.class)
                        return false;
                }
            }

            if(initPos.x < finalPos.x && initPos.y < finalPos.y)
            {
                for (int i = initPos.x + 1, j = initPos.y + 1; i < finalPos.x; i++, j++) {
                    if(mBoard[i][j].getClass() != Blank.class)
                        return false;
                }
            }

            if(initPos.x < finalPos.x && initPos.y > finalPos.y)
            {
                for (int i = initPos.x + 1, j = initPos.y - 1; i < finalPos.x; i++, j--) {
                    System.out.println("["+i+","+j+"]");
                    if(mBoard[i][j].getClass() != Blank.class)
                        return false;
                }
            }

            if(initPos.x > finalPos.x && initPos.y < finalPos.y)
            {
                for (int i = initPos.x - 1, j = initPos.y + 1; i > finalPos.x; i--, j++) {
                    if(mBoard[i][j].getClass() != Blank.class)
                        return false;
                }
            }
        }

        else if(piece.getClass() == Rook.class){
            if(initPos.x == finalPos.x)
            {
                if(initPos.y > finalPos.y)
                {
                    for (int i = initPos.y - 1; i > finalPos.y; i--) {
                        if(mBoard[initPos.x][i].getClass() != Blank.class)
                            return false;
                    }
                }
                else
                {
                    for (int i = initPos.y + 1; i < finalPos.y; i++) {
                        if(mBoard[initPos.x][i].getClass() != Blank.class)
                            return false;
                    }
                }
            }
            else
            {
                if(initPos.x > finalPos.x)
                {
                    for (int i = initPos.x - 1; i > finalPos.x; i--) {
                        if(mBoard[i][initPos.y].getClass() != Blank.class)
                            return false;
                    }
                }
                else
                {
                    for (int i = initPos.x + 1; i < finalPos.x; i++) {
                        System.out.println(i);
                        if(mBoard[i][initPos.y].getClass() != Blank.class)
                            return false;
                    }
                }
            }
        }

        else if(piece.getClass() == Pawn.class) {

            int xDiference, yDiference;

            if(initPos.x > finalPos.x)
                xDiference = initPos.x - finalPos.x;
            else
                xDiference = finalPos.x - initPos.x;

            if(initPos.y > finalPos.y)
                yDiference = initPos.y - finalPos.y;
            else
                yDiference = finalPos.y - initPos.y;

            if(xDiference == yDiference)
            {
                if(mBoard[finalPos.x][finalPos.y].getClass() == Blank.class)
                    return false;
            }

        }
        else if(piece.getClass() == Queen.class){
            if(initPos.x > finalPos.x && initPos.y > finalPos.y)
            {
                for (int i = initPos.x - 1, j = initPos.y - 1; i > finalPos.x; i--, j--) {
                    if(mBoard[i][j].getClass() != Blank.class)
                        return false;
                }
            }

            if(initPos.x < finalPos.x && initPos.y < finalPos.y)
            {
                for (int i = initPos.x + 1, j = initPos.y + 1; i < finalPos.x; i++, j++) {
                    if(mBoard[i][j].getClass() != Blank.class)
                        return false;
                }
            }

            if(initPos.x < finalPos.x && initPos.y > finalPos.y)
            {
                for (int i = initPos.x + 1, j = initPos.y - 1; i < finalPos.x; i++, j--) {
                    System.out.println("["+i+","+j+"]");
                    if(mBoard[i][j].getClass() != Blank.class)
                        return false;
                }
            }

            if(initPos.x > finalPos.x && initPos.y < finalPos.y)
            {
                for (int i = initPos.x - 1, j = initPos.y + 1; i > finalPos.x; i--, j++) {
                    if(mBoard[i][j].getClass() != Blank.class)
                        return false;
                }
            }

            if(initPos.x == finalPos.x && initPos.y != finalPos.y)
            {
                if(initPos.y > finalPos.y)
                {
                    for (int i = initPos.y - 1; i > finalPos.y; i--) {
                        if(mBoard[initPos.x][i].getClass() != Blank.class)
                            return false;
                    }
                }
                else
                {
                    for (int i = initPos.y + 1; i < finalPos.y; i++) {
                        if(mBoard[initPos.x][i].getClass() != Blank.class)
                            return false;
                    }
                }
            }

            if(initPos.y == finalPos.y && initPos.x != finalPos.x)
            {
                if(initPos.x > finalPos.x)
                {
                    for (int i = initPos.x - 1; i > finalPos.x; i--) {
                        if(mBoard[i][initPos.y].getClass() != Blank.class)
                            return false;
                    }
                }
                else
                {
                    for (int i = initPos.x + 1; i < finalPos.x; i++) {
                        System.out.println(i);
                        if(mBoard[i][initPos.y].getClass() != Blank.class)
                            return false;
                    }
                }
            }
        }

        return true;
    }

}
