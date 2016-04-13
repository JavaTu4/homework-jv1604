package homework3;

import java.util.Arrays;

/**Created by tu4.**/
public class Dz_3_3 {
    public static void main(String[] args) {
        int[][] array = new int[5][3];
        int i, j, k = 0;
        for (i = 0; i < array.length; i++) {
            for (j = 0; j < array[i].length; j++) {
                array[i][j] = k;
                k += 5;
            }
        }
        System.out.println("Оригинальная матрица\n");
        for (i = 0; i < array.length; i++) {
            for (j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
        int[][] trmas = transponirovanie(array);
        System.out.println("Транспонированная матрица\n");
        for (int a = 0; a < trmas.length; a++) {
            System.out.println(Arrays.toString(trmas[a]));
        }
    }

    public static int[][] transponirovanie(int[][] array) {
        int sizestr = array[0].length;
        int sizestolb = array.length;
        int[][] transarray = new int[sizestr][sizestolb];
        for (int i = 0; i < sizestr; i++) {
            for (int j = 0; j < sizestolb; j++) {
                transarray[i][j] = array[j][i];
            }
        }
        return transarray;
    }
}