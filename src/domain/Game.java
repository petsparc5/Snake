package domain;

import game.Progression;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import listerner.MovementListener;
import menu.MenuBarCreator;
import score.FinishedGameHandler;

public class Game {

    
    int WIDTH = 506;
    int HEIGHT = 380;
    int unit = 10;
    int fieldWidth = 50 * unit;
    int fieldHeight = 30 * unit;

    JButton[] field = new JButton[125];
    JFrame frame = new JFrame("Snake v0.7");
    JPanel playground;
    JPanel pointNumber;
    JPanel top = new JPanel();
    JPanel[] perimeter = new JPanel[4];
    JMenuBar menubar;
    JLabel pointDisplay;
    JScrollPane scrollpane;

   
    Progression progression = new Progression();
    FinishedGameHandler gameHandler = new FinishedGameHandler(top, frame);
    Runner runner = new Runner(progression, gameHandler);
    MenuBarCreator menuBarCreator = new MenuBarCreator(progression, playground, runner);
    //SnakeDisplayer displayer = new SnakeDisplayer(playground);

    MovementListener listener = new MovementListener(progression, runner);
    
    public void play() {
        
        // Egy WIDTH, HEIGHT méretekkel rendelkezõ abalak létrehozása
        frame.setSize(WIDTH, HEIGHT);

        // Az ablak részeinek létrehozása
        playground = new JPanel();
        runner.setPlayground(playground);
        pointNumber = new JPanel();
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setJMenuBar(menuBarCreator.createMenuBar());

        // A pálya részeinek részletes beállítása (pozíció, szélesség,
        // magasság, szín) és hozzáadása az ablakhoz
        frame.add(playground, BorderLayout.CENTER);
        frame.add(pointNumber, BorderLayout.SOUTH);
        frame.setLayout(null);
        playground.setLayout(null);
        playground.setBounds(0, 0, fieldWidth, fieldHeight);
        playground.setBackground(Color.LIGHT_GRAY);
        pointNumber.setBounds(0, fieldHeight, fieldWidth, 30);
        pointNumber.setBackground(Color.GRAY);
        top.setBounds(0, 0, fieldWidth, fieldHeight);
        top.setBackground(Color.LIGHT_GRAY);

        // Keret megrajzolása és hozzáadása a pályához
        perimeter[0] = new JPanel();
        perimeter[0].setBounds(0, 0, fieldWidth, unit);
        perimeter[1] = new JPanel();
        perimeter[1].setBounds(0, 0, unit, fieldHeight);
        perimeter[2] = new JPanel();
        perimeter[2].setBounds(0, fieldHeight - unit, fieldWidth, unit);
        perimeter[3] = new JPanel();
        perimeter[3].setBounds(fieldWidth - unit, 0, unit, fieldHeight);
        playground.add(perimeter[0]);
        playground.add(perimeter[1]);
        playground.add(perimeter[2]);
        playground.add(perimeter[3]);

        // A pontszám kíírása a képernyõre
        pointDisplay = new JLabel("Pontszám: " + runner.getScore());
        pointDisplay.setForeground(Color.BLACK);
        pointNumber.add(pointDisplay);

        // Az ablak beállításai
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addKeyListener(listener);
        
        runner.setFrame(frame);
        runner.setPointDisplay(pointDisplay);
        
        runner.run();
    }

}
