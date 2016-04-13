package homework3;

/** Created by tu4 on 4/6/16. */
public class Dz_3_4 {
    public static void main(String[] args) {
        int [][] array = new int[10][];
        for (int i = 0;i < array.length;i++){
           // for (int j = 1;j < array.length;j++){
            array[i] = new int[i + 1];
            //}
        }
        int k = 0;
        for (int a = 0;a < array.length;a++){
            for (int b = 0;b < a + 1;b++){
                array[a][b] = k;
                k++;
            }
        }
        for (int a = 0;a < array.length;a++) {
            for (int b = 0; b < a + 1; b++) {
                System.out.print(array[a][b] + "\t");
            }
            System.out.println();
        }
        System.out.println();

        for (int a = array.length - 1;a >= 0;a--) {
            for (int b = 0; b < a + 1; b++) {
                System.out.print(array[a][b] + "\t");
            }
            System.out.println();

        }
        System.out.println();

    }
}
