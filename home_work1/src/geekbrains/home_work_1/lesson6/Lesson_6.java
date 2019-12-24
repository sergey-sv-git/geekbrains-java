package geekbrains.home_work_1.lesson6;

import java.io.*;


public class Lesson_6 {
    public static void main(String[] args) {
        String file1 = "C:/Java/geekbrains-java/home_work1/src/geekbrains/home_work_1/lesson6/text1.txt";
        String file2 = "C:/Java/geekbrains-java/home_work1/src/geekbrains/home_work_1/lesson6/text2.txt";
        String file3 = "C:/Java/geekbrains-java/home_work1/src/geekbrains/home_work_1/lesson6/text3.txt";
        String directory = "C:/Java/geekbrains-java/home_work1/src/geekbrains/home_work_1/lesson6";
        combineFiles(file1, file2, file3);
        System.out.println(checkWordInFile("northern", file1)?"cлово в файле есть":"слова в файле нет");
        System.out.println(checkWordInDirectory("Yesenin",directory)? "слово в папке есть":"слова в папке нет");
    }

    public static void combineFiles(String file1, String file2, String file3){
        try  {
            FileInputStream fis1 = new FileInputStream(file1);
            FileInputStream fis2 = new FileInputStream(file2);
            FileOutputStream fos = new FileOutputStream(file3);
            int a, b;
            while ((a = fis1.read()) != -1){
                fos.write((char)a);
            }
            fis1.close();
            while ((b = fis2.read()) != -1){
                fos.write((char)b);
            }
            fis2.close();
            fos.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static boolean checkWordInFile(String word, String file){
        String s = "";
        try {
            FileInputStream fis = new FileInputStream(file);
            int b;
            while ((b = fis.read()) != -1){
                char a = (char)b;
                if (isCharLetter(a)) s += a;
                else if (s.equals(word)) return true;
                else s = "";
            }
            fis.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isCharLetter(char a){
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o','p',
                'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F','G', 'H',
                'I', 'J', 'K', 'L', 'M', 'N', 'O','P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        for (int i = 0; i < letters.length; i++) {
            if (a == letters[i]) return true;
            }
            return false;
    } // символ - это буква или нет

    public static boolean checkWordInDirectory(String word, String directory){
        File dir = new File(directory);
        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (checkWordInFile(word, files[i].getAbsolutePath())) return true;
        }
            return false;
    }
}
