package homework3;

import java.util.Arrays;

/** Created by {Seleznov JV1604 UITS}*/
public class Dz_3_1 {
    public static void main(String[] args) {
        int[] original = new int [13];
        int q = 1;
        for (int i = 0;i < original.length;i++){
            original[i] = q;
            q++;
        }
        int[] original1 = new int [original.length];
        System.arraycopy(original,0,original1,0,original.length);
        System.out.println("Оригинальный одномерный массив из "+original.length+" элементов:");
        System.out.println("\t"+Arrays.toString(original)+"\t\n");
        int n = 3;
        moveRight(original,n);
        System.out.println("Массив сдвинутый на "+n+" позиции вправо:");
        System.out.println("\t"+Arrays.toString(original)+"\t\n");

        moveLeft(original1,n);
        System.out.println("Массив сдвинутый на "+n+" позиции влево:");
        System.out.print("\t"+Arrays.toString(original1)+"\t");
    }
    private static void moveRight(int[] array, int positions) {
        int size = array.length;
        for (int i = 0; i < positions; i++) {
            int temp = array[size - 1];
            for (int j = size - 1; j > 0; j--) {
                array[j] = array[j-1];
            }
            array[0] = temp;
        }
    }

    private static void moveLeft(int[] array, int positions){
        int size = array.length;
        for (int i = 0;i < positions;i++){
            int temp = array[0];
            for (int j = 0;j < size - 1; j++){
                array[j] = array[j + 1];
            }
            array[size - 1] = temp;
        }
    }
}
