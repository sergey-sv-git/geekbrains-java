package geekbrains.home_work_1.lesson_7;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JFrame {
    public static final int WINDOW_WIDTH = 350;
    public static final int WINDOW_HEIGHT = 270;
    GameWindow gameWindow;
    private JRadioButton jrbHumVsAi;
    private JRadioButton jrbHumVsHum;
    private JSlider jsFieldSize;
    private JSlider jsWinLength;
    private static final String FIELD_SIZE_FREFIX = "Размер поля: ";
    private static final String WIN_LENGTH_PREFIX = "Выигрышная длина: ";
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;
    private static final int MIN_WIN_LENGTH = 3;

    Settings(GameWindow gameWindow){
        this.gameWindow = gameWindow;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        Rectangle gameWindowsBounds = gameWindow.getBounds();
        int posX = (int)gameWindowsBounds.getCenterX() - WINDOW_WIDTH/2;
        int posY = (int)gameWindowsBounds.getCenterY() - WINDOW_HEIGHT/2;
        setLocation(posX, posY);
        setResizable(false);
        setTitle("Начать новую игру");
        setLayout(new GridLayout(10,1));
        addGameModeControls();
        addFieldControls();
        JButton btnStartGame = new JButton("Начать игру");
        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onBtnStartGameClick();
            }
        });
        add(btnStartGame);

    }
    private void addGameModeControls(){
        add(new JLabel("Выберите режим игры"));
        jrbHumVsAi = new JRadioButton("Человек против компьютера", true);
        jrbHumVsHum = new JRadioButton("Человек против человека");
        ButtonGroup grpMode = new ButtonGroup();
        grpMode.add(jrbHumVsAi);
        grpMode.add(jrbHumVsHum);

        add(jrbHumVsAi);
        add(jrbHumVsHum);
    }

    private void addFieldControls(){
        JLabel jlFieldSize = new JLabel(FIELD_SIZE_FREFIX + MIN_FIELD_SIZE);
        JLabel jlWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH);
        jsFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        jsWinLength = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_FIELD_SIZE);

        jsFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = jsFieldSize.getValue();
                jlFieldSize.setText(FIELD_SIZE_FREFIX + currentValue);
                jsWinLength.setMaximum(currentValue);
            }
        });
        jsWinLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                jlWinLength.setText(WIN_LENGTH_PREFIX + jsWinLength.getValue());
            }
        });

        add(new JLabel("Выберете размер поля"));
        add(jlFieldSize);
        add(jsFieldSize);
        add(new JLabel("Выберете выигрышную длину"));
        add(jlWinLength);
        add(jsWinLength);
    }

    private void onBtnStartGameClick(){
        int gameMode;
        if (jrbHumVsHum.isSelected()){
            gameMode = Map.MODE_HVH;
        } else if (jrbHumVsAi.isSelected()){
            gameMode = Map.MODE_HVA;
        } else {
            throw new RuntimeException("Unknow game mode");
        }
        int fieldSize = jsFieldSize.getValue();
        int winLength = jsWinLength.getValue();
        gameWindow.startNewGame(gameMode, fieldSize, fieldSize, winLength);
        setVisible(false);
    }
}
