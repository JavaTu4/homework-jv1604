package homework2;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Dz2_2
{

        public static void main(String[] args) throws Exception
        {
            System.out.println("Введите число от \"1\" до \"99\"");

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String vvod = reader.readLine();
            int v = Integer.parseInt(vvod);

            int des = v / 10;

            switch (v) {
                case 0:{
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


            if (v > 20 && v < 100 || v >= 0 && v < 10)
            {
                int ed = v % 10;

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
            else if (v > 99 || v < 0)
            {
                System.out.println("Вы ввели неправильное значение!");
            }
        }
    }
