package homework2;

import java.util.Scanner;

public class Chisla {
    public static void main(String[] args) throws Exception {
            int input;
            do {
                System.out.println("Введите число от \"1\" до \"99\"");
                input = readInt();
            }
            while (input < 0 || input > 99);

            int des = input / 10;
            switch (input) {
                case 0: {
                    System.out.println("Ноль");
                }break;
                case 10: {
                    System.out.println("Десять");
                }break;
                case 11: {
                    System.out.println("Одинадцать");
                }break;
                case 12: {
                    System.out.println("Двенадцать");
                }break;
                case 13: {
                    System.out.println("Тринадцать");
                }break;
                case 14: {
                    System.out.println("Четырнадцать");
                }break;
                case 15: {
                    System.out.println("Пятнадцать");
                }break;
                case 16: {
                    System.out.println("Шестнадцать");
                }break;
                case 17: {
                    System.out.println("Семнадцать");
                }break;
                case 18: {
                    System.out.println("Восемнадцать");
                }break;
                case 19: {
                    System.out.println("Девятнадцать");
                }break;
            }
            switch (des) {
                case 2: {
                    System.out.print("Двадцать ");
                }break;
                case 3: {
                    System.out.print("Тридцать ");
                }break;
                case 4: {
                    System.out.print("Сорок ");
                }break;
                case 5: {
                    System.out.print("Пятдесят ");
                }break;
                case 6: {
                    System.out.print("Шестьдесят ");
                }break;
                case 7: {
                    System.out.print("Семьдесят ");
                }break;
                case 8: {
                    System.out.print("Восемьдесят ");
                }break;
                case 9: {
                    System.out.print("Девяносто ");
                }break;
            }
            if (input > 10 && input < 20);
            else {
                int ed = input % 10;
                switch (ed) {
                    case 1: {
                        System.out.println("один");
                    }break;
                    case 2: {
                        System.out.println("два");
                    }break;
                    case 3: {
                        System.out.println("три");
                    }break;
                    case 4: {
                        System.out.println("четыре");
                    }break;
                    case 5: {
                        System.out.println("пять");
                    }break;
                    case 6: {
                        System.out.println("шесть");
                    }break;
                    case 7: {
                        System.out.println("семь");
                    }break;
                    case 8: {
                        System.out.println("восемь");
                    }break;
                    case 9: {
                        System.out.println("девять");
                    }break;
                }
            }
        }

    private static int readInt() throws Exception {
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


