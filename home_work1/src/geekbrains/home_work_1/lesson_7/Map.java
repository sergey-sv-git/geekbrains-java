package geekbrains.home_work_1.lesson_7;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {
    public static final int MODE_HVH = 0;
    public static final int MODE_HVA = 1;
    private static JButton[] arrButton;
    private int fieldSize;

    Map(){
        setBackground(Color.BLUE);

//        setLayout(new GridLayout(15, 15));
//        for (int i = 0; i < 15*15 ; i++) {
//            JButton but = new JButton();
//            add(but);
//        }
//        setVisible(true);

    }
    Map(int fieldSize){
                this.fieldSize = fieldSize;
        setLayout(new GridLayout(fieldSize , fieldSize));
        arrButton = new JButton[fieldSize*fieldSize];
        for (int i = 0; i < arrButton.length ; i++) {
            arrButton[i] = new JButton();
            add(arrButton[i]);
        }
        setVisible(true);
    }

    void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLength){
        System.out.printf("mode = %d\nfsX = %d\nwin = %d", gameMode, fieldSizeX, winLength);
        new Map(fieldSizeX);
//        this.setFieldSizeX(fieldSizeX);
    }

    private void setFieldSizeX (int fieldSizeX){
        setLayout(new GridLayout(fieldSizeX , fieldSizeX));
        arrButton = new JButton[fieldSizeX*fieldSizeX];
        for (int i = 0; i < arrButton.length ; i++) {
            arrButton[i] = new JButton();
            add(arrButton[i]);
        }
        setVisible(true);
    }
}
