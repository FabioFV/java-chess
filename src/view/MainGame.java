package view;

import controller.MainGameController;
import model.Board;
import model.piece.Blank;
import model.piece.Piece;
import model.piece.PieceColor;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class MainGame extends JFrame implements Runnable{

    private static final String TITLE = "Java Chess";
    private static final int HEIGHT = 510;
    private static final int WIDTH = 480;
    private static final int FPS = 60;

    private boolean running;

    private Board board;
    private boolean[][] grid = new boolean[8][8];

    private static Point initPos = null;
    private static Point finalPos = null;

    private static boolean firstPlayerMove = true;

    MainGame() {
        setTitle(TITLE);
        setSize(WIDTH,HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addMouseListener(new MainGameController());

        setVisible(true);
        init();
    }

    public static void clickTail(Point p)
    {
        if(initPos == null) {
            initPos = p;
            Piece piece = Board.mBoard[p.x][p.y];

            if(piece.getClass() == Blank.class) {
                initPos = null;
            }
            else {
                if(firstPlayerMove) {
                    if(piece.getColor() == PieceColor.BLACK)
                        initPos = null;
                }
                else {
                    if(piece.getColor() == PieceColor.WHITE)
                        initPos = null;
                }
            }

        }
        else
        {
            finalPos = p;

            Piece piece = Board.mBoard[p.x][p.y];
            Piece selectedPiece = Board.mBoard[initPos.x][initPos.y];

            if(piece.getClass() == Blank.class && selectedPiece.isValidMove(initPos, finalPos))
            {
                Board.mBoard[initPos.x][initPos.y] = piece;
                Board.mBoard[p.x][p.y] = selectedPiece;

                if(firstPlayerMove)
                    firstPlayerMove = false;
                else
                    firstPlayerMove = true;
            }

            initPos = null;
            finalPos = null;
        }
    }

    private void init() {
        board = new Board();

        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                grid[j][i] = false;
            }
        }


        running = true;
        run();
    }

    private void update()
    {
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                grid[j][i] = false;
            }
        }

        if(initPos != null)
            grid[initPos.x][initPos.y] = true;
        if(finalPos != null)
            grid[finalPos.x][finalPos.y] = true;

    }

    private void draw()
    {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        board.draw(g);
        g.setColor(Color.GREEN);

        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                if(grid[j][i])
                    g.drawRect(j*60, (i*60)+30, 60, 60);
            }
        }

        g.dispose();
        bs.show();
    }

    @Override
    public void run() {

        long targetTime = 1000 / FPS;
        long start;
        long elapsed;
        long wait;

        while(running)
        {
            start = System.nanoTime();

                update();
                draw();

            elapsed = System.nanoTime() - start;
            wait = targetTime - elapsed / 1000000;

            if(wait < 0)
                wait = 12;

            try{
                Thread.sleep(wait);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
    }

    public static void main(String args[]){
        new MainGame();
    }

}
