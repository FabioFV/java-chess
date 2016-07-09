package view;

import model.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class MainGame extends JFrame implements Runnable{

    private static final String TITLE = "Java Chess";
    private static final int HEIGHT = 510;
    private static final int WIDTH = 480;
    private static final int FPS = 60;

    private boolean running;
    private long targetTime = 1000 / FPS;

    private JMenuBar menuBar;

    Board board;

    private void createMenuBar() {
        menuBar = new JMenuBar();

        JMenu menu = new JMenu("File");

        JMenuItem newGameItem = new JMenuItem("New Game");
        JMenuItem exitItem = new JMenuItem("Exit");

        menu.add(newGameItem);
        menu.add(exitItem);

        menuBar.add(menu);
    }

    MainGame() {
        setTitle(TITLE);
        setSize(WIDTH,HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        createMenuBar();
        setJMenuBar(menuBar);

        setVisible(true);
        init();
    }

    private void init() {
        board = new Board();
        running = true;
        run();
    }

    private void update()
    {

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

        g.dispose();
        bs.show();
    }

    @Override
    public void run() {

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
