package geekbrains.home_work_1;
import java.util.Scanner;
import java.util.Random;

public class TicToe {

    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';
    private static final char DOT_EMPTY = '.';
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();
    private static int bestX;
    private static int bestY;

    private static char[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;
    private static int vin = 4; // условие выигрыша

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
        return x >= 0 && x <= fieldSizeX && y >= 0 && y <= fieldSizeY;
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
        if (isEmptyCell(bestX,bestY)&&isValidCell(bestX, bestY)) {
            field[bestY][bestX] = DOT_AI;
        }
        else aiTurn();
    }

    private static boolean checkWin (char c){
        int Horizont, Vertical, Diag1, Diag2, Diag3, Diag4, Diag5, Diag6;
        for (int y = 0; y < fieldSizeY; y++) {
            Horizont = 0;
            Vertical = 0;
            Diag1 = 0;
            Diag2 = 0;
            Diag3 = 0;
            Diag4 = 0;
            Diag5 = 0;
            Diag6 = 0;
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == c) Horizont++;
                if (field[x][y] == c) Vertical++;
                if (field[x][x] == c) Diag1++;
                if (field[x][fieldSizeX - 1 - x] == c) Diag2++;
                if ((x+1) < fieldSizeX && field[x][x+1] == c) Diag3++;
                if (fieldSizeX-2-x > 0 && field[x][fieldSizeX-2-x] == c) Diag4++;
                if ((x+1) < fieldSizeY && field[x+1][x] == c) Diag5++;
                if (fieldSizeY-2-x > 0 && field[fieldSizeY-2-x][x] == c) Diag6++;

                if (((Horizont==vin && field[y][0]!=c)||(Horizont==vin && field[y][fieldSizeX-1]!=c))||(Horizont==5)) return true;
                if (((Vertical==vin && field[fieldSizeY-1][y]!=c) || (Vertical==vin && field[0][y]!=c))||(Vertical==5)) return true;
                if (((Diag1==vin && field[0][0]!=c)||(Diag1==vin && field[fieldSizeY-1][fieldSizeX-1]!=c))||(Diag1==5)) return true;
                if (((Diag2==vin && field[0][fieldSizeX-1]!=c)||(Diag2==vin && field[fieldSizeY-1][0]!=c))||(Diag2==5)) return true;
                if (Diag3==vin||Diag4==vin||Diag5==vin||Diag6==vin) return true;
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
        int Horizont, Vertical, Diag1, Diag2, Diag3, Diag4, Diag5, Diag6;
        for (int y = 0; y < fieldSizeY; y++) {
            Horizont = 0;
            Vertical = 0;
            Diag1 = 0;
            Diag2 = 0;
            Diag3 = 0;
            Diag4 = 0;
            Diag5 = 0;
            Diag6 = 0;
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == c) Horizont++;
                else if ((Horizont>=3)&&(field[y][x]==DOT_EMPTY)){
                    bestX = x;
                    bestY = y;
                }
                if (field[x][y] == c) Vertical++;
                else if ((Vertical>=3)&&(field[y][x]==DOT_EMPTY)){
                    bestX = x;
                    bestY = y;
                }
                if (field[x][x] == c) Diag1++;
                else if ((Diag1>=3)&&(field[y][x]==DOT_EMPTY)){
                    bestX = x;
                    bestY = y;
                }
                if (field[x][fieldSizeX - 1 - x] == c) Diag2++;
                else if ((Diag2>=3)&&(field[y][x]==DOT_EMPTY)){
                    bestX = x;
                    bestY = y;
                }
                if ((x+1) < fieldSizeX && field[x][x+1] == c) Diag3++;
                else if ((Diag3>=3)&&(field[y][x]==DOT_EMPTY)){
                    bestX = x;
                    bestY = y;
                }
                if (fieldSizeX-2-x > 0 && field[x][fieldSizeX-2-x] == c) Diag4++;
                else if ((Diag4>=3)&&(field[y][x]==DOT_EMPTY)){
                    bestX = x;
                    bestY = y;
                }
                if ((x+1) < fieldSizeY && field[x+1][x] == c) Diag5++;
                else if ((Diag5>=3)&&(field[y][x]==DOT_EMPTY)){
                    bestX = x;
                    bestY = y;
                }
                if (fieldSizeY-2-x > 0 && field[fieldSizeY-2-x][x] == c) Diag6++;
                else if ((Diag6>=3)&&(field[y][x]==DOT_EMPTY)){
                    bestX = x;
                    bestY = y;
                }
            }
        }
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
            vin--;//для проверки угрозы проигрыша/выигрыша
            if (checkWin(DOT_AI)){
                checkTurn(DOT_AI);
                aiTurn(bestX,bestY);
            }
            else if (checkWin(DOT_HUMAN)){
                checkTurn(DOT_HUMAN);
                aiTurn(bestX,bestY);
            }
            else {
                aiTurn();
            }
            printField();
            vin++;//возвращаем условие выигрыша
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