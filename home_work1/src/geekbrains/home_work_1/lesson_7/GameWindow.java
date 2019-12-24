package geekbrains.home_work_1.lesson_7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    private static final int WIN_WIDTH = 507;
    private static final int WIN_HEIGHT = 555;
    private static final int WIN_POSX = 370;
    private static final int WIN_POSY = 110;
    private final Map map;

    GameWindow(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIN_WIDTH, WIN_HEIGHT);
        setLocation(WIN_POSX, WIN_POSY);
        setResizable(false);
        setTitle("Крестики-Нолики");
        JButton btnStart = new JButton("Старт");
        JButton btnSExit = new JButton("Выход");
        JPanel panelBottom = new JPanel(new GridLayout(1,2));
        panelBottom.add(btnStart);
        panelBottom.add(btnSExit);
        map = new Map();
        Settings settings = new Settings(this);
        btnSExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);
            }
        });


        add(map, BorderLayout.CENTER);
        add(panelBottom, BorderLayout.SOUTH);
        setVisible(true);
    }

    void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLen){
        map.startNewGame(gameMode, fieldSizeX, fieldSizeY, winLen);

    }
}
