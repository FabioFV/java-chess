package view;

import javax.swing.*;

public class MainGame extends JFrame{

    private static final String TITLE = "Java Chess";
    private static final int HEIGHT = 480;
    private static final int WIDTH = 480;

    private JMenuBar menuBar;

    private void createMenuBar()
    {
        menuBar = new JMenuBar();

        JMenu menu = new JMenu("File");

        JMenuItem newGameItem = new JMenuItem("New Game");
        JMenuItem exitItem = new JMenuItem("Exit");

        menu.add(newGameItem);
        menu.add(exitItem);

        menuBar.add(menu);
    }

    MainGame()
    {
        setTitle(TITLE);
        setSize(WIDTH,HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        createMenuBar();
        setJMenuBar(menuBar);

        setVisible(true);
    }

    public static void main(String args[]){
        new MainGame();
    }

}
