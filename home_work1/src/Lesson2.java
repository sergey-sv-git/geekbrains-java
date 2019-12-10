import java.util.Arrays;

public class Lesson2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(invertArray(new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0})));
        System.out.println(Arrays.toString(fillArray(new int[8])));
        System.out.println(Arrays.toString(changeArray(new int[]{ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 })));
        minAndMax();
        fillDiagonal();
        System.out.println(checkBalance(new int[]{ 2, 2, 2, 1, 2, 2, 10, 1 }));
        System.out.println(Arrays.toString(moveWithAddMassive(new int[]{ 5, 7, 3, 4, 3, 1, 10}, 2)));
        System.out.println(Arrays.toString(moveWithoutAddMassive(new int[]{ 5, 7, 3, 4, 3, 1, 10}, 2)));
     }

    public static int[] invertArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) arr[i] = 0;
            else arr[i] = 1;
        }
        return arr;
    }

    public static int[] fillArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i*3 + 1;
        }
        return arr;
    }

    public static int[] changeArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) arr[i] *= 2;
        }
        return arr;
    }

    public static void minAndMax(){
        int[] arr = { 5, 7, 15, 1, 8, 3, 11, 12 };
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
            else if (arr[i] > max) max = arr[i];
        }
        System.out.println("Минимум: " + min + " Максимум: " + max);
    }

    public static void fillDiagonal(){
        int[][] arr = new int[5][5];
        for (int i = 0; i < 5; i++) {
            arr[i][i] = 1;
            arr[i][4 - i] = 1;
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean checkBalance(int[] arr) {
        int sumLeft = 0;
        boolean result = false;
        for (int i = 0; i < arr.length; i++) {
            sumLeft += arr[i];
            int sumRight = 0;
            for (int j = i + 1; j < arr.length; j++) {
                sumRight += arr[j];
            }
            if (sumLeft == sumRight) result = true;
        }
        return result;
    }

    public static int[] moveWithAddMassive(int[] arr, int n){
        int[] arr2 = new int[arr.length];
        if (n > 0) {
            for (int i = 0; i < arr.length; i++) {
                int j = i + n - (arr.length) * ((i + n) / arr.length);
                arr2[j] = arr[i];
            }
        }
        else if (n < 0){
            for (int i = 0; i < arr.length; i++) {
                int j = i + n - arr.length*((i + n - arr.length +1)/ arr.length);
               arr2[j] = arr[i];
            }
        }
        return arr2;
    }

    public static int[] moveWithoutAddMassive(int[] arr, int n){
        if (n>0){
            for (int i = 0; i < n; i++) {
                moveRight(arr);
            }
        }
        if (n<0){
            for (int i = 0; i < -n; i++) {
                moveLeft(arr);
            }
        }
        return arr;
    }
    public static int[] moveRight(int[] arr){
        int a = arr[1];
        arr[1] = arr[0];
        int b = a;
        for (int i = 1; i < arr.length; i++) {
             if (i == arr.length - 1){
                 arr[0] = b;
        }
            else {
                b = arr[i + 1];
                arr [i + 1] = a;
                a = b;
            }
        }
        return arr;
    }
    public static int[] moveLeft(int[] arr){
        int a = arr[arr.length - 2];
        arr[arr.length - 2] = arr[arr.length - 1];
        int b = a;
        for (int i = arr.length - 2; i >=0; i--) {
            if (i == 0){
                arr[arr.length - 1] = b;
            }
            else {
                b = arr[i - 1];
                arr [i - 1] = a;
                a = b;
            }
        }
        return arr;
    }
}


