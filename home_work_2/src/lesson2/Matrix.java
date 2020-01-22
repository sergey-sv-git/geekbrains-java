package lesson2;

public class Matrix {

    public static String[][] matrix (String s) throws MatrixException{
        char[] c = s.toCharArray();
        int countY = 1;
        int countX = 1;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '\n') countY++;
            if (c[i] == ' ') countX++;
        }
        countX = (countX + (countY-1))/countY;
        if ((countX != 4)||(countY != 4)){
            throw new MatrixException();
        }
        String[][] massive = new String[countY][countX]; // определили размер массива и создали его
        int i = 0;
        String a = "";
        for (int j = 0; j < countY; j++) {
            for (int k = 0; k < countX; k++) {
                while ((i < c.length)&&(c[i] != '\n')&&(c[i] != ' ')){
                    a += String.valueOf(c[i]);
                    i++;
                }
                massive[j][k] = a;
                a = "";
                i++;
            }
        }
        return massive;
    }

    public static int [][] toInt (String[][] massive) throws SymbolException{
        int [][] massiveInt = new int[massive.length][massive[0].length];
        for (int i = 0; i < massive.length; i++) {
            for (int j = 0; j < massive[i].length; j++) {
                try {
                    massiveInt[i][j] = Integer.parseInt(massive[i][j]);
                }
                catch (NumberFormatException e){
                    throw new SymbolException();
                }
            }
        }
        return massiveInt;
    }

    public static int arithmetic (int[][] massiveInt){
        int result = 0;
        for (int i = 0; i < massiveInt.length; i++) {
            for (int j = 0; j < massiveInt[i].length; j++) {
                result += massiveInt[i][j];
            }
        }
        return result/2;
    }

    public static void main(String[] args) {
        String s = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        try {
            String [][] massive = matrix(s);
            for (int j = 0; j < massive.length; j++) {
                for (int k = 0; k < massive[j].length; k++) {
                    System.out.print(massive[j][k] + " ");
                }
                System.out.println();
            }
            System.out.println(arithmetic(toInt(massive)));
        }
        catch (MatrixException e){
            System.out.println("Массив должен быть размером 4х4");
            e.printStackTrace();
        }
        catch (SymbolException e){
            System.out.println("В одной из ячеек полученной матрицы не число");
            e.printStackTrace();
        }
    }
}
