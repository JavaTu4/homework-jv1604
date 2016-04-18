package homework3;

/**
 * Created by root on 18.04.16.
 */
public class ArraysHomeWork {
    public static void main(String[] args) throws Exception {
        int option;
        do {
            System.out.println("Введите соответствующее значение:");
            System.out.println("\'1\' Сдвиговые операции с одномерными массивами");
            System.out.println("\'2\' Сдвиговые операции с двумерными массивами");
            System.out.println("\'3\' Транспонирование матрицы");
            System.out.println("Сделайте ваш выбор :");
            option = M.readInt();
        }
        while (option < 1 || option > 3);
        switch (option) {
            case 1: {
                int option1;
                do {
                    System.out.println("Введите соответствующее значение:");
                    System.out.println("\'1\' Ввести колличество элементов массива и значение каждого элемента вручную");
                    System.out.println("\'2\' Ввести колличество элементов массива вручную, значения автоматически по зависимости");
                    System.out.println("\'3\' Использовать стандартное значение: 13 элементов, значения от 1 до 13");
                    option1 = M.readInt();
                }
                while (option1 < 1 || option1 > 3);
                switch (option1) {
                    case 1: {
                        moves(manualInputArray());
                    }
                    break;
                    case 2: {
                        moves(dynamicInputArray());
                    }
                    break;
                    case 3: {
                        moves(defaultArray());
                    }
                }
            }break;
            case 2: {
                int option2;
                do {
                    System.out.println("Введите соответствующее значение:");
                    System.out.println("\'1\' Ввести колличество строк и столбцов массива вручную, также значение каждого элемента вручную");
                    System.out.println("\'2\' Ввести колличество строк и столбцов вручную, значения автоматически по зависимости");
                    System.out.println("\'3\' Использовать стандартное значение: 5 строк , 7 столбцов, значения от 1 до 35");
                    option2 = M.readInt();
                }
                while (option2 < 1 || option2 > 3);
                switch (option2) {
                    case 1:{
                        moves(manualInputArray2d());
                    }break;
                    case 2:{
                        moves(dynamicInputArray2d());
                    }break;
                    case 3:{
                        moves(defaultArray2d());
                    }break;
                }
            }break;
            case 3:{
                int option3;
                do {
                    System.out.println("Введите соответствующее значение:");
                    System.out.println("\'1\' Ввести колличество строк и столбцов массива вручную, также значение каждого элемента вручную");
                    System.out.println("\'2\' Ввести колличество строк и столбцов вручную, значения автоматически по зависимости");
                    System.out.println("\'3\' Использовать стандартное значение: 5 строк , 7 столбцов, значения от 1 до 35");
                    option3 = M.readInt();
                }
                while (option3 < 1 || option3 > 3);
                switch (option3) {
                    case 1:{
                        M.printArray(M.toTranspose(manualInputArray2d()));
                        System.out.println("Транспонированная матрица");
                    }break;
                    case 2:{
                        M.printArray(M.toTranspose(dynamicInputArray2d()));
                        System.out.println("Транспонированная матрица");
                    }break;
                    case 3:{
                        M.printArray(M.toTranspose(defaultArray2d()));
                        System.out.println("Транспонированная матрица");
                    }break;
                }
            }


        }
    }

    public static void moves(int[] array) throws Exception {
        int option;
        do{
            System.out.println("Введите соответствующее значение:");
            System.out.println("\'1\' Сдвиг вправо");
            System.out.println("\'2\' Сдвиг влево");
            option = M.readInt();
        }
        while (option < 1 || option > 2);
        switch (option){
            case 1:{
                System.out.println("Введите колличество позиций для сдвига вправо:");
                M.moveRight(array,M.readInt());
            }break;
            case 2:{
                System.out.println("Введите колличество позиций для сдвига влево:");
                M.moveLeft(array,M.readInt());
            }
        }
    }

    public static void moves(int[][] array) throws Exception {
        int option;
        do{
            System.out.println("Введите соответствующее значение:");
            System.out.println("\'1\' Сдвиг вправо");
            System.out.println("\'2\' Сдвиг влево");
            System.out.println("\'3\' Сдвиг вверх");
            System.out.println("\'4\' Сдвиг вниз");
            option = M.readInt();
        }
        while (option < 1 || option > 4);
        switch (option){
            case 1:{
                System.out.println("Введите колличество позиций для сдвига вправо:");
                M.moveRight(array,M.readInt());
            }break;
            case 2:{
                System.out.println("Введите колличество позиций для сдвига влево:");
                M.moveLeft(array,M.readInt());
            }break;
            case 3:{
                System.out.println("Введите колличество позиций для сдвига вверх:");
                M.moveUp(array,M.readInt());
            }break;
            case 4:{
                System.out.println("Введите колличество позиций для сдвига вниз:");
                M.moveDown(array,M.readInt());
            }break;
        }
    }

    public static int [] manualInputArray() throws Exception {
        int [] array;
        System.out.println("Введите колличество элементов массива:");
        array = new int[M.readInt()];
        for (int i = 0;i < array.length;i++){
            System.out.println("Введите значение "+ (i+1) +" элемента:");
            array[i] = M.readInt();
        }
        System.out.println("Оригинальный массив");
        M.printArray(array);
        return array;
    }

    public static int [][] manualInputArray2d() throws Exception {
        int [][] array;
        System.out.println("Введите колличество строк и столбцов массива:");
        array = new int[M.readInt()][M.readInt()];
        for (int j = 0;j < array.length;j++) {
            for (int i = 0; i < array[j].length; i++) {
                System.out.println("Введите значение " + (i + 1) + " элемента " +(j+1)+ " строки массива");
                array[j][i] = M.readInt();
            }
        }
        System.out.println("Оригинальный массив");
        M.printArray(array);
        return array;
    }

    public static int[] dynamicInputArray() throws Exception {
        int array[];
        System.out.println("Введите колличество элементов массива:");
        array = new int[M.readInt()];
        System.out.println("Введите значение первого элемента массива");
        int k = M.readInt();
        System.out.println("Введите значение зависимости по которой будут изменятся следующие элементы");
        int z = M.readInt();
        for (int i = 0;i < array.length;i++){
            array[i] = k;
            k += z;
        }
        System.out.println("Оригинальный массив");
        M.printArray(array);
        return array;
    }

    public static int[][] dynamicInputArray2d() throws Exception {
        int array[][];
        System.out.println("Введите колличество строк и столбцов массива:");
        array = new int[M.readInt()][M.readInt()];
        System.out.println("Введите значение первого элемента первой строки массива");
        int k = M.readInt();
        System.out.println("Введите значение зависимости по которой будут изменятся следующие элементы");
        int z = M.readInt();
        for (int j = 0;j < array.length;j++) {
            for (int i = 0; i < array[j].length; i++) {
                array[j][i] = k;
                k += z;
            }
        }
        System.out.println("Оригинальный массив");
        M.printArray(array);
        return array;
    }

    public static int[] defaultArray(){
        int[] array = new int[13];
        int k = 1;
        for (int i = 0;i < array.length;i++){
            array[i] = k;
            k++;
        }
        System.out.println("Оригинальный массив");
        M.printArray(array);
        return array;
    }

    public static int[][] defaultArray2d(){
        int [][] array = new int[5][7];
        int k = 1;
        for (int j = 0;j < array.length;j++) {
            for (int i = 0; i < array[j].length; i++) {
                array[j][i] = k;
                k++;
            }
        }
        System.out.println("Оригинальный массив");
        M.printArray(array);
        return array;
    }

}
