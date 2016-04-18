package homework3;

import java.util.Scanner;

/**
 * Created by root on 18.04.16.
 */
public class M {

    public static void printArray(int[] array){
        for (int i = 0;i < array.length;i++){
            System.out.print(array[i]+"\t");
        }
        System.out.println("\n");
    }

    public static void printArray(int[][] array){
        System.out.println();
        for (int i = 0;i < array.length;i++){
            for (int j = 0;j < array[i].length;j++){
                System.out.print(array[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    public static void moveRight(int[] array, int positions) {
        int  realPositions = positions % array.length;
        int size = array.length;
        for (int i = 0; i < realPositions; i++) {
            int temp = array[size - 1];
            for (int j = size - 1; j > 0; j--) {
                array[j] = array[j-1];
            }
            array[0] = temp;
        }
        System.out.println("Массив сдвинутый на "+positions+" позиции вправо:");
        printArray(array);
    }

    public static void moveLeft(int[] array, int positions){
        int  realPositions = positions % array.length;
        int size = array.length;
        for (int i = 0;i < realPositions;i++){
            int temp = array[0];
            for (int j = 0;j < size - 1; j++){
                array[j] = array[j + 1];
            }
            array[size - 1] = temp;
        }
        System.out.println("Массив сдвинутый на "+positions+" позиции влево:");
        printArray(array);
    }

    public static void moveLeft(int[][] array, int positions) {
        int  realPositions = positions % array[0].length;
        int size1 = array.length;
        int size2 = array[0].length;
        for (int a = 0; a < realPositions; a++) {
            for (int b = 0; b < size1; b++) {
                int temp = array[b][0];
                for (int c = 0; c < size2 - 1; c++) {
                    array[b][c] = array[b][c + 1];
                }
                array[b][size2 - 1] = temp;
            }
        }
        System.out.println("Массив сдвинутый на " + positions + " позиции влево:");
        printArray(array);
    }

    public static void moveRight(int[][] array, int positions) {
        int  realPositions = positions % array[0].length;
        int size1 = array.length;
        int size2 = array[0].length;
        for (int a = 0; a < realPositions; a++) {
            for (int b = 0; b < size1; b++) {
                int temp = array[b][size2 - 1];
                for (int c = size2 - 1;c > 0; c--) {
                    array[b][c] = array[b][c - 1];
                }
                array[b][0] = temp;
            }
        }
        System.out.println("Массив сдвинутый на " + positions + " позиции вправо:");
        printArray(array);
    }

    public static void moveDown(int[][] array, int positions){
        int  realPositions = positions % array.length;
        int size = array.length;
        for (int i = 0;i < realPositions;i++){
            int[] temp = array[size - 1];
            for (int j = size - 1;j > 0;j--){
                array[j] = array[j - 1];
            }
            array[0] = temp;
        }
        System.out.println("Массив сдвинутый на " + positions + " позиции вниз:");
        printArray(array);
    }

    public static void moveUp(int[][] array, int positions){
        int  realPositions = positions % array.length;
        int size = array.length;
        for (int i = 0;i < realPositions;i++){
            int[]temp = array[0];
            for (int j = 0;j < size - 1;j++){
                array[j] = array[j + 1];
            }
            array[size - 1] = temp;
        }
        System.out.println("Массив сдвинутый на " + positions + " позиции вверх:");
        printArray(array);

    }

    public static int[][] toTranspose(int[][] array) {
        int size1 = array[0].length;
        int size2 = array.length;
        int[][] transposedArray = new int[size1][size2];
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                transposedArray[i][j] = array[j][i];
            }
        }
        return transposedArray;
    }

    public static int readInt() throws Exception {
        Scanner sc = new Scanner(System.in);
        int input = 0;
        if (!sc.hasNextInt()){
            System.out.println("Вы ввели не число, попоробуйте еще раз");
            readInt();
        }
        else {
            input = sc.nextInt();
        }
        return input;
    }


}
