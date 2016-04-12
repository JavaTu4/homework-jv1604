package homework3;

import java.util.Arrays;

/**
 * Created by method.
 **/
public class Dz_3_2 {
    public static void main(String[] args) {
        int[][] array = new int[7][5];
        int array1 [][] = new int[array.length][array[0].length];
        int array2 [][] = new int[array.length][array[0].length];
        int array3 [][] = new int[array.length][array[0].length];
        int array4 [][] = new int[array.length][array[0].length];
        int i, j, k = 10;
        for (i = 0; i < array.length; i++) {
            for (j = 0; j < array[0].length; j++) {
                array[i][j] = k;
                array1[i][j] = k;
                array2[i][j] = k;
                array3[i][j] = k;
                array4[i][j] = k;
                k += 2;
            }
        }

        System.out.println("Оригинальный двумерный массив из " + array.length + " строк и " + array[0].length + " столбцов:");
        for (int m = 0; m < array.length; m++) {
            System.out.println(Arrays.toString(array[m]));
        }
        System.out.println();
        int n = 4;

        int[][] ms = sdLeft(array1, n);
        System.out.println("Массив сдвинутый на " + n + " позиции влево:\n");
        for (int a = 0; a < ms.length; a++) {
            System.out.println(Arrays.toString(ms[a]));
        }
        System.out.println();

        int [][] ms1 = sdRight(array2,n);
        System.out.println("Массив сдвинутый на " + n + " позиции вправо:\n");
        for (int a = 0; a < ms1.length; a++) {
            System.out.println(Arrays.toString(ms1[a]));
        }
        System.out.println();

        int [][] ms2 = sdUp(array3,n);
        System.out.println("Массив сдвинутый на " + n + " позиции вверх:\n");
        for (int a = 0; a < ms2.length; a++) {
            System.out.println(Arrays.toString(ms2[a]));
        }
        System.out.println();

        int [][] ms3 = sdDown(array4,n);
        System.out.println("Массив сдвинутый на " + n + " позиции вниз:\n");
        for (int a = 0; a < ms3.length; a++) {
            System.out.println(Arrays.toString(ms3[a]));
        }
        System.out.println();

    }

    public static int [][] sdLeft(int[][] mas, int pos) {
        int size1 = mas.length;
        int size2 = mas[0].length;
        for (int a = 0; a < pos; a++) {
            for (int b = 0; b < size1; b++) {
                int temp = mas[b][0];
                for (int c = 0; c < size2 - 1; c++) {
                    mas[b][c] = mas[b][c + 1];
                }
                mas[b][size2 - 1] = temp;
            }
        }
        return mas;
    }
    public static int [][] sdRight(int[][] mas, int pos) {
        int size1 = mas.length;
        int size2 = mas[0].length;
        for (int a = 0; a < pos; a++) {
            for (int b = 0; b < size1; b++) {
                int temp = mas[b][size2 - 1];
                for (int c = size2 - 1;c > 0; c--) {
                    mas[b][c] = mas[b][c - 1];
                }
                mas[b][0] = temp;
            }
        }
        return mas;
    }
    public static int [][] sdDown(int[][] array, int positions){
        int size = array.length;
        for (int i = 0;i < positions;i++){
            int[]mas = array[size - 1];
            for (int j = size - 1;j > 0;j--){
                array[j] = array[j - 1];
            }
            array[0] = mas;
        }
        return array;
    }
    public static int [][] sdUp(int[][] array, int positions){
        int size = array.length;
        for (int i = 0;i < positions;i++){
            int[]mas = array[0];
            for (int j = 0;j < size - 1;j++){
                array[j] = array[j + 1];
            }
            array[size - 1] = mas;
        }
        return array;
    }
}