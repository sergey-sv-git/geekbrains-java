package geekbrains.home_work_1;
import java.util.Scanner;
import java.util.Random;

public class TicToe {

    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';
    private static final char DOT_EMPTY = '.';
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    private static char[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;
    private static int vin = 4; // условие выигрыша, можно варьировать

    private static void initField(){
        fieldSizeY = 5;
        fieldSizeX = 5;
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    private static void printField(){
        System.out.print("+");
        for (int i = 0; i < fieldSizeX * 2 + 1; i++)
            System.out.print((i % 2 == 0) ? "-" : i / 2 + 1);
        System.out.println();

        for (int i = 0; i < fieldSizeX; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < fieldSizeX; j++)
                System.out.print(field[i][j] + "|");
            System.out.println();
        }

        for (int i = 0; i < fieldSizeX * 2 + 1; i++)
            System.out.print("-");
        System.out.println();
    }

    private static void humanTurn(){
        int x;
        int y;
        do {
            System.out.println("Введите, пожалуйста, координаты X от 1 до 5 и Y от 1 до 5 ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isValidCell(x, y) || !isEmptyCell(x, y));
        field[y][x] = DOT_HUMAN;
    }

    private static boolean isValidCell(int x, int y){
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    private static boolean isEmptyCell(int x, int y){
        return field[y][x] == DOT_EMPTY;
    }

    private static void aiTurn(){
        int x;
        int y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isValidCell(x, y) || !isEmptyCell(x, y));
        field[y][x] = DOT_AI;
    }
    private static void aiTurn (int bestX, int bestY) {
        if (isEmptyCell(bestX,bestY)&&isValidCell(bestX, bestY)){
            field[bestY][bestX] = DOT_AI;}
        else aiTurn();
    }

    private static boolean checkWin (char c){
        int tempVin;
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isValidCell(x+3,y)){
                    tempVin = 0;
                    for (int i = 0; i < 4; i++) {
                        if ((field[y][x+i]) == c) tempVin++;
                        if (tempVin == vin) return true;
                    }
                }
                if (isValidCell(y, x + 3)) {
                    tempVin = 0;
                    for (int i = 0; i < 4; i++) {
                        if ((field[x+i][y] == c)) tempVin++;
                        if (tempVin == vin) return true;
                    }
                }
                if (isValidCell(x+3, y+3)){
                    tempVin = 0;
                    for (int i = 0; i < 4; i++) {
                        if ((field[y+i][x+i]) == c) tempVin++;
                        if (tempVin == vin) return true;
                    }
                }
                if (isValidCell(x+3, y-3)){
                    tempVin = 0;
                    for (int i = 0; i < 4; i++) {
                        if (field[y-i][x+i] == c) tempVin++;
                        if (tempVin == vin) return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean isDraw (){
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == DOT_EMPTY) return false;
            }
        }
        return true;
    }
    private static void checkTurn(char c){
        int tempX = 2;
        int tempY = 2;
        int tempVin;
        int bestX = 2;
        int bestY = 2;
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isValidCell(x+3,y)){
                    tempVin = 0;
                    for (int i = 0; i < 4; i++) {
                        if (field[y][x+i] == c) tempVin++;
                        else if (field[y][x+i] == DOT_EMPTY){
                            tempX = x + i;
                            tempY = y;
                        }
                    }
                    if ((tempVin==(vin - 1))&&(field[tempY][tempX]==DOT_EMPTY)){
                        bestX = tempX;
                        bestY = tempY;
                    }
                }
                if (isValidCell(y, x + 3)) {
                    tempVin = 0;
                    for (int i = 0; i < 4; i++) {
                        if (field[x+i][y] == c) tempVin++;
                        else if (field[x+i][y] == DOT_EMPTY){
                            tempX = y;
                            tempY = x + i;
                        }
                    }
                    if ((tempVin==(vin - 1))&&(field[tempY][tempX]==DOT_EMPTY)){
                        bestX = tempX;
                        bestY = tempY;
                    }
                }
                if (isValidCell(x+3, y+3)){
                    tempVin = 0;
                    for (int i = 0; i < 4; i++) {
                        if (field[y+i][x+i] == c) tempVin++;
                        else if (field[y+i][x+i] == DOT_EMPTY){
                            tempX = y + i;
                            tempY = x + i;
                        }
                    }
                    if ((tempVin==(vin - 1))&&(field[tempY][tempX]==DOT_EMPTY)){
                        bestX = tempX;
                        bestY = tempY;
                    }
                }
                if (isValidCell(x+3, y-3)){
                    tempVin = 0;
                    for (int i = 0; i < 4; i++) {
                        if (field[y-i][x+i] == c) tempVin++;
                        else if (field[y-i][x+i] == DOT_EMPTY){
                            tempX = x + i;
                            tempY = y - i;
                        }
                    }
                    if ((tempVin==(vin - 1))&&(field[tempY][tempX]==DOT_EMPTY)){
                        bestX = tempX;
                        bestY = tempY;
                    }
                }
            }
        }

        if((tempX==2)&&(tempY==2)&&(c!=DOT_AI)){  //если лучшие варианты за игрока не найдены
            checkTurn(DOT_AI);  // ищем лучшие варианты за компьютер
            aiTurn(bestX,bestY);
            return;
        }
        aiTurn(bestX,bestY);
    }

    public static void main(String[] args) {
        initField();
        printField();
        while (true){
            humanTurn();
            printField();
            if (checkWin(DOT_HUMAN)){
                System.out.println("Human win!");
                break;
            }
            if (isDraw()){
                System.out.println("Draw!");
                break;
            }
            vin=3;//для проверки шанса выиграть
            if (checkWin(DOT_AI)){
                vin = 4;
                checkTurn(DOT_AI);
            }
            else if (checkWin(DOT_HUMAN)){
                vin = 4;
                checkTurn(DOT_HUMAN);
            }
            else {
                aiTurn();
            }
            vin = 4;
            printField();
            if (checkWin(DOT_AI)){
                System.out.println("Computer win!");
                break;
            }
            if (isDraw()){
                System.out.println("Draw!");
                break;
            }
        }
    }
}